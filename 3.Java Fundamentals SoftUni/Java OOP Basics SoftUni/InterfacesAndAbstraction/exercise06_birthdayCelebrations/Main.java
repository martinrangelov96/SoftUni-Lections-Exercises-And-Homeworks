package exercise06_birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthables = new ArrayList<>();
        List<Identifiable> identifiables = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            String typeOfIdentifiable = data[0];

            Birthable birthable;
            Identifiable identifiable;

            switch (typeOfIdentifiable) {
                case "Citizen":
                    birthable = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    birthables.add(birthable);
                    break;
                case "Robot":
                    identifiable = new Robot(data[1], data[2]);
                    identifiables.add(identifiable);
                    break;
                case "Pet":
                    birthable = new Pet(data[1], data[2]);
                    birthables.add(birthable);
                    break;
                default:
                    break;

            }
        }

        String birthDate = reader.readLine();

        for (Birthable birthable : birthables) {
            birthable.getBirthdayDate(birthDate);
        }
    }
}
