package exercise03_wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;


    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(Constants.CAT_SOUND);
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(super.getFoodEaten() + food.getFoodQuantity());
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                super.getAnimalName(),
                this.getBreed(),
                decimalFormat.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
