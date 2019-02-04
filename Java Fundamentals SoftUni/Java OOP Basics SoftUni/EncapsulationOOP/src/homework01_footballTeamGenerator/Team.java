package homework01_footballTeamGenerator;

import java.util.*;

public class Team {
    private String name;
    private int rating;
    private Set<String> teams;
    private Map<String, List<Player>> teamWithPlayers;

    public Team(String name) {
        this.name = name;
        this.teams = new LinkedHashSet<>();
        this.teamWithPlayers = new LinkedHashMap<>();
    }

    public void addTeam(String teamName) {
        teams.add(teamName);
    }

    public void addPlayer(Player player, String team) {
        if (!teams.contains(team)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", team));
        }
        if (!teamWithPlayers.containsKey(name)) {
            teamWithPlayers.put(this.name, new ArrayList<>());
            teamWithPlayers.get(this.name).add(player);
        } else {
            teamWithPlayers.get(this.name).add(player);
        }
    }

    public void removePlayer(Player player, String playerName) {
        if (teamWithPlayers.get(this.name).contains(player) && player.getName().equals(playerName)) {
            teamWithPlayers.get(this.name).remove(player);
        } else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
    }


    public void teamRating(String teamName) {
        if (!teams.contains(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
        int teamRating = 0;
        for (Map.Entry<String, List<Player>> entry : teamWithPlayers.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                teamRating += entry.getValue().get(i).calculateStatsForAPlayer();
            }
            if (entry.getValue().size() > 0) {
                teamRating /= entry.getValue().size();
            } else {
                break;
            }
        }
        System.out.printf("%s - %d", teamName, teamRating);
    }
}
