package exercise06_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String typeOfAnimalInput;
        try {
            while (!"Beast!".equals(typeOfAnimalInput = reader.readLine())) {
                String[] animalProperties = reader.readLine().split("\\s+");
                String animalName = animalProperties[0];
                int animalAge = Integer.parseInt(animalProperties[1]);
                String animalGender = animalProperties[2];
                switch (typeOfAnimalInput) {
                    case "Cat":
                        Cat cat = new Cat(animalName, animalAge, animalGender);
                        System.out.println(cat);
                        cat.produceSound();
                        break;
                    case "Dog":
                        Dog dog = new Dog(animalName, animalAge, animalGender);
                        System.out.println(dog);
                        dog.produceSound();
                        break;
                    case "Frog":
                        Frog frog = new Frog(animalName, animalAge, animalGender);
                        System.out.println(frog);
                        frog.produceSound();
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(animalName, animalAge, animalGender);
                        System.out.println(kitten);
                        kitten.produceSound();
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(animalName, animalAge, animalGender);
                        System.out.println(tomcat);
                        tomcat.produceSound();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }

            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }
}
