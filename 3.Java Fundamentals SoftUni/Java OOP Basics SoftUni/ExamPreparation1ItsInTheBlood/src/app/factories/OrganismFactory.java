package app.factories;

import app.entities.Organism;

public final class OrganismFactory {

    private OrganismFactory() {}

    public static Organism createOrganism(String name) {
        return new Organism(name);
    }
}
