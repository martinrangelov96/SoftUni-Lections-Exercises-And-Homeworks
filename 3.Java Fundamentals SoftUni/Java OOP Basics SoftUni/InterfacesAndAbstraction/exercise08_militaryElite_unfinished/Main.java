package exercise08_militaryElite_unfinished;

import exercise08_militaryElite_unfinished.contracts.Private;
import exercise08_militaryElite_unfinished.contracts.Soldier;
import exercise08_militaryElite_unfinished.impl.LeutenantGeneralImpl;
import exercise08_militaryElite_unfinished.impl.PrivateImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Soldier> soldiers = new LinkedHashMap<>();
        Map<String, Private> privates = new HashMap<>();

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String soldierType = tokens[0];
            String id = tokens[1];
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;

            Soldier soldier = null;
            switch (soldierType) {
                case "Private":
                    salary = Double.parseDouble(tokens[4]);
                    Private privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    privates.put(id, privateSoldier);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    List<String> privateIds = Arrays.stream(tokens).skip(5).collect(Collectors.toList());
                    Set<Private> privatesSet = getPrivates(privateIds, privates);
                    soldier = new LeutenantGeneralImpl(id,firstName,lastName,salary,privatesSet);
                    break;
                case "Engineer":
                    break;
                case "Commando":
                    break;
                case "Spy":
                    break;
                default:
                    break;
            }

            if (soldier != null) {
                soldiers.put(id, soldier);
            }

        }
        soldiers.values().forEach(s -> System.out.println(s.toString()));
    }

    private static Set<Private> getPrivates(List<String> privateIds, Map<String, Private> privates) {

        return privates
                .values()
                .stream()
                .filter(p -> privateIds.contains(p.getId()))
                .collect(Collectors.toSet());
    }
}
