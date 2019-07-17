package exercise03_wildFarm;

import java.text.DecimalFormat;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(Constants.ZEBRA_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            System.out.printf(Constants.ANIMAL_NOT_EATING_FOOD, this.getClass().getSimpleName());
        } else {
            setFoodEaten(super.getFoodEaten() + food.getFoodQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                decimalFormat.format(this.getAnimalWeight()),
                super.getLivingRegion(),
                this.getFoodEaten());
    }

}
