package homework01_footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Team team = null;
        Player player = null;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");
            String teamName = tokens[1];

            if (tokens[0].equals("Team")) {
                try{
                    team = new Team(teamName);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                if (team != null) {
                    team.addTeam(teamName);
                }
            } else if (tokens[0].equals("Add")) {
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);
                try {
                    player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    if (team != null) {
                        team.addPlayer(player, teamName);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            } else if (tokens[0].equals("Remove")) {
                String playerName = tokens[2];
                if (team != null) {
                    try {
                        team.removePlayer(player, playerName);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                }
            } else if (tokens[0].equals("Rating")) {
                if (team != null) {
                    team.teamRating(teamName);
                }
            }

        }

    }
}
