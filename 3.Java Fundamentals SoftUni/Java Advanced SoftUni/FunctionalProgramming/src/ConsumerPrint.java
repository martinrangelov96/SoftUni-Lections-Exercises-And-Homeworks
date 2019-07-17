import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Consumer<ArrayList<String>> consumerPrint = (cons) -> {
            System.out.println(cons);
        };

        for (String string : input) {
            System.out.println(string);
        }

    }
}
