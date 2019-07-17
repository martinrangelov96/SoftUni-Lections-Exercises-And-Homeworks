import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < numberOfElements; i++) {
            String[] elementsInput = scanner.nextLine().split("\\s+");

            elements.addAll(Arrays.asList(elementsInput));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }

    }
}