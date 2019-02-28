package exercise01_listyIterator;

import java.util.List;

public class ListyIterator<T> {

    private T[] items;
    private int index;

    public ListyIterator(T... args) {
        this.items = args;
    }

    public boolean move () {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (items != null) {
            return this.index < this.items.length - 1;
        } else {
            return false;
        }
    }

    public void print() {
        if (items.length > 0 && index < items.length) {
            System.out.println(items[index]);
        } else {
            System.out.println("Invalid Operation!");
        }
    }

}
