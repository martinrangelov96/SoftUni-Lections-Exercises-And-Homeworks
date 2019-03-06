package lection01_constructors;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {

//        Class<Book> book = Book.class;
//
//        System.out.println(book.getTypeName());
//        System.out.println(book.getSuperclass().getTypeName());
//
//        Class[] interfaces = book.getInterfaces();
//        for (Class anInterface : interfaces) {
//            System.out.println(anInterface);
//        }
//
//        Constructor bookConstructor = book.getDeclaredConstructor(String.class, int.class);
//
//        Book b = (Book) bookConstructor.newInstance("title", 10);
//
//        System.out.println(b.getTitle() + " " + b.getYear());

        String pathName = "lection01_constructors.test.";
        String className = "Car";

        try {
            Class<?> aClass = Class.forName(pathName + className);

            int index = 1;

            for (Constructor<?> constructor : aClass.getConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                System.out.println(String.format("Constructor: %d with %d parameters",
                        index++, constructor.getParameterCount()));
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println(parameterType.getSimpleName());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
