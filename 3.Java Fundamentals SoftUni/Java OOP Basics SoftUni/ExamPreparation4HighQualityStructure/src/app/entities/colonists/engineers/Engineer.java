package app.entities.colonists.engineers;

import app.entities.colonists.Colonist;

public abstract class Engineer extends Colonist {

    private int classBonus = 3;

    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    public int getClassBonus() {
        return this.classBonus;
    }

    @Override
    public int getPotentialBonuses() {
        if (super.getAge() > 30) {
            return + this.classBonus + 2;
        }
        return this.classBonus;
    }
}
