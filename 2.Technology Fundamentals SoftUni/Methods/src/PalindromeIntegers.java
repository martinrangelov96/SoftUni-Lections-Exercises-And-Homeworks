import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        isInputPalindrome(number);

    }

    public static void isInputPalindrome(int number) {

        Scanner scanner = new Scanner(System.in);
        String numberStr = String.valueOf(number);

        while (!numberStr.equals("END")) {
            String reversedNumber = "";

            for (int i = numberStr.length() - 1; i >= 0  ; i--) {
                reversedNumber += numberStr.charAt(i);
            }

            if (numberStr.equals(reversedNumber)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            numberStr = scanner.nextLine();
        }

    }
}
