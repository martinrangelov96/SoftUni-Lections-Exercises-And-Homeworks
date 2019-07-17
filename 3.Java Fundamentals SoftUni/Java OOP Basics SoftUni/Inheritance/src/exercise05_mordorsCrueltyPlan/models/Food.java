package exercise05_mordorsCrueltyPlan.models;

public class Food {

    private String name;
    private int pointsOfHappiness;

    public Food(String name, int pointsOfHappiness) {
        this.name = name;
        this.pointsOfHappiness = pointsOfHappiness;
    }

    public int getPointsOfHappiness() {
        return this.pointsOfHappiness;
    }
}
