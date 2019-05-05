package springdataadvancedquering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataadvancedquering.domain.entities.Ingredient;
import springdataadvancedquering.domain.entities.Shampoo;
import springdataadvancedquering.domain.entities.Size;
import springdataadvancedquering.repository.IngredientRepository;
import springdataadvancedquering.repository.ShampooRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectShampoosBySize(String inputSize) {
        Size size = Size.valueOf(inputSize.toUpperCase());

        Set<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(size);

        return shampoos.stream()
                .map(shampoo -> String.format("%s %s %.2f",
                        shampoo.getBrand(), shampoo.getSize().name(), shampoo.getPrice()))
                            .collect(Collectors.toList());
    }

    @Override
    public List<String> selectShampoosBySizeOrLabelId(String inputSize, Long labelId) {

        Size size = Size.valueOf(inputSize.toUpperCase());

        Set<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrLabelIdOrderByPriceAsc(size, labelId);

        return shampoos.stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(), shampoo.getSize().name(), shampoo.getPrice())).collect(Collectors.toList());
    }

    @Override
    public List<String> selectShampoosByPriceHigherThan(BigDecimal inputPrice) {
        Set<Shampoo> shampoos = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(inputPrice);
        return shampoos.stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(), shampoo.getSize().name(), shampoo.getPrice())).collect(Collectors.toList());
    }

    @Override
    public int numberOfShampoosWithPriceLowerThan(BigDecimal inputPrice) {
        int shampoosCount = this.shampooRepository.countAllByPriceLessThan(inputPrice);
        return shampoosCount;
    }

    @Override
    public List<String> selectShampoosByIngredients(List<String> ingredientNames) {

        Set<Ingredient> ingredients = this.ingredientRepository.findAllByNameIn(ingredientNames);
        Set<Shampoo> shampoos = this.shampooRepository.findByIngredientsIn(ingredients);
        return shampoos.stream()
                .map(shampoo -> shampoo.getBrand()).collect(Collectors.toList());
    }

    @Override
    public List<String> selectShampoosWithIngredientsLessThan(int numberOfIngredients) {

        Set<Shampoo> shampoos = this.shampooRepository.findByIngredientsLessThan(numberOfIngredients);
        return shampoos.stream()
                .map(Shampoo::getBrand).collect(Collectors.toList());
    }

    @Override
    public BigDecimal priceOfIngredientsByBrand(String brandName) {
        BigDecimal ingredientsPriceByBrand = this.shampooRepository.findIngredientsPriceByBrand(brandName);
        return ingredientsPriceByBrand;
    }
}
