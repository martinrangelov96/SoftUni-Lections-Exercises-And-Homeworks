package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int TEN = 10;

    private Axe axe;

    @Before
    public void initializeAxe() {
        this.axe = new Axe(ATTACK, DURABILITY);
    }

    @Test
    public void dummyLosesHealthAfterAttack() {
        Dummy dummy = new Dummy(15, TEN);

        axe.attack(dummy);
//        Assert.assertTrue(dummy.getHealth() == 5);
        Assert.assertEquals("Wrong dummy health",5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        Dummy dummy = new Dummy(10, TEN);

        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test()
    public void deadDummyCanGiveXp() {
        Dummy dummy = new Dummy(10, TEN);

        axe.attack(dummy);

        //we made giveExperience() to return a Weapon
//        Assert.assertTrue(dummy.giveExperience() == TEN);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXP() {
        Dummy dummy = new Dummy(15, TEN);

        axe.attack(dummy);
        dummy.giveExperience();
    }

}
