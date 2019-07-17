package app.entities.cells.bloodCells;

public class RedBloodCell extends BloodCell {

    private int velocity;

    public RedBloodCell(String id, int health, int positionRow,
                        int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Velocity: %d | Energy: %d%n",
                super.toString(), super.getHealth(), this.getVelocity(), this.getEnergy());
    }
}
