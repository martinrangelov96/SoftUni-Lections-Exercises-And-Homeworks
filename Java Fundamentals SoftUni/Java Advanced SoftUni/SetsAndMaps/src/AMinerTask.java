import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourcesAndQuantity = new LinkedHashMap<>();

        String input = scanner.nextLine();
        int counter = 1;
        String resource = "";

        while (!"stop".equals(input)) {

            if (counter % 2 != 0) {
                resource = input;
                if (!resourcesAndQuantity.containsKey(resource)) {
                    resourcesAndQuantity.put(resource, 0);
                }
            } else {
                int quantity = Integer.parseInt(input);
                if (!resourcesAndQuantity.containsKey(resource)) {
                    resourcesAndQuantity.put(resource, quantity);
                } else {
                    int tempQuantity = Integer.parseInt(input);
                    resourcesAndQuantity.put(resource, resourcesAndQuantity.get(resource) + tempQuantity);
                }
            }

            counter++;
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourcesAndQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
