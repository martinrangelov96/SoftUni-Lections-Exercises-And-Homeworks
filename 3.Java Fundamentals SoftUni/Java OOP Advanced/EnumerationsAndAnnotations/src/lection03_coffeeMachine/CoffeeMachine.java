package lection03_coffeeMachine;

import lection03_coffeeMachine.enums.CoffeeSize;
import lection03_coffeeMachine.enums.CoffeeType;
import lection03_coffeeMachine.enums.Coin;
import lection05codingTracker.Author;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffeeList;
    private int money;

    public CoffeeMachine() {
        coffeeList = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(Enum.valueOf(CoffeeSize.class, size.toUpperCase()),
                Enum.valueOf(CoffeeType.class, type.toUpperCase()));

        if (coffee.getPrice() <= this.money) {
            this.coffeeList.add(coffee);
            this.money = 0;
        }

    }

    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin.toUpperCase()).getValue();
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeeList;
    }
}
