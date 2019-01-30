import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> synonyms = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonyms.putIfAbsent(word, new ArrayList<>());
            List<String> synonymsByWord = synonyms.get(word);
            synonymsByWord.add(synonym);
        }

        synonyms.forEach((word,synonymsByWord) -> {
            System.out.print(word + " - ");
            System.out.println(String.join(", ", synonymsByWord));
        });

    }
}
