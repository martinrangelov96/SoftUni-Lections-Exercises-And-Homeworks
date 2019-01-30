import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BakingFactoryOtherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int maxSum = Integer.MIN_VALUE;
        double maxAverage = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int sequence[] = null;

        while (!input.equals("Bake It!")) {

            int[] batch = Arrays.stream(input.split("#"))
                    .mapToInt(Integer::parseInt).toArray();

            int sum = Arrays.stream(batch).reduce((a, b) -> a + b).getAsInt();
            double average = sum / (double) batch.length;

            if (sum > maxSum) {
                maxSum = sum;
                maxAverage = average;
                minLength = batch.length;
                sequence = batch;
            } else if (sum == maxSum) {
                if (average > maxAverage) {
                    maxSum = sum;
                    maxAverage = average;
                    minLength = batch.length;
                    sequence = batch;
                } else if (average == maxAverage) {
                    if (batch.length < minLength) {
                        maxSum = sum;
                        maxAverage = average;
                        minLength = batch.length;
                        sequence = batch;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best Batch quality: %d%n", maxSum);
        Arrays.stream(sequence).forEach(e -> System.out.print(e + " "));

    }
}
