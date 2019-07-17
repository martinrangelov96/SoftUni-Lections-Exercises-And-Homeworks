import java.util.*;

public class ForceBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, ArrayList<String>> forceSidesAndUsers = new HashMap<>();


        while (!input.equals("Lumpawaroo")) {
            String[] tokens = input.split(" ");
            String sign = tokens[1];


            if (sign.equals("|")) {
                String forceSide = tokens[0];
                String forceUser = tokens[2];
//                boolean doesUserExist = forceSidesAndUsers.containsValue("forceUser");

                if (forceSidesAndUsers.values().stream().anyMatch(e -> e.contains(forceUser))) {
                    continue;
                } else {
                    if (forceSidesAndUsers.containsKey(forceSide)) {
                        forceSidesAndUsers.get(forceSide).add(forceUser);
                    } else {
                        forceSidesAndUsers.put(forceSide, new ArrayList<>());
                        forceSidesAndUsers.get(forceSide).add(forceUser);
                    }
                }


            } else {
                String forceUser = tokens[0];
                String forceSide = tokens[2];

                if (!forceSidesAndUsers.containsKey(forceUser)) {
                    if (forceSidesAndUsers.values().stream().anyMatch(e -> e.contains(forceUser))) {

                    } else {
                        forceSidesAndUsers.get(forceSide).add(forceUser);
                        System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                    }
                } else {
                    forceSidesAndUsers.put(forceSide, new ArrayList<>());
                    forceSidesAndUsers.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }

            }

            input = scanner.nextLine();
        }

        forceSidesAndUsers.entrySet().stream().sorted((a,b) -> Integer.compare(b.getValue().size(),a.getValue().size()))
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    System.out.printf("! %s%n", entry.getValue().toString().replaceAll("[\\[\\],]",""));
                });

    }
}
