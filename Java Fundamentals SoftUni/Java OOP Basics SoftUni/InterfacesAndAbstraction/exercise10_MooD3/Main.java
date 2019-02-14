package exercise10_MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" \\| ");
        //<username> | <character type> | <special points> | <level>

        String username = data[0];
        String characterType = data[1];
        double specialPoints = Double.valueOf(data[2]);
        Integer level = Integer.valueOf(data[3]);

        Character character;

        switch (characterType) {
            case "Demon":
                try {
                    character = new Demon(username, level, specialPoints);
                    System.out.println(character);
                } catch (IllegalArgumentException ignored) {
                    ;
                }
                break;
            case "Archangel":
                try {
                    character = new Archangel(username, level, specialPoints);
                    System.out.println(character);
                } catch (IllegalArgumentException ignore) {
                    ;
                }
                break;
            default:
                break;
        }

    }
}
