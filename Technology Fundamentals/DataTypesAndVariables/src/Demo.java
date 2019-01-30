import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num ; i++) {
            int sumOfDigits = 0;
            int digits = i;

            while(digits > 0) {
                sumOfDigits += digits % 10;
                digits /= 10;
            }
            boolean isFive = sumOfDigits == 5;
            boolean isSeven = sumOfDigits == 7;
            boolean isEleven = sumOfDigits == 9;
            boolean isSpecial = isFive || isSeven || isEleven;

            if (isSpecial) {
                System.out.println(i + " - True");
            } else {
                System.out.println(i + " - False");
            }

        }

    }
}
