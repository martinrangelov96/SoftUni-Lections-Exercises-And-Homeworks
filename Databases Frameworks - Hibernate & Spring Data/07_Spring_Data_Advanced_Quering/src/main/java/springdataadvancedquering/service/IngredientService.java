package springdataadvancedquering.service;

import java.util.List;

public interface IngredientService {

    List<String> selectIngredientsThatStartsWith(String inputFirstLetter);

    List<String> selectIngredientsByNames(List<String> names);

    void deleteIngredientByName(String ingredientName);

    void updateIngredientBy10Percent();

    void updateIngredientsBy10PercentByListOfNames(List<String> ingredientsNames);

}
