package app.entities.colonists.medics;

public class Surgeon extends Medic {

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotentialBonuses() {
        int finalBonus = 0;
        if (super.getAge() > 25 && super.getAge() < 35) {
            finalBonus += 2;
        }

        if (super.getSign().equals("precise")) {
            finalBonus += 3;
        }

        if (super.getSign().equals("butcher")) {
            finalBonus -= 3;
        }

        return super.getPotentialBonuses() +  finalBonus;
    }
}
