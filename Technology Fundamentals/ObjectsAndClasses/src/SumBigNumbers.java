import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(String.valueOf((scanner.nextLine())));
        BigInteger secondNumber = new BigInteger(String.valueOf((scanner.nextLine())));

        System.out.println(firstNumber.add(secondNumber));
    }
}
