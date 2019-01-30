import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, ArrayList<String>> companyAndEmployees = new TreeMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String employeeId = tokens[1];

            boolean isSameId = false;

            if (!companyAndEmployees.containsKey(companyName)) {
                for (ArrayList<String> value : companyAndEmployees.values()) {
                    if (value.contains(employeeId)) {
                        break;
                    }
                }
                companyAndEmployees.put(companyName, new ArrayList<>());
                companyAndEmployees.get(companyName).add(employeeId);
            } else if (companyAndEmployees.containsKey(companyName)){
                for (ArrayList<String> value : companyAndEmployees.values()) {
                    if (value.contains(employeeId)) {
                        isSameId = true;
                        break;
                    }
                }
                if (!isSameId) {
                    companyAndEmployees.get(companyName).add(employeeId);
                }
            }

            input = scanner.nextLine();
        }

        companyAndEmployees.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());

                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.printf("-- %s%n", entry.getValue().get(i));
                    }

                });

    }
}
