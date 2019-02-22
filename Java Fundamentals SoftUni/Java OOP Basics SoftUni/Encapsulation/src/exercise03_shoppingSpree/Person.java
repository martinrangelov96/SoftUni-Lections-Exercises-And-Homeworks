package exercise03_shoppingSpree;

import java.util.ArrayList;

public class Person {
    private String name;
    private int money;
    private ArrayList<String> bagOfProducts;

    public ArrayList<String> getBagOfProducts() {
        return this.bagOfProducts;
    }

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(String productName, int personMoney, int productPrice) {
        if (personMoney >= productPrice) {
            this.money -= productPrice;
            bagOfProducts.add(productName);
            System.out.printf("%s bought %s%n", this.getName(), productName);
        } else {
            System.out.printf("%s can't afford %s%n", this.getName(), productName);
        }
    }

    public void viewBags(String personName, ArrayList<String> bagOfProducts) {

        if (bagOfProducts.size() == 0) {
            System.out.printf("%s - Nothing bought", personName);
        } else {
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for (String bagOfProduct : bagOfProducts) {
                sb.append(prefix);
                prefix = ", ";
                sb.append(bagOfProduct);
            }

            System.out.printf("%s - %s%n", personName, sb);
        }

    }
}
