package exercise05_borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> identifiables = new ArrayList<>();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            Identifiable identifiable;
            if (data.length == 2) {
                identifiable = new Robot(data[0], data[1]);
                identifiables.add(identifiable);
            } else if(data.length == 3) {
                identifiable = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                identifiables.add(identifiable);
            }
        }

        String deportFakeIds = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            identifiable.getId(deportFakeIds);
        }
    }
}
