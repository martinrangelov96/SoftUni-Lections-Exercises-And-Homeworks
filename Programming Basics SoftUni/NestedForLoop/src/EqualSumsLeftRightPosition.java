import java.util.Scanner;

public class EqualSumsLeftRightPosition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberStart = Integer.parseInt(scanner.nextLine());
        int numberEnd = Integer.parseInt(scanner.nextLine());

        String numberStartStr = String.valueOf(Integer.parseInt(String.valueOf(numberStart)));

        for (int i = numberStart; i <= numberEnd; i++) {

            int leftSum = 0;
            int leftCounter = 0;

            for (int leftNumbers = 0; leftNumbers < 2; leftNumbers++) {
                String numbersInt = String.valueOf(Integer.parseInt(String.valueOf(i)));
                leftSum += numbersInt.charAt(leftCounter) - '0';
                leftCounter++;
                if (leftCounter == 2) {
                    break;
                }
            }

            int rightSum = 0;
            int rightCounter = 5;

            for (int rightNumbers = numberStartStr.length(); rightNumbers > 3; rightNumbers--) {
                String numbersInt = String.valueOf(Integer.parseInt(String.valueOf(i)));
                rightSum += numbersInt.charAt(rightCounter - 1) - '0';
                rightCounter--;
                if (rightCounter == 3) {
                    if (leftSum == rightSum) {
                        System.out.print(numbersInt + " ");
                    } else {
                        if (leftSum < rightSum) {
                            leftSum += numbersInt.charAt(2) - '0';
                            if (leftSum == rightSum) {
                                System.out.print(numbersInt + " ");
                            }
                        } else {
                            rightSum += numbersInt.charAt(2) - '0';
                            if (rightSum == leftSum) {
                                System.out.print(numbersInt + " ");
                            }
                        }
                    }

                }
            }

        }

    }

}
