package exercise05_mordorsCrueltyPlan.models;

public class Mood {

    private String mood;

    public Mood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return String.format("%s", mood);
    }
}
