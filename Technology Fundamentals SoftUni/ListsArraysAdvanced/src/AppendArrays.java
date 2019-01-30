import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Character> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i));
        }

        numbers.removeAll(Collections.singleton(' '));
//        numbers.removeAll(Collections.singleton('|'));

        int counter = 0;

        for (int i = 0; i < numbers.size() ; i++) {
            counter++;
            if (numbers.get(i).equals('|')) {
                numbers.remove(numbers.get(i));
                for (int j = 0; j < counter ; j++) {

                }
                counter = 0;
            }
        }

    }
}
