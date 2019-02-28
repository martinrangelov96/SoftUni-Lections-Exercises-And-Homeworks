package exercise02_collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

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

    public void printAll() {
        for (T item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new IterableListyIterator();
    }

    private final class IterableListyIterator implements Iterator<T> {

        private int index;

        @Override
        public boolean hasNext() {
            return this.index < items.length;
        }

        @Override
        public T next() {
            return items[this.index++];
        }
    }
}
