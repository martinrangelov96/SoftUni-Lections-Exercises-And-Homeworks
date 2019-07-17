import java.util.Scanner;

public class EqualSumsEvenOddPosition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        String n1 = String.valueOf(Integer.parseInt(String.valueOf(num1)));

        int charCounteri = 0;
        int charCounterj = 0;
        int oddSum = 0;
        int evenSum = 0;

        for (int n = num1; n <= num2; n++) {

            for (int i = n; i <= num2;) {
                String iCount = String.valueOf(Integer.parseInt(String.valueOf(i)));
                if (iCount.length() < 6) {
                    return;
                }
                int charNum1 = iCount.charAt(charCounteri) - '0';
                oddSum += charNum1;
                charCounteri += 2;
                if (charCounteri >= n1.length()) {
                    charCounteri = 0;
                    break;
                }
            }

            evenSum = 0;

            for (int j = n; j <= num2;) {
                String jCount = String.valueOf(Integer.parseInt(String.valueOf(j)));
                if (jCount.length() < 6) {
                    return;
                }
                int charNum2 = jCount.charAt(charCounterj + 1) - '0';
                evenSum += charNum2;
                charCounterj += 2;
                if (charCounterj >= n1.length()) {
                    if (oddSum == evenSum) {
                        System.out.print(jCount + " ");
                    }
                    charCounterj = 0;
                    oddSum = 0;
                    break;
                }

            }

        }

    }

}
