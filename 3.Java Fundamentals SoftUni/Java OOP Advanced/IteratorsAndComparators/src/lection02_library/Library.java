package lection02_library;

import java.util.Iterator;

public class Library<T> implements Iterable<T> {

    private T[] books;

    public Library(T... books) {
        this.books = books;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<T> {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public T next() {
            return books[counter++];
        }
    }
}
