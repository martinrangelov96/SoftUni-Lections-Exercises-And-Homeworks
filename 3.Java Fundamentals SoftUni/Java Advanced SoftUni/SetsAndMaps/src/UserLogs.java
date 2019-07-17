import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> userAndIp = new TreeMap<>();


        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            if ("end".equals(input[0])) {
                break;
            }

            String user = input[2].split("=")[1];
            String ip = input[0].split("=")[1];

            if (!userAndIp.containsKey(user)) {
                userAndIp.put(user, new ArrayList<>());
                userAndIp.get(user).add(ip);
            } else {
                userAndIp.get(user).add(ip);
            }

        }


        userAndIp.entrySet()
                .forEach(entry -> {
                    boolean printOnce = false;

                    for (int i = 0; i < entry.getValue().size() ; i++) {
                        if (entry.getValue().size() > 1) {
                            System.out.printf("%s: %n%s => %d.",entry.getKey(), entry.getValue().get(i), entry.getValue().size());
                            printOnce = true;
                        }
                        if (printOnce) {
                            break;
                        }
                        System.out.printf("%s: %n%s => %d.",entry.getKey(), entry.getValue().get(i), entry.getValue().size());
                    }

                    System.out.println();

                });

    }
}
