import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {1, 4, 5, 15, 6, 12, 7, 7, 90, 11, 3};

        Arrays.stream(numbers)
                .filter(Demo2::isEven)
                .forEach(System.out::println);
    }

    static boolean isEven(int element) {
        if (element % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
