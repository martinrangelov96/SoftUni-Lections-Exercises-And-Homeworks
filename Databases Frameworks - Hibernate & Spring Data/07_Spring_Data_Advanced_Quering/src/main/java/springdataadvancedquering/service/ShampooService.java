package springdataadvancedquering.service;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<String> selectShampoosBySize(String inputSize);

    List<String> selectShampoosByIngredients(List<String> ingredientNames);

    List<String> selectShampoosBySizeOrLabelId(String inputSize, Long labelId);

    List<String> selectShampoosByPriceHigherThan(BigDecimal inputPrice);

    int numberOfShampoosWithPriceLowerThan(BigDecimal inputPrice);

    List<String> selectShampoosWithIngredientsLessThan(int numberOfIngredients);

    BigDecimal priceOfIngredientsByBrand(String brandName);

}
