import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        tribonacciSequence(num);

    }

    public static void tribonacciSequence(int num) {
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = 1;
        int fib4;

        System.out.print(fib2 +" " +fib3);


        for (int i = 2; i < num ; i++) {
            fib4 = fib1 + fib2 + fib3;
            System.out.print(fib4 + " ");
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib4;
        }

    }

}
