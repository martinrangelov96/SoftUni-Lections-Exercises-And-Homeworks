package hell.factories;

import hell.entities.miscellaneous.items.CommonItem;
import hell.interfaces.Item;

public final class ItemFactory {

    private ItemFactory() {

    }

    public static Item createItem(String name, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus,
                                  int hitPointsBonus, int damageBonus) {

        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus,
                hitPointsBonus, damageBonus);
    }

}
