package exercise03_wildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] animalData = input.split("\\s+");
            Animal animal = setAnimal(animalData);
            String[] foodData = reader.readLine().split("\\s+");
            Food food = setFood(foodData);
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            input = reader.readLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }

    private static Food setFood(String[] foodData) {
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);

        Food food = null;

        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
            default:
                break;
        }

        return food;
    }

    private static Animal setAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        Animal animal = null;

        switch (animalType) {
            case "Cat":
                String animalBreed = animalData[4];
                animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            default:
                break;
        }

        return animal;
    }

}

