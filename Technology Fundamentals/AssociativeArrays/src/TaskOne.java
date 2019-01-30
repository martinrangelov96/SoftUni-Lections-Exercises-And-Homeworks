import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, List<String>> productsByPrice = new HashMap<>();

        String line = scanner.nextLine();

        while(!line.equals("buy")) {
            String[] productAndPrice = line.split(" ");
            String productName = productAndPrice[0];
            double price = Double.parseDouble(productAndPrice[1]);

            if (!productsByPrice.containsKey(price)) {
                productsByPrice.put(price,new ArrayList<>());
            }

            productsByPrice.get(price).add(productName);

            line = scanner.nextLine();
        }

        for(Map.Entry<Double, List<String>> productPair: productsByPrice.entrySet()) {
            System.out.print(productPair.getKey()+ " : ");
            for (String product : productPair.getValue()) {
                System.out.print(product+ ", ");
            }
            System.out.println();
        }

    }
}
