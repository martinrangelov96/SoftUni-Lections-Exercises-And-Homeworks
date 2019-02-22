package app.entities.colonists.medics;

import app.entities.colonists.Colonist;

public abstract class Medic extends Colonist {

    private int classBonus = 2;
    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public int getClassBonus() {
        return this.classBonus;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    public int getPotentialBonuses() {
        return this.getClassBonus();
    }

}
