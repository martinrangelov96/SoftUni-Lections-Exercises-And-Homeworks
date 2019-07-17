import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String element = tokens[1];

            if (command.equals("Add")) {
                numbers.add(Integer.valueOf(element));
            } else if (command.equals("Remove")) {
                numbers.remove(Integer.valueOf(element));
            } else if (command.equals("RemoveAt")) {
                numbers.remove(numbers.get(Integer.parseInt(element)));
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(tokens[2]);

                numbers.add(index, Integer.valueOf(element));
            }

            input = scanner.nextLine();

        }

        for (int nums : numbers) {
            System.out.print(nums + " ");
        }


    }
}
