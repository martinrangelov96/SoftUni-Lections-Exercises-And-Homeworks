package exercise08_militaryElite_unfinished.impl;

import exercise08_militaryElite_unfinished.contracts.Commando;
import exercise08_militaryElite_unfinished.contracts.Mission;

import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<Mission> missions;

    protected CommandoImpl(String id, String firstName, String lastName,
                           double salary, String corps, Set<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder commando = new StringBuilder(super.toString()).append(System.lineSeparator());

        commando.append("Missions:");

        for (Mission mission : this.missions) {
            commando
                    .append(System.lineSeparator())
                    .append("  " +mission);
        }
        return commando.toString();
    }
}
