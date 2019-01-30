import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Optional<Integer> num = Arrays.stream(reader.readLine().split(" "))
                .filter(x -> !x.isEmpty())
                .filter(x -> {
                    try {
                        Integer.parseInt(x);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y);

        System.out.println(num.isPresent() ? num.get() : "No match");

    }
}
