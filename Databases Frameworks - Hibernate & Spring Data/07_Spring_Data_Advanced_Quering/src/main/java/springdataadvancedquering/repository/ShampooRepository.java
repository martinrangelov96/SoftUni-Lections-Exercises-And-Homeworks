package springdataadvancedquering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdataadvancedquering.domain.entities.Ingredient;
import springdataadvancedquering.domain.entities.Shampoo;
import springdataadvancedquering.domain.entities.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    Set<Shampoo> findAllBySizeOrderById(Size size);

    @Query("SELECT s FROM springdataadvancedquering.domain.entities.Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i IN :ingredients")
    Set<Shampoo> findByIngredientsIn(@Param("ingredients") Set<Ingredient> ingredients);

    Set<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, Long labelId);

    Set<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT s " +
            "FROM springdataadvancedquering.domain.entities.Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE s.ingredients.size < :numberOfIngredients")
    Set<Shampoo> findByIngredientsLessThan(@Param("numberOfIngredients") int numberOfIngredients);

    @Query("SELECT sum(i.price)" +
            "FROM springdataadvancedquering.domain.entities.Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE s.brand = :brandName")
    BigDecimal findIngredientsPriceByBrand(@Param("brandName") String brandName);
}
