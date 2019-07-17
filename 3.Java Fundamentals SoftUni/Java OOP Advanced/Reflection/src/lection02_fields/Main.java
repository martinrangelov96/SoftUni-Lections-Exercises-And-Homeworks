package lection02_fields;

import lection01_constructors.Book;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Book book = Book.class
                .getConstructor(String.class, int.class)
                .newInstance("zaglavie", 10);

        Field titleField = Book.class.getDeclaredField("title");
        titleField.setAccessible(true);

        Object value = titleField.get(book);
        System.out.println(value);

        titleField.setAccessible(true);
        //we wanna make it false

        titleField.set(book, "promqna");
        value = titleField.get(book);

        System.out.println(book.getTitle());
    }
}
