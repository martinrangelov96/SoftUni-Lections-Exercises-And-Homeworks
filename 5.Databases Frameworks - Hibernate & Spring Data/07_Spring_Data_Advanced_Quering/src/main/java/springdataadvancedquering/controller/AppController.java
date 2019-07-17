package springdataadvancedquering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataadvancedquering.service.IngredientService;
import springdataadvancedquering.service.ShampooService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    private final Scanner scanner;

    @Autowired
    public AppController(ShampooService shampooService, IngredientService ingredientService, Scanner scanner) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        //Task 1. Select Shampoos by Size
//        selectShampoosBySize();

        //Task 2.2.	Select Shampoos by Size or Label
//        selectShampoosBySizeOrLabel();

        //Task 3.Select Shampoos by Price
//        selectShampoosByPrice();

        //Task 4.Select Ingredients by Name
//        selectIngredientsByName();

        //Task 5.Select Ingredients by Names
//        selectIngredientsByNames();

        //Task 6.Count Shampoos by Price
//        countShampoosByPrice();

        //Task 7 Select Shampoos by Ingredients
//        selectShampoosByIngredients();

        //Task 8.Select Shampoos by Ingredients Count
//        selectShampoosByIngredientsCount();

        //Task 9.Select Ingredient Name and Shampoo Brand By
//        selectIngredientNameAndShampooBrandBy();

        //Task 10.Delete Ingredients by name
//        deleteIngredientByName();

        //Task 11.Update Ingredients by price
//        updateIngredientsByPrice();

        //Task 12.	Update Ingredients by Names
//        updateIngredientsByNames();
    }

    private void selectShampoosBySize() {
        String inputSize = this.scanner.nextLine();

        List<String> resultShampoosBySize = this.shampooService.selectShampoosBySize(inputSize);
        resultShampoosBySize.forEach(s -> System.out.println(s));
    }

    private void selectShampoosBySizeOrLabel() {
        String inputSize = this.scanner.nextLine();
        Long labelId = Long.parseLong(this.scanner.nextLine());

        List<String> resultOfShampoosBySizeOrLabelId = this.shampooService.selectShampoosBySizeOrLabelId(inputSize, labelId);
        resultOfShampoosBySizeOrLabelId.forEach(System.out::println);
    }

    private void selectShampoosByPrice() {
        BigDecimal price = this.scanner.nextBigDecimal();

        List<String> resultOfShampoosWithHigherPriceThan = this.shampooService.selectShampoosByPriceHigherThan(price);
        resultOfShampoosWithHigherPriceThan.forEach(System.out::println);
    }


    private void selectIngredientsByName() {
        String letter = this.scanner.nextLine();

        List<String> resultIngredientsStartWithLetter = this.ingredientService.selectIngredientsThatStartsWith(letter);
        resultIngredientsStartWithLetter.forEach(System.out::println);
    }


    private void selectIngredientsByNames() {
        List<String> ingredientNames = new ArrayList<>();
        while (true) {
            String ingredientName = this.scanner.nextLine();
            if ("".equals(ingredientName)) {
                break;
            }

            ingredientNames.add(ingredientName);
        }

        List<String> findIngredientsByNames =
                this.ingredientService.selectIngredientsByNames(ingredientNames);
        findIngredientsByNames.forEach(System.out::println);
    }

    private void selectShampoosByIngredients() {
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = this.scanner.nextLine();
            if ("".equals(line)) {
                break;
            }
            lines.add(line);

        }

        this.shampooService.selectShampoosByIngredients(lines)
                .forEach(s -> System.out.println(s));
    }

    private void countShampoosByPrice() {
        BigDecimal inputPrice = this.scanner.nextBigDecimal();
        int resultCountOfShampoosWithPriceLowerThan = this.shampooService.numberOfShampoosWithPriceLowerThan(inputPrice);
        System.out.println(resultCountOfShampoosWithPriceLowerThan);
    }


    private void selectShampoosByIngredientsCount() {
        int numberOfIngredients = Integer.parseInt(this.scanner.nextLine());

        List<String> resultOfShampoosByIngredientsCount =
                this.shampooService.selectShampoosWithIngredientsLessThan(numberOfIngredients);
        resultOfShampoosByIngredientsCount.forEach(System.out::println);
    }

    private void selectIngredientNameAndShampooBrandBy() {
        String brandName = this.scanner.nextLine();

        BigDecimal priceOfIngredientsByBrand
                = this.shampooService.priceOfIngredientsByBrand(brandName);
        System.out.println(priceOfIngredientsByBrand);
    }


    private void deleteIngredientByName() {
        String ingredientName = this.scanner.nextLine();
        this.ingredientService.deleteIngredientByName(ingredientName);
    }

    private void updateIngredientsByPrice() {
        this.ingredientService.updateIngredientBy10Percent();
    }


    private void updateIngredientsByNames() {
        List<String> ingredientsNames = new ArrayList<>();
        while (true) {
            String ingredientName = this.scanner.nextLine();
            if ("".equals(ingredientName)) {
                break;
            }

            ingredientsNames.add(ingredientName);
        }

        this.ingredientService.updateIngredientsBy10PercentByListOfNames(ingredientsNames);
    }
}
