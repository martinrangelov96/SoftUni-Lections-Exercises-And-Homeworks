package exercises.exercise01_eventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler1 = new Handler();

        dispatcher.addNameChangeListener(handler1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name;
        while (!"End".equals(name = reader.readLine())) {
            dispatcher.setNameChanged(name);
        }

    }
}
