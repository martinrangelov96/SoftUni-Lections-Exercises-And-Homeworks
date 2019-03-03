package lection03_coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] cmdArgs = line.split(" ");

            if (cmdArgs.length == 1) {
                coffeeMachine.insertCoin(cmdArgs[0]);
            } else {
                coffeeMachine.buyCoffee(cmdArgs[0], cmdArgs[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }

    }
}
