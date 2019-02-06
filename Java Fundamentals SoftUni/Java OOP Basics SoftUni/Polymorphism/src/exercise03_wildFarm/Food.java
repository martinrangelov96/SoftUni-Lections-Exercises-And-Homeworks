package exercise03_wildFarm;

public abstract class Food {

    private int foodQuantity;

    public Food() {

    }

    public Food(int foodQuantity) {
        this.setFoodQuantity(foodQuantity);
    }

    protected int getFoodQuantity() {
        return this.foodQuantity;
    }

    private void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
