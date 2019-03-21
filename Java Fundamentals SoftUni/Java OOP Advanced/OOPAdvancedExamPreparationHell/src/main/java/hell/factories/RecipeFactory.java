package hell.factories;

import hell.entities.miscellaneous.items.RecipeItem;
import hell.interfaces.Recipe;

import java.util.List;

public final class RecipeFactory {

    private RecipeFactory() {

    }

    public static Recipe createRecipe(String name, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus,
                                      int hitPointsBonus, int damageBonus, List<String> requiredItems) {

        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus,
                requiredItems);

    }
}
