package app.entities.colonists.engineers;

public class HardwareEngineer extends Engineer {

    private int classBonus = 2;

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getClassBonus() {
        return this.classBonus;
    }

    @Override
    public int getPotentialBonuses() {
        if (super.getAge() < 18) {
            return super.getPotentialBonuses() + this.getClassBonus();
        }
        return super.getPotentialBonuses();
    }
}
