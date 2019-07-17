package exercise01_genericBox;

public class Box<T> {

    private T value;

    public Box() {

    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",value.getClass().getName(), this.value);
    }
}
