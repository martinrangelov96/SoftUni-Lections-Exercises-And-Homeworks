import java.util.Scanner;

public class HalfSumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers = Integer.parseInt(scanner.nextLine());

        int numbers = 0;

        int sum = 0;

        int biggestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfNumbers; i++) {
            numbers = Integer.parseInt(scanner.nextLine());
            sum += numbers;
            if (numbers > biggestNumber) {
                biggestNumber = numbers;
            }
        }

        sum -= biggestNumber;

        if (biggestNumber == sum) {
            System.out.println("Yes");
            System.out.printf("Sum = %d",sum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d",Math.abs(biggestNumber - sum));
        }

    }

}
