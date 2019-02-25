package exercise04_genericSwapMethodIntegers;

public class Box<T> {

    private T value;

    public Box() {

    }

    public void setValue(T value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return String.format("%s: %d",value.getClass().getName(), this.value);
    }
}
