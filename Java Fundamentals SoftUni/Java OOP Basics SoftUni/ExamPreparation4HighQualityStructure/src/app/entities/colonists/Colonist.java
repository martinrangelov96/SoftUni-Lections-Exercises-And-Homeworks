package app.entities.colonists;

public abstract class Colonist {

    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public int getPotential() {
        return this.getTalent() + this.getPotentialBonuses();
    }

    public void grow(int years) {
        this.age += years;
    }

    public abstract int getPotentialBonuses();
}
