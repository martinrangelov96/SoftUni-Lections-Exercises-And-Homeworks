import java.util.Scanner;

public class SumPrimeNonPrime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!input.equals("stop")) {
            int number = Integer.parseInt(input);
            if (number < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
            } else {
                boolean isPrime = true;
                if (number >= 2) {
                    for (int i = 2; i <= number / 2; i++) {
                        if (number % i == 0) {
                            isPrime = false;
                        }
                    }
                } else {
                    isPrime = false;
                }
                if (isPrime) {
                    primeSum += number;
                } else {
                    nonPrimeSum += number;
                }

                input = scanner.nextLine();
            }

        }

        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d%n", nonPrimeSum);

    }

}

