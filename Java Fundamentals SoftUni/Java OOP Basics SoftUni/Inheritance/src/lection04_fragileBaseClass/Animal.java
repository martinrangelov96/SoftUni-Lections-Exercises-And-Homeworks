package lection04_fragileBaseClass;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        for (Food food1 : food) {
            this.eat(food1);
        }
    }
}
