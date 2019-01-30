import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] namesArray = reader.readLine().split("\\s+");
        List<String> names = new ArrayList<>();
        Collections.addAll(names, namesArray);

        String line;
        while (true) {
            if ("Party!".equals(line = reader.readLine())) {
                break;
            }

            String[] commandTokens = line.split("\\s+");
            String command = commandTokens[0];

            switch (command) {
                case "Double":
                    break;
                case "Remove":
                    break;
            }

        }
    }
    private static void processCommand(Predicate<String> predicate, List<String> names ) {
        for (String name : names) {

        }
    }
}
