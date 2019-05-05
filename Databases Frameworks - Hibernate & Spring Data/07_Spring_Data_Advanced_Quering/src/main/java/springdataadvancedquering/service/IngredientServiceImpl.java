package springdataadvancedquering.service;

import org.springframework.stereotype.Service;
import springdataadvancedquering.domain.entities.Ingredient;
import springdataadvancedquering.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectIngredientsThatStartsWith(String inputFirstLetter) {

        Set<Ingredient> ingredients =this.ingredientRepository.findAllByNameStartsWith(inputFirstLetter);
        return ingredients.stream()
                .map(Ingredient::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> selectIngredientsByNames(List<String> names) {
        Set<Ingredient> ingredients = this.ingredientRepository.findAllByNameIn(names);
        return ingredients.stream()
                .map(ingredient -> ingredient.getName()).collect(Collectors.toList());
    }

    @Override
    public void deleteIngredientByName(String ingredientName) {
        this.ingredientRepository.deleteIngredientByName(ingredientName);
    }

    @Override
    public void updateIngredientBy10Percent() {
        this.ingredientRepository.updateIngredientBy10Percent();
    }

    @Override
    public void updateIngredientsBy10PercentByListOfNames(List<String> ingredientsNames) {
        Set<Ingredient> ingredients = this.ingredientRepository.findAllByNameIn(ingredientsNames);

        this.ingredientRepository.updateIngredientsBy10PercentByListOfNames(ingredients);
    }
}
