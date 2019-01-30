import java.util.*;

public class ForceBookAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, List<String>> usersBySide = new HashMap<>();

        String line = sc.nextLine();

        while (!line.equals("Lumpawaroo")) {
            if (line.contains(" | ")) {
                String[] tokens = line.split(" \\| ");
                String user = tokens[1];
                String side = tokens[0];
                usersBySide.putIfAbsent(side, new ArrayList<>());
                boolean exists = false;

                for (Map.Entry<String, List<String>> entry : usersBySide.entrySet()) {
                    List<String> users = entry.getValue();
                    if (users.contains(user)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    usersBySide.get(side).add(user);
                }

            } else if (line.contains(" -> ")) {
                String[] tokens = line.split(" -> ");
                String user = tokens[0];
                String side = tokens[1];
                usersBySide.putIfAbsent(side, new ArrayList<>());

                for (Map.Entry<String, List<String>> entry : usersBySide.entrySet()) {
                    List<String> users = entry.getValue();
                    if (users.contains(user)) {
                        users.remove(user);
                        break;
                    }
                }

                usersBySide.get(side).add(user);

                System.out.printf("%s joins the %s side!%n", user, side);

            }

            line = sc.nextLine();
        }

        usersBySide.entrySet().stream().sorted((es1, es2) -> {
            int count2 = es2.getValue().size();
            int count1 = es1.getValue().size();
            if (count1 == count2) {
                return es1.getKey().compareTo(es2.getKey());
            }

            return Integer.compare(count2, count1);
        })/*.filter(es -> es.getValue().size() > 0)*/
                .forEach(es -> {
                    if (es.getValue().size() == 0) {
                        return;
                    }
                    System.out.printf("Side: %s, Members: %d%n", es.getKey(), es.getValue().size());
                    Collections.sort(es.getValue());
                    es.getValue().forEach(u -> System.out.println("! " + u));
                });

    }
}
