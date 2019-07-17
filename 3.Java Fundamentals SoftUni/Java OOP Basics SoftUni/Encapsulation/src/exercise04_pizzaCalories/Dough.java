package exercise04_pizzaCalories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dough {
    //feature of Java 9
//    private static final List<String> DOUGH_TYPES = List.of("White", "Wholegrain");
        private static final List<String> FLOUR_TYPES = new ArrayList<>(){{
        add("White");
        add("Wholegrain");
    }};
    private static final List<String> BAKING_TECHNIQUES = new ArrayList<>() {{
        add("Crispy");
        add("Chewy");
        add("Homemade");
    }};
    private static final Map<String, Double> DOUGH_MODIFIERS = new HashMap<>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};

    private static final String INVALID_TYPE_DOUGH_EXCEPTION_MESSAGE = "Invalid type of dough.";
    private static final String INVALID_WEIGHT_DOUGH_EXCEPTION_MESSAGE = "Dough weight should be in the range [1..200].";


    private String flourType;
    private String bakingTechniques;
    private double weight;

    public Dough(String flourType, String bakingTechniques, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechniques(bakingTechniques);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPES.contains(flourType)) {
            throw new IllegalArgumentException(INVALID_TYPE_DOUGH_EXCEPTION_MESSAGE);
        }
        this.flourType = flourType;
    }

    private void setBakingTechniques(String bakingTechniques) {
        if (!BAKING_TECHNIQUES.contains(bakingTechniques)) {
            throw new IllegalArgumentException(INVALID_TYPE_DOUGH_EXCEPTION_MESSAGE);
        }
        this.bakingTechniques = bakingTechniques;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(INVALID_WEIGHT_DOUGH_EXCEPTION_MESSAGE);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return PizzaConstants.BASE_CALORIES *
                this.weight *
                DOUGH_MODIFIERS.get(this.flourType) *
                DOUGH_MODIFIERS.get(this.bakingTechniques);
    }
}
