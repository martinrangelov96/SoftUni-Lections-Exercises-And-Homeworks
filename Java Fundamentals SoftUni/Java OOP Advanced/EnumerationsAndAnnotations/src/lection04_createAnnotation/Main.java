package lection04_createAnnotation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Subject(categories = "sdadasdsadsadasdasd")
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Subject subject = (Subject) Main.class.getAnnotation(Subject.class);
        System.out.println(subject.categories());

    }
}
