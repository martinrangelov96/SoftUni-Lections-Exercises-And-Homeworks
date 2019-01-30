package OrderByAge;

import java.util.ArrayList;
import java.util.Scanner;

class OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<Unknown> unknowns = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Unknown unknown = new Unknown(name, id, age);

            unknowns.add(unknown);

            input = scanner.nextLine();
        }

        unknowns.stream().sorted((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge()))
                .forEach(u -> System.out.printf("%s with ID: %s is %d years old.%n",
                        u.getName(), u.getId(), u.getAge()));
    }

}

