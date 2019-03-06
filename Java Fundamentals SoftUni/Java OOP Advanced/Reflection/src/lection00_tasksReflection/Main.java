package lection00_tasksReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        fields.addAll(Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .collect(Collectors.toList()));

        getters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get")
                        && !m.getReturnType().equals(void.class))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .collect(Collectors.toList()));

        setters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set")
                        && !m.getReturnType().equals(void.class))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .collect(Collectors.toList()));

        for (Field field : fields) {
            System.out.println(field.getName() + " must be private!");
        }

        for (Method method : getters) {
            System.out.println(method.getName() + " have to be public!");
        }

        for (Method method : setters) {
            System.out.println(method.getName() + " have to be private!");

        }

    }
}
