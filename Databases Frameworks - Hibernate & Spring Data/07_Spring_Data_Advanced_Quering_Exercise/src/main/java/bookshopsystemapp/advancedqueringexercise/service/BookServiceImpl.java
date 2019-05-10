package bookshopsystemapp.advancedqueringexercise.service;

import bookshopsystemapp.advancedqueringexercise.domain.entities.*;
import bookshopsystemapp.advancedqueringexercise.repository.AuthorRepository;
import bookshopsystemapp.advancedqueringexercise.repository.BookRepository;
import bookshopsystemapp.advancedqueringexercise.repository.CategoryRepository;
import bookshopsystemapp.advancedqueringexercise.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\07_Spring_Data_Advanced_Quering_Exercise\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }


    @Override
    public List<String> bookTitleByAgeRestriction(String ageRestrictionStr) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionStr.toUpperCase());
        List<Book> books = this.bookRepository.findAllByAgeRestriction(ageRestriction);
        return books.stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> booksWithCopiesLessThan(String editionType, int numberOfCopies) {
        EditionType editionType1 = EditionType.valueOf(editionType.toUpperCase());
        List<Book> books = this.bookRepository.findAllByEditionTypeAndCopiesIsLessThan(editionType1, numberOfCopies);
        return books.stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> booksBetweenPrices(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Book> books = this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(minPrice, maxPrice);
        return books.stream()
                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksNotReleasedIn(String releaseDate) {
        LocalDate beforeReleaseDate = LocalDate.parse(releaseDate + "-01-01");
        LocalDate afterReleaseDate = LocalDate.parse(releaseDate + "-12-31");
        List<Book> books = this.bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(beforeReleaseDate, afterReleaseDate);
        return books.stream()
                .map(book -> book.getTitle()).collect(Collectors.toList());
    }

    @Override
    public String booksReleasedBeforeDate(String dateAsString) {
        LocalDate date =
                LocalDate.parse(dateAsString,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);
        List<String> titles = books.stream()
                .map(book -> book.getTitle()).collect(Collectors.toList());
        return String.join(System.lineSeparator(), titles);
    }

    @Override
    public String bookContainsLetters(String bookContainsStr) {

        List<Book> books = this.bookRepository.findAllByTitleContains(bookContainsStr.toLowerCase());
        List<String> booksNames = books.stream()
                .map(book -> book.getTitle()).collect(Collectors.toList());
        return String.join(System.lineSeparator(), booksNames);
    }

    @Override
    public List<String> titleOfBooksWrittenByAuthorsNamesStartWith(String nameStartsWith) {
        String nameArgs = nameStartsWith + "%";
        List<Book> books = this.bookRepository.findTitlesOfBooksWhichAuthorsLastNameStartsWith(nameArgs);
        return books.stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                            .collect(Collectors.toList());
    }

    @Override
    public int countOfBooksWithTitleLongerThanSymbols(int numberOfSymbols) {
        List<Book> books = this.bookRepository.countOfBooksWithTitleLongerThanSymbols(numberOfSymbols);
        return books.size();
    }

    @Override
    public List<Object[]> totalNumberOfCopiesByAuthorOrderByCopiesDesc() {
        return this.bookRepository.totalNumberOfCopiesByAuthorOrderByCopiesDesc();
    }

}
