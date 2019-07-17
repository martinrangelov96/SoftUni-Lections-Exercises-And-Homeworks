package exercise05_mordorsCrueltyPlan.factories;

import exercise05_mordorsCrueltyPlan.models.Food;
import exercise05_mordorsCrueltyPlan.models.Mood;

public class MoodFactory {

    private FoodFactory foodFactory;

    public MoodFactory(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    public int getMoodPoints() {
        int total = 0;
        for(Food food : this.foodFactory.getFoodList()) {
            total += food.getPointsOfHappiness();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("%d", getMoodPoints());
    }
}
