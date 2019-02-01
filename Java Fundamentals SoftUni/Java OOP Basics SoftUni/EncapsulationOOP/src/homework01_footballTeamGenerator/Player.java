package homework01_footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String NAME_EXCEPTION_MESSAGE = "A name should not be empty.";
    private static final String STATS_EXCEPTION_MESSAGE = "%s should be between 0 and 100.";

    private String name;
    private int stats;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public Player() {

    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException(String.format(STATS_EXCEPTION_MESSAGE, "Endurance"));
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException(String.format(STATS_EXCEPTION_MESSAGE, "Sprint"));
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException(String.format(STATS_EXCEPTION_MESSAGE, "Dribble"));
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException(String.format(STATS_EXCEPTION_MESSAGE, "Passing"));
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException(String.format(STATS_EXCEPTION_MESSAGE, "Shooting"));
        }
        this.shooting = shooting;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    //int endurance, int sprint, int dribble, int passing, int shooting
    public int calculateStatsForAPlayer() {
        return (int) Math.round((this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0);
    }

    public String getName() {
        return this.name;
    }
}
