package lection01_encapsulationTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstSquad;
    private List<Person> reserveSquad;

    public Team(String name) {
        this.setName(name);
        this.firstSquad = new ArrayList<>();
        this.reserveSquad = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstSquad() {
        return Collections.unmodifiableList(this.firstSquad);
    }

    public List<Person> getReserveSquad() {
        return Collections.unmodifiableList(this.reserveSquad);
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstSquad.add(player);
        } else {
            this.reserveSquad.add(player);
        }
    }

    @Override
    public String toString() {
        //First team have 4 players
        //Reserve team have 1 players
        return String.format("First team have %d players%nReserve team have %d players",
                this.firstSquad.size(), this.reserveSquad.size());
    }

}
