package exercises.pr02PrivateClassFiddling;

import exercises.pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    private static final String STRING_PATH = "exercises.pr02PrivateClassFiddling.com.";
    private static final String STRING_CLASS_NAME = "BlackBoxInt";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BlackBoxInt blackBoxInt;

        try {
            Class<?> blackBoxIntClass = Class.forName(STRING_PATH + STRING_CLASS_NAME);
            Constructor<?> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();

            String input;
            while (!"END".equals(input = reader.readLine())) {
                String[] tokens = input.split("_");

                Method declaredMethod = blackBoxInt.getClass()
                        .getDeclaredMethod(tokens[0], int.class);
                declaredMethod.setAccessible(true);

                declaredMethod
                        .invoke(blackBoxInt, Integer.parseInt(tokens[1]));

                Field innerValue = blackBoxInt.getClass()
                        .getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                System.out.println(innerValue.get(blackBoxInt));
            }


        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
