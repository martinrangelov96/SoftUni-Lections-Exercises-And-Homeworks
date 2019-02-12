package exercise07_foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfBuyers = Integer.parseInt(reader.readLine());
        List<Buyer> buyers = new ArrayList<>();
        Buyer buyer = null;

        while (numberOfBuyers-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            if (data.length == 4) {
                buyer = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
            } else if (data.length == 3) {
                buyer = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
            }
            buyers.add(buyer);
        }

        String buyersInput;
        while (!"End".equals(buyersInput = reader.readLine())) {
            for (Buyer buyer1 : buyers) {
                buyer1.buyFood(buyersInput);
            }
        }

        int allFoodBought = 0;
        for (Buyer buyer1 : buyers) {
            allFoodBought += buyer1.getFood();
        }
        System.out.println(allFoodBought);
    }
}
