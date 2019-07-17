package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int ZERO = 0;

    @Test
    public void weaponAttacksLosesDurability() {
        Axe axe = new Axe(ATTACK, DURABILITY);
        Dummy dummy = new Dummy(10, 10);
        axe.attack(dummy);
        Assert.assertTrue(axe.getDurabilityPoints() == 9);
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWeapon() {
        Axe axe = new Axe(ATTACK, ZERO);
        Dummy dummy = new Dummy(10, 10);
        axe.attack(dummy);
    }
}
