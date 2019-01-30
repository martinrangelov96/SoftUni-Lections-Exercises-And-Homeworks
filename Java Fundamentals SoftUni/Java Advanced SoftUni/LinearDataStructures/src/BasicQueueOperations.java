import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        int numberOfElementsToAdd = Integer.parseInt(input[0]);
        int numberOfElementsToRemove = Integer.parseInt(input[1]);
        int checkIfExists = Integer.parseInt(input[2]);

        String[] addNumbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            int addNumberValue = Integer.parseInt(addNumbers[i]);
            deque.add(addNumberValue);
        }

        for (int i = 0; i < numberOfElementsToRemove; i++) {
            deque.remove();
        }

        if (deque.contains(checkIfExists)) {
            System.out.println(true);
        } else {
            if (deque.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(deque));
            }
        }

    }
}
