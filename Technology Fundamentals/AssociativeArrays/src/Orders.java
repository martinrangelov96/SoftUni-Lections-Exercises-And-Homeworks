import java.util.LinkedHashMap;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Double> productsAndPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsAndQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!productsAndQuantity.containsKey(product)) {
                productsAndQuantity.put(product, quantity);
            } else {
                productsAndQuantity.put(product, productsAndQuantity.get(product) + quantity);
            }
            productsAndPrice.put(product, price);

            input = scanner.nextLine();
        }

        for (String drink : productsAndQuantity.keySet()) {
            System.out.printf("%s -> %.2f%n",drink, productsAndQuantity.get(drink) * productsAndPrice.get(drink));
        }
        
    }
    
}
