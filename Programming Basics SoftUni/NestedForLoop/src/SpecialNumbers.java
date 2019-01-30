import java.util.Scanner;

public class SpecialNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int forthNum = 0;
        int thirdNum = 0;
        int secondNum = 0;
        int firstNum = 0;

        for (int i = 1111; i <= 9999; i++) {
            String iString = String.valueOf(i);
            if (iString.contains("0")) {
                continue;
            }
            forthNum = i % 10;
            thirdNum = i / 10 % 10;
            secondNum = i / 10 / 10 % 10;
            firstNum = i / 10 / 10 / 10 % 10;
            if ((n % firstNum == 0) && (n % secondNum == 0) && (n % thirdNum == 0) && (n % forthNum == 0)) {
                System.out.printf("%d ", i);
            }
        }
    }

}
