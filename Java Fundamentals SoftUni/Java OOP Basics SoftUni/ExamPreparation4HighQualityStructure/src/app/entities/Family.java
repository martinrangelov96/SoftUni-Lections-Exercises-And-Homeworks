package app.entities;

import app.entities.colonists.Colonist;

import java.util.*;

public class Family {

    private String id;
    private Map<String, Colonist> members;

    public Family(String id) {
        this.id = id;
        this.members = new TreeMap<>();
    }

    public String getId() {
        return this.id;
    }

    public List<Colonist> getMembers() {
        return Collections.unmodifiableList(new ArrayList<>(this.members.values()));
    }

    public void addMember(Colonist colonist) {
        this.members.put(colonist.getId(), colonist);
    }

    public void removeMember(String id) {
        this.members.remove(id);
    }

    public int getPotential() {
        return this.members.values().stream()
                .mapToInt(Colonist::getPotential)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s:",this.getId()))
                .append(System.lineSeparator());

                this.members.values()
                        .forEach(colonist -> sb.append(String.format("-%s: %d%n",colonist.getId(), colonist.getPotential())));

        return sb.toString();
    }
}
