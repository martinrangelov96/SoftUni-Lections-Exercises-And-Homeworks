package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class HeroTests {
    public static final int ATTACK = 10;
    public static final int DURABILITY = 10;
    public static final int HEALTH = 10;
    public static final int XP = 10;

    private Weapon weapon;
    private Target target;

    @Before
    public void initializeWeaponAndDummy() {
        this.weapon = Mockito.mock(Axe.class);
        this.target = Mockito.mock(Dummy.class);
        Mockito.when(this.target.isDead()).thenReturn(true);
        Mockito.when(this.target.giveExperience()).thenReturn(this.weapon);
    }

    @Test
    public void testHero() {
        Hero hero = new Hero("hero", this.weapon);
        hero.attack(this.target);
        Assert.assertEquals(1, hero.getWeapons().size());

    }
}
