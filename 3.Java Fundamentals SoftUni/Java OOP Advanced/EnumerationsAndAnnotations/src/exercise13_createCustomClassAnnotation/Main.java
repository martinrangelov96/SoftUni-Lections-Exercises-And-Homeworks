package exercise13_createCustomClassAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"END".equals(input = reader.readLine())) {
            switch (input) {
                case "Author":
                    Class<Weapon> weaponClass = Weapon.class;
                    if (weaponClass.isAnnotationPresent(CustomAnnotation.class)) {
                        CustomAnnotation annotation = weaponClass.getAnnotation(CustomAnnotation.class);
                        System.out.println(String.format("Author: %s", annotation.author()));
                    }
                    break;
                case "Revision":
                    Class<Weapon> weaponClass1 = Weapon.class;
                    if (weaponClass1.isAnnotationPresent(CustomAnnotation.class)) {
                        CustomAnnotation annotation = weaponClass1.getAnnotation(CustomAnnotation.class);
                        System.out.println(String.format("Revision: %d", annotation.revision()));
                    }
                    break;
                case "Description":
                    Class<Weapon> weaponClass2 = Weapon.class;
                    if (weaponClass2.isAnnotationPresent(CustomAnnotation.class)) {
                        CustomAnnotation annotation = weaponClass2.getAnnotation(CustomAnnotation.class);
                        System.out.println(String.format("Class description: %s", annotation.description()));
                    }
                    break;
                case "Reviewers":
                    Class<Weapon> weaponClass3 = Weapon.class;
                    if (weaponClass3.isAnnotationPresent(CustomAnnotation.class)) {
                        CustomAnnotation annotation = weaponClass3.getAnnotation(CustomAnnotation.class);
                        System.out.println(String.format("Reviewers: %s", annotation.reviewers()));
                    }
                    break;
            }
        }
    }
}
