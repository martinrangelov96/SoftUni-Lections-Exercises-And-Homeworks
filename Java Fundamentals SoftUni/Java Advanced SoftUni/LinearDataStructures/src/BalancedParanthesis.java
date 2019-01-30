import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] paranthesis = scanner.nextLine().split(" ");

        if (paranthesis.length % 2 != 0) {
            System.out.println("NO");
        } else {
            ArrayDeque<String> deque = new ArrayDeque<>();
            Collections.addAll(deque, paranthesis);
            while (true) {
                if (deque.isEmpty()) {
                    break;
                }

                String first = deque.pop();
                String second =deque.poll();
                String debug = "";

            }
        }

    }

}
