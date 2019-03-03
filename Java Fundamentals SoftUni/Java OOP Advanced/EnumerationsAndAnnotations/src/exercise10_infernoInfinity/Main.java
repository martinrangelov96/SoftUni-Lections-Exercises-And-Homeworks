package exercise10_infernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new HashMap<>();
        int socketIndex;

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] cmdArgs = input.split(";");
            Weapon weapon = null;

            String command = cmdArgs[0];
            String weaponName;

            switch (command) {
                case "Create":
                    String weaponType = cmdArgs[1];
                    weaponName = cmdArgs[2];
                    weapon = new Weapon(weaponType, weaponName);
                    weapons.putIfAbsent(weaponName, weapon);
                    break;
                case "Add":
                    weaponName = cmdArgs[1];
                    weapon = weapons.get(weaponName);
                    socketIndex = Integer.parseInt(cmdArgs[2]);
                    String gemType = cmdArgs[3];
                    if (weapon != null) {
                        weapon.addSocket(socketIndex, gemType);
                    }
                    break;
                case "Remove":
                    weaponName = cmdArgs[1];
                    weapon = weapons.get(weaponName);
                    socketIndex = Integer.parseInt(cmdArgs[2]);
                    if (weapon != null) {
                        weapon.removeSocket(socketIndex);
                    }
                    break;
                case "Print":
                    weaponName = cmdArgs[1];
                    weapon = weapons.get(weaponName);
                    if (weapon != null) {
                        System.out.println(weapon);
                    }
                    break;
            }
        }

    }
}
