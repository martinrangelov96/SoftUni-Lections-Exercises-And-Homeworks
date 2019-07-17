package app.entities.monuments;

public abstract class Monument {

    private String name;

    public Monument(String name) {
        this.name = name;
    }

    public abstract int getAffinity();

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
