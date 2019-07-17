import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] inputCommands = scanner.nextLine().split("\\s+");
            if (inputCommands.length > 1) {
                int command = Integer.parseInt(inputCommands[0]);
                int numberToAdd = Integer.parseInt(inputCommands[1]);
                if (command == 1) {
                    stack.push(numberToAdd);
                }
            } else {
                int command = Integer.parseInt(inputCommands[0]);
                if (command == 2) {
                    stack.pop();
                } else if (command == 3) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
