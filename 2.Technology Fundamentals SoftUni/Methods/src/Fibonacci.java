import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fibNumber = Integer.parseInt(scanner.nextLine());

        fibonacciNumber(fibNumber);
    }

    private static void fibonacciNumber(int fibNumber) {
        int fib1 = 0;
        int fib2 = 1;

        for (int i = 2; i < fibNumber ; i++) {
            int fib3 = fib1 + fib2;

            System.out.println(fib3);

            fib1 = fib2;
            fib2 = fib3;

        }
    }
}
