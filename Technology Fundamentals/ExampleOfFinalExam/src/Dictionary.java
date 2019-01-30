import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> definitionsByWord = new TreeMap<>();

        String[] pairs = scanner.nextLine().split(" \\| ");

        for (String pair : pairs) {
            String[] wordAndDefinitions = pair.split(": ");

            String word = wordAndDefinitions[0];
            String definition = wordAndDefinitions[1];

            if (!definitionsByWord.containsKey(word)) {
                definitionsByWord.put(word, new ArrayList<>());
            }
            definitionsByWord.get(word).add(" -"+definition);
            
        }

        String[] words = scanner.nextLine().split(" \\| ");

        for (String word : words) {
            if (!definitionsByWord.containsKey(word)) {
                continue;
            }

            System.out.println(word);
            System.out.println(String.join(System.lineSeparator(),definitionsByWord.get(word).stream().sorted((x1, x2) -> Integer.compare(x2.length(), x1.length())).collect(Collectors.toList())));
        }

        if (scanner.nextLine().equals("List")) {
            System.out.println(String.join(" ", definitionsByWord.keySet()));
        }

    }
}
