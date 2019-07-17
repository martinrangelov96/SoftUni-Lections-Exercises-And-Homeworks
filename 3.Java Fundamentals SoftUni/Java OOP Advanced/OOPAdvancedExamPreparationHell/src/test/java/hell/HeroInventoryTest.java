package hell;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeroInventoryTest {

    private static final int MAX_VALUE = Integer.MAX_VALUE;

    private Inventory inventory;
    private int itemNameCounter = 1;

    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();
    }

    private Item createCommonItemMock() {
        Item commonItem = Mockito.mock(Item.class);

        Mockito.when(commonItem.getStrengthBonus()).thenReturn(MAX_VALUE);
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(MAX_VALUE);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(MAX_VALUE);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(MAX_VALUE);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(MAX_VALUE);

        this.itemNameCounter++;

        return commonItem;
    }

    private void seedCommonItems() {
        Item commonItemMock1 = this.createCommonItemMock();
        Mockito.when(commonItemMock1.getName()).thenReturn("commonItemMock1");
        Item commonItemMock2 = this.createCommonItemMock();
        Mockito.when(commonItemMock2.getName()).thenReturn("commonItemMock2");
        Item commonItemMock3 = this.createCommonItemMock();
        Mockito.when(commonItemMock3.getName()).thenReturn("commonItemMock3");

        this.inventory.addCommonItem(commonItemMock1);
        this.inventory.addCommonItem(commonItemMock2);
        this.inventory.addCommonItem(commonItemMock3);
    }

    private void seedRecipeItem() {
        Recipe recipeMock = Mockito.mock(Recipe.class);
        List<String> requiredItems = new ArrayList<>();
        requiredItems.add("commonItemMock1");
        requiredItems.add("commonItemMock2");
        requiredItems.add("commonItemMock4");
        Mockito.when(recipeMock.getRequiredItems()).thenReturn(requiredItems);
        this.inventory.addRecipeItem(recipeMock);
    }

    @Test
    public void getTotalStrengthBonus() {
        //Arrange
        seedCommonItems();

        //Act
        long actualTotalBonus = this.inventory.getTotalStrengthBonus();
        long expectedTotalBonus = 3L * MAX_VALUE;

        //Assert
        Assert.assertEquals(expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void getTotalAgilityBonus() {
        //Arrange
        seedCommonItems();

        //Act
        long actualTotalBonus = this.inventory.getTotalAgilityBonus();
        long expectedTotalBonus = 3L * MAX_VALUE;

        //Assert
        Assert.assertEquals(expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        //Arrange
        seedCommonItems();

        //Act
        long actualTotalBonus = this.inventory.getTotalIntelligenceBonus();
        long expectedTotalBonus = 3L * MAX_VALUE;

        //Assert
        Assert.assertEquals(expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void getTotalHitPointsBonus() {
        //Arrange
        seedCommonItems();

        //Act
        long actualTotalBonus = this.inventory.getTotalHitPointsBonus();
        long expectedTotalBonus = 3L * MAX_VALUE;

        //Assert
        Assert.assertEquals(expectedTotalBonus, actualTotalBonus);
    }


    @Test
    public void getTotalDamageBonus() {
        //Arrange
        seedCommonItems();

        //Act
        long actualTotalBonus = this.inventory.getTotalDamageBonus();
        long expectedTotalBonus = 3L * MAX_VALUE;

        //Assert
        Assert.assertEquals(expectedTotalBonus, actualTotalBonus);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addCommonItem() {
        //Arrange
        this.seedCommonItems();
        this.seedRecipeItem();
        Item commonItemMock4 = Mockito.mock(Item.class);
        Mockito.when(commonItemMock4.getName()).thenReturn("commonItemMock4");

        //Act
        this.inventory.addCommonItem(commonItemMock4);
        int actualCountOfCommonItems = 0;

        try {
            Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
            commonItemsField.setAccessible(true);
            Map<String, Item> commonItemsMap = (Map<String, Item>) commonItemsField.get(this.inventory);
            actualCountOfCommonItems = commonItemsMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedCountOfCommonItems = 2;

        //Assert
        Assert.assertEquals(expectedCountOfCommonItems, actualCountOfCommonItems);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addRecipeItem() {
        //Arrange
        Recipe recipe = Mockito.mock(Recipe.class);

        //Act
        this.inventory.addRecipeItem(recipe);
        int actualCountOfRecipes = 0;

        try {
            Field inventoryField = this.inventory.getClass().getDeclaredField("recipeItems");
            inventoryField.setAccessible(true);
            Map<String, Recipe> itemMap = (Map<String, Recipe>) inventoryField.get(this.inventory);
            actualCountOfRecipes = itemMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedItemsSize = 1;

        //Assert
        Assert.assertEquals(expectedItemsSize, actualCountOfRecipes);
    }
}