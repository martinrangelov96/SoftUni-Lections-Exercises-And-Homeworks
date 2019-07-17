import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble num = Arrays.stream(reader.readLine().split(" "))
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::parseDouble)
                .average();

        if (num.isPresent()) {
            System.out.printf("%.2f", num.getAsDouble());
        } else {
            System.out.println("No match");
        }

    }
}
