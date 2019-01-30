import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> physicsByNameAndColor = new LinkedHashMap<>();
        Map<String, Integer> countByColor = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Once upon a time")) {
            String[] tokens = line.split(" <:> ");
            String name = tokens[0];
            String color = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            countByColor.putIfAbsent(color, 0);

            String nameAndColor = color + ":" +name;
            if (physicsByNameAndColor.containsKey(nameAndColor)) {
                if (physicsByNameAndColor.get(nameAndColor) < physics) {
                    physicsByNameAndColor.put(nameAndColor, physics);
                }
            } else {
                physicsByNameAndColor.put(nameAndColor, physics);
                countByColor.put(color, countByColor.get(color) + 1);
            }

            line = scanner.nextLine();
        }

        physicsByNameAndColor.entrySet().stream().sorted(
                (es1, es2) -> {
                    Integer physics2 = es2.getValue();
                    Integer physics1 = es1.getValue();

                    if (physics1.equals(physics2)) {
                        String key1 = es1.getKey();
                        String key2 = es2.getKey();

                        String color1 = key1.split(":")[0];
                        String color2 = key2.split(":")[0];

                        Integer count1 = countByColor.get(color1);
                        Integer count2 = countByColor.get(color2);

                        return Integer.compare(count2,count1);

                    }

                    return Integer.compare(physics2,physics1);

                }
        ).forEach(
                es -> {
                    String[] colorAndName = es.getKey().split(":");
                    Integer physics = es.getValue();

                    System.out.printf("(%s) %s <-> %d%n",colorAndName[0],colorAndName[1],physics);
                }
        );

    }
}
