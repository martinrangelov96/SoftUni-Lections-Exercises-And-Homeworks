package exercise05_mordorsCrueltyPlan.factories;

import exercise05_mordorsCrueltyPlan.models.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodFactory {

    private List<Food> foodList;

    public FoodFactory() {
        this.foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public int getScore() {
        int moodScore = 0;
        for (Food food : foodList) {
            moodScore += food.getPointsOfHappiness();
        }
        return moodScore;
    }

    @Override
    public String toString() {
        return String.format("%d", this.getScore());
    }
}
