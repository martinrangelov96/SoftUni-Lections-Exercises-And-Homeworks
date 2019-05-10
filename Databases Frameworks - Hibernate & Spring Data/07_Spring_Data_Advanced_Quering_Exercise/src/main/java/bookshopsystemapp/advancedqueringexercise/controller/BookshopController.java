package bookshopsystemapp.advancedqueringexercise.controller;

import bookshopsystemapp.advancedqueringexercise.service.AuthorService;
import bookshopsystemapp.advancedqueringexercise.service.BookService;
import bookshopsystemapp.advancedqueringexercise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Controller
public class BookshopController implements CommandLineRunner {

    private static final String BOOK_EDITION_TYPE_GOLD = "GOLD";
    private static final int BOOK_NUMBER_OF_COPIES_BELOW = 5000;
    private static final BigDecimal MIN_BOOK_PRICE = BigDecimal.valueOf(5);
    private static final BigDecimal MAX_BOOK_PRICE = BigDecimal.valueOf(40);

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();

        //Task 1.	Books Titles by Age Restriction
//        this.bookTitlesByAgeRestrictions();

        //Task 2.Golden Books
//        this.goldenBooks();

        //Task 3.Books by Price
//        this.booksByPrice();

        //Task 4.Not Released Books
//        this.bookNotReleasedIn();

        //Task 5.Books Released Before Date
//        this.booksReleasedBeforeDate();

        //Task 6.	Authors Search
//        this.authorsSearch();

        //Task 7.	Books Search
//        this.booksSearch();

        //Task 8.	Book Titles Search
//        this.bookTitlesSearch();

        //Task 9. Count Books
//        this.countBooks();

        //Task 10.	Total Book Copies
        this.totalBookCopies();
    }

    private void bookTitlesByAgeRestrictions() {
        Scanner scanner = new Scanner(System.in);
        String ageRestrictionStr = scanner.nextLine();

        this.bookService.bookTitleByAgeRestriction(ageRestrictionStr)
                .forEach(book -> System.out.println(book));

    }


    private void goldenBooks() {
//        Scanner scanner = new Scanner(System.in);
//        String editionType = scanner.nextLine();
//        int numberOfBooks = Integer.parseInt(scanner.nextLine());

        this.bookService.booksWithCopiesLessThan(BOOK_EDITION_TYPE_GOLD, BOOK_NUMBER_OF_COPIES_BELOW)
                .forEach(System.out::println);
    }


    private void booksByPrice() {
        this.bookService.booksBetweenPrices(MIN_BOOK_PRICE, MAX_BOOK_PRICE)
                .forEach(book -> System.out.println(book));
    }

    private void bookNotReleasedIn() {
        Scanner scanner = new Scanner(System.in);
        String releaseDate = scanner.nextLine();

        this.bookService.booksNotReleasedIn(releaseDate)
                .forEach(System.out::println);
    }


    private void booksReleasedBeforeDate() {
        Scanner scanner = new Scanner(System.in);
        String dateAsString = scanner.nextLine();

        String result = this.bookService.booksReleasedBeforeDate(dateAsString);
        System.out.println(result);
    }


    private void authorsSearch() {
        Scanner scanner = new Scanner(System.in);
        String endsWith = scanner.nextLine();

        List<String> resultOfAuthors = this.authorService.authorsWithFirstNameEndsWith(endsWith);
        resultOfAuthors.forEach(System.out::println);
    }


    private void booksSearch() {
        Scanner scanner = new Scanner(System.in);
        String bookContainsStr = scanner.nextLine();

        String result = this.bookService.bookContainsLetters(bookContainsStr);
        System.out.println(result);
    }


    private void bookTitlesSearch() {
        Scanner scanner = new Scanner(System.in);
        String lastNameStartsWith = scanner.nextLine();

        this.bookService.titleOfBooksWrittenByAuthorsNamesStartWith(lastNameStartsWith)
                .forEach(System.out::println);
    }


    private void countBooks() {
        Scanner scanner = new Scanner(System.in);
        int booksWithTitleLongerThan = Integer.parseInt(scanner.nextLine());

        int countOfBooks = this.bookService.countOfBooksWithTitleLongerThanSymbols(booksWithTitleLongerThan);

        System.out.println(countOfBooks);
        System.out.println(String.format("There are %d books with longer title than %d symbols",
                countOfBooks, booksWithTitleLongerThan));
    }


    private void totalBookCopies() {
        List<Object[]> result = this.bookService.totalNumberOfCopiesByAuthorOrderByCopiesDesc();

        for (Object[] objects : result) {
            System.out.printf("%s - %s%n", objects[0], objects[1]);
        }
    }

}
