import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String str : input) {

            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);

            double number = Double.parseDouble(str.substring(1,str.length() - 1));

            if (Character.isUpperCase(first)) {
                number = number / (first - 'A' + 1);
            } else {
                number = number * (first - 'a' + 1);
            }

            if (Character.isUpperCase(last)) {
                number = number - (last - 'A' + 1);
            } else {
                number = number + (last - 'a' + 1);
            }

            sum += number;

        }

        System.out.printf("%.2f",sum);

    }
}
