package exercise10_MooD3;

public class Demon extends CharacterImpl {

    private double energy;

    protected Demon(String username, Integer level, double energy) {
        super(username, level);
        this.setEnergy(energy);
    }

    protected double getEnergy() {
        return this.energy;
    }

    @Override
    public Double getSpecialPoints() {
        return this.getEnergy();
    }

    @Override
    public String hashPass() {
        return String.valueOf(super.getUsername().length() * 217);
    }

    //super.getUsername().length() * 217; -> hashedPassword
    @Override
    public void setHashedPassword(Object hashedPassword) {
        super.setHashedPassword(this.hashPass());
    }

    @Override
    public String getHashedPassword() {
        return this.hashPass();
    }

    protected void setEnergy(double energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return String.format("%s%s",super.toString(),this.getLevel() * this.getSpecialPoints());
    }
}
