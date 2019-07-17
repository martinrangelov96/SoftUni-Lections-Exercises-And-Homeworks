import java.util.*;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> venuesAndSingers = new LinkedHashMap<>();
        Map<String, Integer> singerAndMoney = new TreeMap<>();

        while (true) {

            String[] nameAndVenues = scanner.nextLine().split(" @");
            String name = nameAndVenues[0];
            if ("End".equals(name)) {
                break;
            }
            if (nameAndVenues.length < 2) {
                continue;
            }
            String[] venues = nameAndVenues[1].split(" \\d+");
            String[] venueAndMoney = Arrays.toString(nameAndVenues).split("\\D+");
            String venue = venues[0];
            int quantityOfTickets = Integer.parseInt(venueAndMoney[1]);
            int ticketPrice = Integer.parseInt(venueAndMoney[2]);
            int totalMoneyForASinger = quantityOfTickets*ticketPrice;

            if (!venuesAndSingers.containsKey(venue)) {
                venuesAndSingers.put(venue, new ArrayList<>());
                venuesAndSingers.get(venue).add(name);
                singerAndMoney.put(name, totalMoneyForASinger);
            } else {
                if (venuesAndSingers.get(venue).contains(name)) {
                    singerAndMoney.put(name, singerAndMoney.get(name) + totalMoneyForASinger);
                    continue;
                } else {
                    venuesAndSingers.get(venue).add(name);
                    singerAndMoney.put(name, totalMoneyForASinger);
                }
            }


        }

        for (Map.Entry<String, ArrayList<String>> entry : venuesAndSingers.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("#    %s -> %d%n", entry.getValue().get(i), singerAndMoney.get(entry.getKey()));
            }
        }

    }
}
