package hell;

import hell.factories.HeroFactory;
import hell.factories.ItemFactory;
import hell.factories.RecipeFactory;
import hell.interfaces.*;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Hero> heroes = new HashMap<>();

    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        String input;
        while (true) {
            if ("Quit".equals(input = reader.readLine())) {
                writer.writeLine(printHeroesInfo());
                break;
            }

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            String heroName;
            int strengthBonus;
            int agilityBonus;
            int intelligenceBonus;
            int hitPointsBonus;
            int damageBonus;

            switch (command) {
                case "Hero":
                    heroName = tokens[1];
                    String heroType = tokens[2];
                    Hero hero = HeroFactory.createHero(heroName, heroType);
                    if (hero != null) {
                        heroes.putIfAbsent(hero.getName(), hero);
                    }
                    System.out.println(String.format("Created %s - %s", heroType, heroName));
                    break;
                case "Item":
                    String itemName = tokens[1];
                    heroName = tokens[2];
                    strengthBonus = Integer.parseInt(tokens[3]);
                    agilityBonus = Integer.parseInt(tokens[4]);
                    intelligenceBonus = Integer.parseInt(tokens[5]);
                    hitPointsBonus = Integer.parseInt(tokens[6]);
                    damageBonus = Integer.parseInt(tokens[7]);
                    Item item = ItemFactory.createItem(itemName, heroName, strengthBonus, agilityBonus, intelligenceBonus,
                            hitPointsBonus, damageBonus);
                    hero = heroes.get(heroName);
                    hero.addItem(item);
                    System.out.println(String.format("Added item - %s to Hero - %s",
                            itemName, heroName));
                    break;
                case "Recipe":
                    String recipeName = tokens[1];
                    heroName = tokens[2];
                    strengthBonus = Integer.parseInt(tokens[3]);
                    agilityBonus = Integer.parseInt(tokens[4]);
                    intelligenceBonus = Integer.parseInt(tokens[5]);
                    hitPointsBonus = Integer.parseInt(tokens[6]);
                    damageBonus = Integer.parseInt(tokens[7]);
                    List<String> requiredItems = Arrays.stream(tokens).skip(8).collect(Collectors.toList());
                    Recipe recipe = RecipeFactory.createRecipe(recipeName, heroName, strengthBonus, agilityBonus, intelligenceBonus,
                            hitPointsBonus, damageBonus, requiredItems);
                    hero = heroes.get(heroName);
                    hero.addRecipe(recipe);
                    System.out.println(String.format("Added recipe - %s to Hero - %s",
                            recipeName, heroName));
                    break;
                case "Inspect":
                    heroName = tokens[1];
                    hero = heroes.get(heroName);

                    writer.writeLine(hero.toString());
                    break;
            }
        }
    }

    private static String printHeroesInfo() {
        StringBuilder heroesInfo = new StringBuilder();

        final int[] index = {1};

        heroes.values()
                .stream()
                .sorted(getHeroComparator())
                .collect(Collectors.toList())
                .forEach(hero -> {
                    String items = hero.getItems().size() == 0 ?
                            "None" :
                            hero.getItems()
                                    .stream()
                                    .map(Item::getName).collect(Collectors.joining(", "));
                    heroesInfo.append(String.format("%d. %s: %s", index[0]++, hero.getClass().getSimpleName(), hero.getName()))
                            .append(System.lineSeparator())
                            .append(String.format("###HitPoints: %d", hero.getHitPoints())).append(System.lineSeparator())
                            .append(String.format("###Damage: %d", hero.getDamage())).append(System.lineSeparator())
                            .append(String.format("###Strength: %d", hero.getStrength())).append(System.lineSeparator())
                            .append(String.format("###Agility: %d", hero.getAgility())).append(System.lineSeparator())
                            .append(String.format("###Intelligence: %d", hero.getIntelligence())).append(System.lineSeparator())
                            .append(String.format("###Items: %s", items)).append(System.lineSeparator());

                });

        return heroesInfo.toString().trim();
    }

    private static Comparator<? super Hero> getHeroComparator() {

        return (hero1, hero2) -> {
            long firstComparatorSumHero1 = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
            long firstComparatorSumHero2 = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();

            int comparatorByFirstSum = Long.compare(firstComparatorSumHero2, firstComparatorSumHero1);

            if (comparatorByFirstSum != 0) {
                return comparatorByFirstSum;
            }

            long secondComparatorSumHero1 = hero1.getHitPoints() + hero1.getDamage();
            long secondComparatorSumHero2 = hero2.getHitPoints() + hero2.getDamage();

            return Long.compare(secondComparatorSumHero2, secondComparatorSumHero1);

        };
    }
}