package exercise01_person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person person = null;
        Child child = null;

        try{
            child = new Child(name, age);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        if (child != null) {
            System.out.println(child);
        }

    }
}
