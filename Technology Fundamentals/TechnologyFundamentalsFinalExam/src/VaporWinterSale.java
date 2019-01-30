import java.util.*;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> gamesAndPrices = new HashMap<>();
        Map<String, String> gamesAndDLCs = new HashMap<>();

        Map<String, Double> gamesWithDLC = new HashMap<>();
        Map<String, Double> gamesWithoutDLC = new HashMap<>();

        String[] input = scanner.nextLine().split(", ");

        String gameName = "";
        Double gamePrice = 0.0;

        String dlcGame = "";

        for (int i = 0; i < input.length; i++) {
            if (input[i].contains("-")) {
                String[] gameData = input[i].split("-");
                gameName = gameData[0];
                gamePrice = Double.valueOf(gameData[1]);
                if (!gamesAndPrices.containsKey(gameName)) {
                    gamesAndPrices.put(gameName, gamePrice);
                    gamesWithoutDLC.put(gameName, gamePrice);
                }
            } else if (input[i].contains(":")) {
                String[] dlcData = input[i].split(":");
                dlcGame = dlcData[0];
                String dlcName = dlcData[1];

                if (gamesAndPrices.containsKey(dlcGame)) {
                    Double newPrice = gamesAndPrices.get(dlcGame) * 1.20;
                    gamesAndDLCs.put(dlcGame, dlcName);
                    gamesAndPrices.put(dlcGame, newPrice);

                    gamesWithoutDLC.put(dlcGame, newPrice);
                    gamesWithoutDLC.remove(dlcGame);

                } else {
                    continue;
                }
            }
        }

        System.out.println();

        for (Map.Entry<String, String> stringStringEntry : gamesAndDLCs.entrySet()) {
            gamesWithDLC.put(stringStringEntry.getKey(), gamesAndPrices.get(stringStringEntry.getKey()) * 0.50);
        }

        for (Map.Entry<String, Double> stringDoubleEntry : gamesWithoutDLC.entrySet()) {
            gamesWithoutDLC.put(stringDoubleEntry.getKey(), gamesAndPrices.get(stringDoubleEntry.getKey()) * 0.80);
        }

//        for (Map.Entry<String, Double> entry : gamesAndPrices.entrySet()) {
//            if (entry.getKey().compareTo(gamesAndDLCs.get(gameName)) == 0) {
//                gamesAndPrices.remove(gameName);
//            }
//        }

        gamesWithDLC.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(entry -> {
                    System.out.printf("%s - %s - %.2f%n", entry.getKey(), gamesAndDLCs.get(entry.getKey()), entry.getValue());
                });

        gamesWithoutDLC.entrySet().stream()
                .sorted((d1,d2) -> Double.compare(d2.getValue(),(d1.getValue())))
                .forEach(entry -> {
                    System.out.printf("%s - %.2f%n", entry.getKey(), entry.getValue());
                });
    }

}
