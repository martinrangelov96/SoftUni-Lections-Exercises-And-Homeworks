import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<String>> nameAndIp = new TreeMap<>();
        Map<String, Integer> nameAndDuration = new HashMap<>();

        for (int i = 0; i < numberOfInputs; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String ip = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!nameAndIp.containsValue(nameAndIp.get(name))) {
                nameAndIp.put(name, new ArrayList<>());
                nameAndIp.get(name).add(ip);
                nameAndDuration.put(name, duration);
            } else {
                if (nameAndIp.get(name).contains(ip)) {
                    nameAndDuration.put(name, nameAndDuration.get(name) + duration);
                    continue;
                }
                nameAndIp.get(name).add(ip);
                nameAndDuration.put(name, nameAndDuration.get(name) + duration);
            }

            Collections.sort(nameAndIp.get(name));

        }

        for (Map.Entry<String, ArrayList<String>> entry : nameAndIp.entrySet()) {
            System.out.printf("%s: %d %s%n", entry.getKey(), nameAndDuration.get(entry.getKey()), entry.getValue());

        }

    }
}
