package springdataadvancedquering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springdataadvancedquering.domain.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Set<Ingredient> findAllByNameStartsWith(String firstLetter);

    Set<Ingredient> findAllByNameInOrderByPriceAsc(List<String> ingredientNames);

    Set<Ingredient> findAllByNameIn(List<String> ingredientNames);

    Set<Ingredient> countAllBy();

    @Transactional
    @Modifying
    @Query
            ("DELETE FROM springdataadvancedquering.domain.entities.Ingredient AS i " +
                    "WHERE i.name = :name")
    void deleteIngredientByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query
            ("UPDATE springdataadvancedquering.domain.entities.Ingredient AS i " +
                    "SET i.price = i.price*1.10 ")
    void updateIngredientBy10Percent();

    @Transactional
    @Modifying
    @Query
            ("UPDATE springdataadvancedquering.domain.entities.Ingredient AS i " +
                    "SET i.price = i.price*1.10 " +
                    "WHERE i IN :ingredientsNames")
    void updateIngredientsBy10PercentByListOfNames(@Param("ingredientsNames") Set<Ingredient> ingredientsNames);

}
