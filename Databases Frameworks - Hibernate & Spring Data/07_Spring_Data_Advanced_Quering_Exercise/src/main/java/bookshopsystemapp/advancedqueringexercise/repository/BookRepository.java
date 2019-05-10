package bookshopsystemapp.advancedqueringexercise.repository;

import bookshopsystemapp.advancedqueringexercise.domain.entities.AgeRestriction;
import bookshopsystemapp.advancedqueringexercise.domain.entities.Book;
import bookshopsystemapp.advancedqueringexercise.domain.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesIsLessThan(EditionType editionType, int numberOfCopies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal minPrice, BigDecimal maxPrice);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate beforeReleaseDate, LocalDate afterReleaseDate);

    List<Book> findAllByTitleContains(String bookContainsStr);

    @Query("SELECT b FROM bookshopsystemapp.domain.entities.Book AS b " +
            "JOIN b.author AS a " +
            "WHERE a.lastName LIKE :startsWith")
    List<Book> findTitlesOfBooksWhichAuthorsLastNameStartsWith(@Param("startsWith") String startsWith);

    @Query("SELECT b FROM bookshopsystemapp.domain.entities.Book AS b " +
            "WHERE LENGTH(b.title) > :numberOfSymbols")
    List<Book> countOfBooksWithTitleLongerThanSymbols(@Param("numberOfSymbols") int numberOfSymbols);

    @Query("SELECT CONCAT(a.firstName, ' ', a.lastName), " +
            "SUM(b.copies) AS copies " +
            "FROM bookshopsystemapp.domain.entities.Book AS b " +
            "JOIN b.author AS a " +
            "GROUP BY a.id " +
            "ORDER BY copies DESC")
    List<Object[]> totalNumberOfCopiesByAuthorOrderByCopiesDesc();
}
