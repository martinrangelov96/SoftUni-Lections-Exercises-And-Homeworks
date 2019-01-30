import java.util.Scanner;

public class RecursiveFibonacci {

    static int [] dictionary;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fibNumber = Integer.parseInt(scanner.nextLine());

        dictionary = new int[fibNumber];
        if (dictionary.length >= 0) {
            dictionary[0] = 0;
        }

        if (dictionary.length >= 1) {
            dictionary[0] = 0;
            dictionary[1] = 1;
        }

        System.out.println(fibMethod(fibNumber));

    }

    private static int fibMethod(int fibNumber) {
        if (fibNumber == 0) {
            return dictionary[0];
        } else {
            int f = dictionary[fibNumber - 1];
            if (f == 0) {
                f = fibMethod(fibNumber - 1) + fibMethod(fibNumber - 2);
                dictionary[fibNumber] = f;
            }
            return f;
        }
    }
}
