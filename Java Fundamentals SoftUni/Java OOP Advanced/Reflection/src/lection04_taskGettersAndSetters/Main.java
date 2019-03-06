package lection04_taskGettersAndSetters;

import lection01_constructors.Book;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] methods = Book.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")
                    && method.getParameterTypes().length == 0
                    && !method.getReturnType().equals(void.class)) {

                getters.add(method);
            } else if (method.getName().startsWith("set")
                    && method.getParameterTypes().length == 1
                    && method.getReturnType().equals(void.class)) {

                setters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.println(getter.getName() + " will return " + getter.getReturnType().getSimpleName());
        }

        for (Method setter : setters) {
            System.out.println(setter.getName() + " and will set field of " + setter.getParameterTypes()[0].getSimpleName());
        }

    }
}
