import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isObtained = false;

        HashMap<String, Integer> keyRegants = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        keyRegants.put("motes", 0);
        keyRegants.put("shards", 0);
        keyRegants.put("fragments", 0);

        while (!isObtained) {
            String[] materials = scanner.nextLine().split("\\s+");

            for (int i = 0; i < materials.length - 1; i += 2) {
                int quantity = Integer.parseInt(materials[i]);
                String regant = materials[i + 1].toLowerCase();

                if (regant.equals("motes") || regant.equals("shards")
                        || regant.equals("fragments")) {
                    keyRegants.put(regant, keyRegants.get(regant) + quantity);

                    if (keyRegants.get(regant) >= 250) {
                        keyRegants.put(regant, keyRegants.get(regant) - 250);

                        if (regant.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        } else if (regant.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else {
                            System.out.println("Valanyr obtained!");
                        }
                        isObtained = true;
                        break;

                    }

                } else {
                    if (!junk.containsKey(regant)) {
                        junk.put(regant, quantity);
                    } else {
                        junk.put(regant, junk.get(regant) + quantity);
                    }
                }

            }

        }

        keyRegants.entrySet().stream()
                .sorted((a, b) -> {
                    if (b.getValue() - a.getValue() == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return b.getValue() - a.getValue();
                    }
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                });

        junk.forEach((k, v) -> {
            System.out.printf("%s: %d%n", k, v);
        });
    }
}
