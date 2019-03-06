package lection05_accessModifiers;

import lection01_constructors.Book;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        int modifier = Book.class.getModifiers();

        System.out.println(Modifier.isPrivate(modifier));
    }
}
