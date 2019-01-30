import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String element = tokens[1];

            if (command.equals("Add")) {
                numbers.add(Integer.valueOf(element));
            } else if (command.equals("Remove")) {
                int index = Integer.parseInt(tokens[1]);

                if (index >= 0 && index < numbers.size()) {
                    numbers.remove(index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(tokens[2]);

                if (index >= 0 && index < numbers.size()) {
                    numbers.add(index, Integer.parseInt(element));
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.equals("Shift")) {
                int count = Integer.parseInt(tokens[2]);

                count = count % numbers.size();

                if (tokens[1].equals("right")) {
                    for (int i = 0; i < count; i++) {
                        numbers.add(0, numbers.get(numbers.size() - 1));
                        numbers.remove(numbers.size() - 1);
                    }
                } else {
                    for (int i = 0; i < count; i++) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }
                }
            }


            input = scanner.nextLine();
        }

        for (Integer nums : numbers) {
            System.out.print(nums + " ");
        }
    }
}