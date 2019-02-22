package app.entities.colonists.soldiers;

import app.entities.colonists.Colonist;

public class Soldier extends Colonist {

    private int classBonus = 3;
    private int ageBonus = 3;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    public int getClassBonus() {
        return this.classBonus;
    }

    public int getAgeBonus() {
        return this.ageBonus;
    }

    @Override
    public int getPotentialBonuses() {
        return this.getClassBonus() + this.getAgeBonus();
    }
}
