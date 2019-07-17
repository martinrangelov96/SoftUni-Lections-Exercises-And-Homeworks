import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvancedAlone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("Contains")) {
                int containsNumber = Integer.parseInt(tokens[1]);
                if (numbers.contains(containsNumber)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (command.equals("Print")) {
                if (tokens[1].equals("even")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 0) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 1) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            } else if (command.equals("Get")) {
                int sum = 0;
                for (int nums : numbers) {
                    sum += nums;
                }
                System.out.println(sum);
            } else if (command.equals("Filter")) {
                String condition = tokens[1];
                int number = Integer.parseInt(tokens[2]);

                if (condition.equals("<")) {
                    numbers.stream().filter(e -> e < number)
                            .forEach(e -> System.out.print(e + " "));
                } else if (condition.equals(">")) {
                    numbers.stream().filter(e -> e > number)
                            .forEach(e -> System.out.print(e + " "));
                } else if (condition.equals("<=")) {
                    numbers.stream().filter(e -> e <= number)
                            .forEach(e -> System.out.print(e + " "));
                } else if (condition.equals(">=")) {
                    numbers.stream().filter(e -> e >= number)
                            .forEach(e -> System.out.print(e + " "));
                }
                System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}
