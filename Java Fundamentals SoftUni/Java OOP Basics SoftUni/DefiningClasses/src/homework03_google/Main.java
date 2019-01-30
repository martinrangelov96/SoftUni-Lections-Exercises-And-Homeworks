package homework03_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];

            if (!people.containsKey(name)) {
                people.put(name, new Person(name));
            } else {

            }

//            Person person = new Person(name);

            switch (tokens[1]) {
                case "company":

                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
//                    person = new Person(name, company);
//                    people.put(name, person);

                    break;
                case "pokemon":

                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    break;
                case "parents":

                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parents parents = new Parents(parentName, parentBirthday);

                    break;
                case "children":

                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children children = new Children(childName, childBirthday);

                    break;
                case "car":

                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);

//                    people.put(name, person);

                    break;
                default:
                    break;
            }


        }

    }
}
