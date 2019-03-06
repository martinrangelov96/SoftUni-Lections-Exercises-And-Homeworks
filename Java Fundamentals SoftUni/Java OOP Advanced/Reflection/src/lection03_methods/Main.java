package lection03_methods;

import lection01_constructors.Book;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Book book = Book.class
                .getConstructor(String.class, int.class)
                .newInstance("zaglavie", 10);

//        Method[] bookMethods = Book.class.getDeclaredMethods();
        //get all methods in Book(public,private,default, etc)
        Method[] bookMethods = Book.class.getMethods();
        //get only public methods in Book and its' parents methods

        for (Method bookMethod : bookMethods) {
            System.out.println(bookMethod.getName());
        }

        Method bookToString = Book.class.getDeclaredMethod("toString");
        //bookToPrintMethod.setAccessible(true) (IF method is private), but do it anyway just in case?
        //String result = (String) bookToPrintMethod.invoke(book);
        //bookToPrintMethod.setAccessible(false)

//        System.out.println(bookToString.getName());


    }
}
