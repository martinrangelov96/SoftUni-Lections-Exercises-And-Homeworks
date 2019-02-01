package exercise02_animalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private int age;
    private String name;

    public Chicken(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private double calculateProductPerDay() {
        if (age >= 0 && age <= 5) {
            return 2;
        } else if (age >= 6 && age <=11) {
            return 1;
        } else return 0.75;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.name, this.age, df.format(this.calculateProductPerDay()));
    }
}
