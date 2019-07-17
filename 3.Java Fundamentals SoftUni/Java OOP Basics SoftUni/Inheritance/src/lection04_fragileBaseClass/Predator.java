package lection04_fragileBaseClass;

import java.util.Arrays;
import java.util.List;

public class Predator extends Animal {
    private int health;

    public void feed(Food food) {
        super.eat(food);
        this.health++;
    }

    @Override
    public void eatAll(Food[] food) {
        for (Food food1 : food) {
            this.feed(food1);
        }
    }

    public int getHealth() {
        return this.health;
    }
}
