package rpg_lab;

import interfaces.Target;
import interfaces.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoots;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoots = new ArrayList<Weapon>();
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public Weapon giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.possibleLoots.get(
                new Random().nextInt(this.possibleLoots.size()));

    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
