package lection06_annotations;

import lection01_constructors.Book;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

        Annotation[] annotations = Book.class
                .getDeclaredMethod("print")
                .getDeclaredAnnotations();

//        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
//        Annotation[] methodAnnotations = method.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }

        String[] arr = new String[2];
        Class res = arr.getClass().getComponentType();

        System.out.println(res);
    }
}
