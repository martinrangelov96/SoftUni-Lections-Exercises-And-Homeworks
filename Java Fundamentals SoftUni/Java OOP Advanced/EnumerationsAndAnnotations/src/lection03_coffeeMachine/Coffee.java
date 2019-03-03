package lection03_coffeeMachine;

import lection03_coffeeMachine.enums.CoffeeSize;
import lection03_coffeeMachine.enums.CoffeeType;

public class Coffee {
    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(CoffeeSize size, CoffeeType type) {
        this.size = size;
        this.type = type;
    }

    public int getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size.toString() + " " + this.type.toString();
    }
}
