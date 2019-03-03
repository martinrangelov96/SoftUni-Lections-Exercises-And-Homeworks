package lection05codingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();

        Map<String, List<String>> authorMethods = new HashMap<>();

        for (Method method : methods) {
            Author annotation = method.getDeclaredAnnotation(Author.class);
            if (annotation != null) {
                authorMethods.putIfAbsent(annotation.name(), new ArrayList<>());
                authorMethods.get(annotation.name()).add(method.getName());
            }
        }

        for (Map.Entry<String, List<String>> entry : authorMethods.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(String.format("%s: %s(), %s()", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1))
                        .replace("[", "").replace("]", ""));
            } else {
                System.out.println(
                        String.format
                                ("%s: %s()", entry.getKey(), entry.getValue()).replace("[", "").replace("]", ""));

            }
        }
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {

        Tracker.printMethodsByAuthor(Tracker.class);

    }
}
