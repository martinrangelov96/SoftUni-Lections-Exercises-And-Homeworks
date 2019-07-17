package exercise03_shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> personSet = new LinkedHashSet<>();
        Set<Product> productSet = new LinkedHashSet<>();

        String namesAndMoney = reader.readLine();
        String[] people;
        String productsAndPrice = reader.readLine();
        String[] products;

        if (namesAndMoney.contains(";")) {
            people = namesAndMoney.split(";");
        } else {
            people = namesAndMoney.split("=");
        }

        if (productsAndPrice.contains(";")) {
            products = productsAndPrice.split(";");
        } else {
            products = productsAndPrice.split("=");
        }

        for (int i = 0; i < people.length; i++) {
            String personName;
            int personMoney;
            if (people[i].contains("=")) {
                String[] peopleData = people[i].split("=");
                personName = peopleData[0];
                personMoney = Integer.parseInt(peopleData[1]);
                try {
                    personSet.add(new Person(personName, personMoney));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                personName = people[i];
                personMoney = Integer.parseInt(people[i + 1]);
                try {
                    personSet.add(new Person(personName, personMoney));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            }
        }

        for (int i = 0; i < products.length; i++) {
            String productName;
            int productPrice;
            if (products[i].contains("=")) {
                String[] productsData = products[i].split("=");
                productName = productsData[0];
                productPrice = Integer.parseInt(productsData[1]);
                try {
                    productSet.add(new Product(productName, productPrice));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                productName = products[i];
                productPrice = Integer.parseInt(products[i + 1]);
                try {
                    productSet.add(new Product(productName, productPrice));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            }
        }

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] purchase = line.split("\\s+");
            String personName = purchase[0];
            String productName = purchase[1];

            for (Person person : personSet) {
                if (person.getName().equals(personName))
                for (Product product : productSet) {
                    if (product.getName().equals(productName)) {
                        person.buyProduct(productName, person.getMoney(), product.getPrice());
                    }
                }
            }

        }

        for (Person person : personSet) {
            person.viewBags(person.getName(), person.getBagOfProducts());
        }
    }
}
