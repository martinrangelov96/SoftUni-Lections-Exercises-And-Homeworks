package lection05_customRandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    public Object getRandomElement() {
        int rnd = this.random.nextInt(super.size());
        Object element = super.get(rnd);
        super.remove(rnd);

        return element;
    }

}
