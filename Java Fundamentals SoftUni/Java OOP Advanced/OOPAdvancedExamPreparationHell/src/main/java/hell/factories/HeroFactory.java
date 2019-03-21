package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.heroes.Assassin;
import hell.entities.miscellaneous.heroes.Barbarian;
import hell.entities.miscellaneous.heroes.Wizard;
import hell.interfaces.Hero;

public final class HeroFactory {

    private HeroFactory() {
    }

    public static Hero createHero(String name, String type) {
        switch (type) {
            case "Barbarian":
                return new Barbarian(name, new HeroInventory());
            case "Assassin":
                return new Assassin(name, new HeroInventory());
            case "Wizard":
                return new Wizard(name, new HeroInventory());
        }
        return null;
    }
}
