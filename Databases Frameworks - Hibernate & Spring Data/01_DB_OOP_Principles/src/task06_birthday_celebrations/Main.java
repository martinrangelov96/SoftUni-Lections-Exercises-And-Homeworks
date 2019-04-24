package task06_birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> identifiables = new ArrayList<>();
        List<Birthdayable> birthdayables = new ArrayList<>();

        while (true) {

            String[] data = reader.readLine().split("\\s+");
            String firstArgument = data[0];

            if (firstArgument.equals("End")) {
                break;
            }

            switch (firstArgument) {

                case "Robot":
                    Robot robot = new Robot(data[1], data[2]);
                    identifiables.add(robot);
                    break;
                case "Citizen":
                    Citizen citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    identifiables.add(citizen);
                    birthdayables.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(data[1], data[2]);
                    birthdayables.add(pet);
                    break;
            }

        }

        String specificYear = reader.readLine();

        for (Birthdayable birthdayable : birthdayables) {
            if (birthdayable.getBirthdate().endsWith(specificYear)) {
                System.out.println(birthdayable.getBirthdate());
            }
        }
    }
}
