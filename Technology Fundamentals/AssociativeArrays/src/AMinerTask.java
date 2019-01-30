import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        int quantity = 0;
        int quantitySum = 0;

        LinkedHashMap<String, Integer> resourceAndQuantity = new LinkedHashMap<>();

        while(!resource.equals("stop")) {
            quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceAndQuantity.containsKey(resource)) {
                resourceAndQuantity.put(resource,quantity);
            } else {
                quantitySum = resourceAndQuantity.get(resource);
                resourceAndQuantity.put(resource,quantity + quantitySum);
            }

            resource = scanner.nextLine();
        }

        for (String res : resourceAndQuantity.keySet()) {
            System.out.printf("%s -> %d%n",res,resourceAndQuantity.get(res));
        }
    }
}
