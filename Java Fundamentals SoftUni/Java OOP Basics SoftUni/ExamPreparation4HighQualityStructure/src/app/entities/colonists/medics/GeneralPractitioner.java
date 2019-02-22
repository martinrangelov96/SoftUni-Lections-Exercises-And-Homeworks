package app.entities.colonists.medics;

public class GeneralPractitioner extends Medic {

    private int classBonus = 1;

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getClassBonus() {
        return this.classBonus;
    }

    @Override
    public int getPotentialBonuses() {
        int finalBonus = 0;
        if (super.getAge() > 15) {
            finalBonus += this.getClassBonus();
        }

        if (super.getSign().equals("caring")) {
            finalBonus += 1;
        }

        if (super.getSign().equals("careless")) {
            finalBonus -= 2;
        }
        return super.getPotentialBonuses() + finalBonus + this.getClassBonus();
    }
}
