package exercise05_mordorsCrueltyPlan;

import exercise05_mordorsCrueltyPlan.factories.FoodFactory;
import exercise05_mordorsCrueltyPlan.factories.MoodFactory;
import exercise05_mordorsCrueltyPlan.models.Food;
import exercise05_mordorsCrueltyPlan.models.Mood;
import exercise05_mordorsCrueltyPlan.models.foods.*;
import exercise05_mordorsCrueltyPlan.models.moods.Angry;
import exercise05_mordorsCrueltyPlan.models.moods.Happy;
import exercise05_mordorsCrueltyPlan.models.moods.JavaScript;
import exercise05_mordorsCrueltyPlan.models.moods.Sad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foodInput = reader.readLine().split("\\s+");

        FoodFactory foodFactory = new FoodFactory();

        for (String typeOfFood : foodInput) {
            if (typeOfFood.equalsIgnoreCase("cram")) {
                Cram cram = new Cram(typeOfFood);
                foodFactory.addFood(cram);
            } else if (typeOfFood.equalsIgnoreCase("lembas")) {
                Lembas lembas = new Lembas(typeOfFood);
                foodFactory.addFood(lembas);
            } else if (typeOfFood.equalsIgnoreCase("apple")) {
                Apple apple = new Apple(typeOfFood);
                foodFactory.addFood(apple);
            } else if (typeOfFood.equalsIgnoreCase("melon")) {
                Melon melon = new Melon(typeOfFood);
                foodFactory.addFood(melon);
            } else if (typeOfFood.equalsIgnoreCase("honeycake")) {
                HoneyCake honeyCake = new HoneyCake(typeOfFood);
                foodFactory.addFood(honeyCake);
            } else if (typeOfFood.equalsIgnoreCase("mushrooms")) {
                Mushrooms mushrooms = new Mushrooms(typeOfFood);
                foodFactory.addFood(mushrooms);
            } else {
                UnknownFood unknownFood = new UnknownFood(typeOfFood);
                foodFactory.addFood(unknownFood);
            }

        }

        System.out.println(foodFactory);
        MoodFactory moodFactory = new MoodFactory(foodFactory);
        if (moodFactory.getMoodPoints() < -5) {
            Angry angry = new Angry("Angry");
            System.out.println(angry.toString());
        } else if (moodFactory.getMoodPoints() > -5 && moodFactory.getMoodPoints() < 0) {
            Sad sad = new Sad("Sad");
            System.out.println(sad.toString());
        } else if (moodFactory.getMoodPoints() > 0 && moodFactory.getMoodPoints() < 15) {
            Happy happy = new Happy("Happy");
            System.out.println(happy.toString());
        } else if (moodFactory.getMoodPoints() > 15) {
            JavaScript javaScript = new JavaScript("JavaScript");
            System.out.println(javaScript.toString());
        }

    }
}
