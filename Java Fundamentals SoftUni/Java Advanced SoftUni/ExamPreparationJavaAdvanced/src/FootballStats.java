import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // teamName -> List of games
        Map<String, List<String>> games = new HashMap<>();

        //Real Madrid - Barcelona 5:0
        String line = reader.readLine();
        Pattern pattern = Pattern
                .compile("([A-Za-z]+) - ([A-Za-z]+) result ([0-9]+):([0-9]+)");

        while (!"Season End".equals(line)) {

            Matcher matcher = pattern.matcher(line);

            matcher.find();

            String homeTeam = matcher.group(1);
            String guest = matcher.group(2);
            String homeTeamResult = matcher.group(3);
            String guestResult = matcher.group(4);

            if (!games.containsKey(homeTeam)) {
                games.put(homeTeam, new ArrayList<>());
            }

            if (!games.containsKey(guest)) {
                games.put(guest, new ArrayList<>());
            }

            String homeGame = " - " + guest + " -> " + homeTeamResult + ":" + guestResult;
            String guestGame = " - " + homeTeam + " -> " + guestResult + ":" + homeTeamResult;

            games.get(homeTeam).add(homeGame);
            games.get(guest).add(guestGame);

            line = reader.readLine();
        }

        printResult(games, reader);

    }

    private static void printResult(Map<String, List<String>> games, BufferedReader reader) throws IOException {
        String[] teams = reader.readLine().split(", ");

        for (String team : teams) {
            games.get(team).stream()
                    .sorted(Comparator.comparing(x -> x.split(" -> ")[0]))
                    .forEach(game -> System.out.println(String.format("%s%s", team, game)));
        }
    }
}
