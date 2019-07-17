package app.entities.colonists.engineers;

public class SoftwareEngineer extends Engineer {

    private int classBonus = 2;

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getClassBonus() {
        return this.classBonus;
    }

    @Override
    public int getPotentialBonuses() {
        return super.getPotentialBonuses() + this.getClassBonus();
    }

}
