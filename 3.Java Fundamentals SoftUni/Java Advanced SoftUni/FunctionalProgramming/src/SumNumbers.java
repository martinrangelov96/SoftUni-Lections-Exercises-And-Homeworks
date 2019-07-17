import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        Function<String[], int[]> parseArray = arr -> {
            int[] parsed = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                parsed[i] = Integer.parseInt(arr[i]);
            }
            return parsed;
        };

        int[] parsed = parseArray.apply(input);

        Function<int[], Integer> getArrayCount = arr -> arr.length;

        int count = getArrayCount.apply(parsed);

        Function<int[], Integer> sumNumbers = arr -> {
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return sum;
        };

        int sum = sumNumbers.apply(parsed);

        System.out.println("Count = " +count);
        System.out.println("Sum = " +sum);

    }
}
