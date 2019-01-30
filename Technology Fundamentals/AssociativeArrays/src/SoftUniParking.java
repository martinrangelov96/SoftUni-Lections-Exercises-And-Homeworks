import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> registerInfo = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands ; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("register")) {
                String name = tokens[1];
                String licenseNumber = tokens[2];

                if (!registerInfo.containsKey(name)) {
                    registerInfo.put(name, licenseNumber);
                    System.out.printf("%s registered %s successfully%n",name,licenseNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n",licenseNumber);
                }

            } else {
                String name = tokens[1];

                if (!registerInfo.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n",name);
                } else {
                    registerInfo.remove(name);
                    System.out.printf("%s unregistered successfully%n",name);
                }

            }

        }

        for (String info : registerInfo.keySet()) {
            System.out.printf("%s => %s%n",info, registerInfo.get(info));
        }

    }
}
