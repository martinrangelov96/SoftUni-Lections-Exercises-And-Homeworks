package task05_border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Identifiable> identifiables = new ArrayList<>();

        while (true) {

            String[] data = reader.readLine().split("\\s+");

            if (data[0].equals("End")) {
                break;
            }

            switch (data.length) {

                case 2:
                    Robot robot = new Robot(data[0], data[1]);
                    identifiables.add(robot);
                    break;
                case 3:
                    Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                    identifiables.add(citizen);
                    break;
            }

        }

        String fakeId = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeId)) {
                System.out.println(identifiable.getId());
            }
        }

    }
}
