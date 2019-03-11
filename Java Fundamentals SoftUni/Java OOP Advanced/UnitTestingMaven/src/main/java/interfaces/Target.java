package interfaces;

public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    Weapon giveExperience();

    boolean isDead();
}
