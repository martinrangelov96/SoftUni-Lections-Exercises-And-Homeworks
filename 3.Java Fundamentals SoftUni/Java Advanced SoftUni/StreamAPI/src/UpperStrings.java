import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(reader.readLine().split(" "))
                .filter(x -> x.length() > 0)
                .map(String::toUpperCase)
                .forEach(x -> System.out.print(x + " "));
    }
}
