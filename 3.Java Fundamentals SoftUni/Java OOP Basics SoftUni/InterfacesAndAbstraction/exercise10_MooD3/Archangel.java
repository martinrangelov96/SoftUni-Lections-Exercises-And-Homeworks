package exercise10_MooD3;

public class Archangel extends CharacterImpl {

    private double mana;

    protected Archangel(String username, Integer level, double mana) {
        super(username, level);
        this.setMana(mana);
    }

    @Override
    public Double getSpecialPoints() {
        return this.getMana();
    }

    @Override
    public String hashPass() {
        StringBuilder result = new StringBuilder();
        for (int i = super.getUsername().length() - 1; i > 0; i--) {
            result.append(super.getUsername().charAt(i));
        }
        result
                .append("\"")
                .append(super.getUsername().length() * 21);
        return String.valueOf(result);
    }

    @Override
    public void setHashedPassword(Object hashedPassword) {
        super.setHashedPassword(this.hashPass());
    }

    @Override
    public String getHashedPassword() {
        return this.hashPass();
    }

    protected double getMana() {
        return this.mana;
    }

    protected void setMana(double mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return String.format("%s%s",super.toString(),this.getLevel() * this.getSpecialPoints());
    }
}
