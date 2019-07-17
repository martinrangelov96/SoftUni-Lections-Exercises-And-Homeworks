import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractSumWithThirdNumber(firstNumber, secondNumber, thirdNumber));

    }

    public static int sumOfFirstTwoNumbers(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public static int subtractSumWithThirdNumber(int firstNumber, int secondNumber, int thirdNumber) {
        return sumOfFirstTwoNumbers(firstNumber,secondNumber) - thirdNumber;
    }

}
