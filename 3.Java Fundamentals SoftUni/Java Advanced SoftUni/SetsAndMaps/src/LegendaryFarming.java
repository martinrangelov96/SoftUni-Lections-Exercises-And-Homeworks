import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryItems = new HashMap<>();
        Map<String, Integer> junk = new TreeMap<>();

        legendaryItems.put("motes", 0);
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);

        boolean isObtained = false;

        while (!isObtained) {

            String[] materialsAndQuantity = scanner.nextLine().split("\\s+");

            for (int i = 0; i < materialsAndQuantity.length - 1; i += 2) {

                int quantity = Integer.parseInt(materialsAndQuantity[i]);
                String material = materialsAndQuantity[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    legendaryItems.put(material, legendaryItems.get(material) + quantity);

                    if (legendaryItems.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        legendaryItems.put("motes", legendaryItems.get("motes") - 250);
                        isObtained = true;
                        break;
                    } else if (legendaryItems.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendaryItems.put("shards", legendaryItems.get("shards") - 250);
                        isObtained = true;
                        break;
                    } else if (legendaryItems.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        legendaryItems.put("fragments", legendaryItems.get("fragments") - 250);
                        isObtained = true;
                        break;
                    }

                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        junk.put(material, junk.get(material) + quantity);
                    }
                }
            }
        }

        legendaryItems.entrySet()
                .stream()
                .sorted((a,b) -> {
                    if (b.getValue() - a.getValue() == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return b.getValue().compareTo(a.getValue());
                    }
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                });

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
        }

    }
}
