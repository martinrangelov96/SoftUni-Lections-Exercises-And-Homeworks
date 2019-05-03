package bookshopsystemap.controller;

import bookshopsystemap.domain.entities.Author;
import bookshopsystemap.service.AuthorService;
import bookshopsystemap.service.BookService;
import bookshopsystemap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookshopController implements CommandLineRunner {

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
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

        this.bookTitles();

//        this.authorNames();
    }

    private void bookTitles() {
        List<String> bookTitles = this.bookService.getAllBooksTitlesAfter();

        System.out.println(String.join("\r\n", bookTitles));
    }

    private void authorNames() {
        this.bookService.getAllAuthorsWithBookBefore().stream()
                .forEach(a -> System.out.println(a));
    }
}
