package rpg_lab;

import interfaces.Target;
import interfaces.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> weapons;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.weapons = new ArrayList<Weapon>();
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.weapons.add(target.giveExperience());
        }
    }
}
