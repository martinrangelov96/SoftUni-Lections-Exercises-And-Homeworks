package bookshopsystemapp.advancedqueringexercise.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> bookTitleByAgeRestriction(String ageRestrictionStr);

    List<String> booksWithCopiesLessThan(String editionType, int numberOfCopies);

    List<String> booksBetweenPrices(BigDecimal minPrice, BigDecimal maxPrice);

    List<String> booksNotReleasedIn(String releaseDate);

    //trying with String and .join, instead of List<String>
    String booksReleasedBeforeDate(String dateAsString);

    String bookContainsLetters(String bookContainsStr);

    List<String> titleOfBooksWrittenByAuthorsNamesStartWith(String nameStartsWith);

    int countOfBooksWithTitleLongerThanSymbols(int numberOfSymbols);

    List<Object[]> totalNumberOfCopiesByAuthorOrderByCopiesDesc();
}
