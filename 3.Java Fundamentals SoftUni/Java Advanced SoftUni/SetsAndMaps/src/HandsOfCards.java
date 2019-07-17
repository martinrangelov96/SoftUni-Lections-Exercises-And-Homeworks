import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> types = new HashMap<>() {{
            put("S", 4);
            put("H", 3);
            put("D", 2);
            put("C", 1);
        }};

        Map<String, Integer> powers = new HashMap<>() {{
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
        }};

        Map<String, Set<String>> playerAndCards = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if ("JOKER".equals(input)) {
                break;
            }

            String[] nameAndCards = input.split(":");
            String name = nameAndCards[0];
            String[] cardsInput = nameAndCards[1].split(", ");

            Set<String> cards = new HashSet<>();

            Collections.addAll(cards, cardsInput);

            if (!playerAndCards.containsKey(name)) {
                playerAndCards.put(name, cards);
            } else {
                Set<String> previousCards = playerAndCards.get(name);
                previousCards.addAll(cards);
            }
        }

        for (Map.Entry<String, Set<String>> player : playerAndCards.entrySet()) {
            int totalCardsStrength = 0;
            for (String card : player.getValue()) {
                String power = card.substring(0, card.length() - 1);
                String type = String.valueOf(card.charAt(card.length() - 1));

                totalCardsStrength += computeCardStrength(power, type, types, powers);
            }

            System.out.printf("%s: %d%n", player.getKey(), totalCardsStrength);

        }

    }

    private static int computeCardStrength(String power, String type, Map<String, Integer> types, Map<String, Integer> powers) {
        int resultPower = 0;
        try {
            resultPower = Integer.parseInt(power);
        } catch (NumberFormatException nfe) {
             resultPower = powers.get(power);
        }
        return types.get(type) * resultPower;
    }
}
