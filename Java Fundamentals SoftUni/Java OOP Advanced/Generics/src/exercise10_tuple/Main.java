package exercise10_tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        String firstName = firstLine[0];
        String lastName = firstLine[1];
        String address = firstLine[2];
        Tuple<String, String> firstTuple = new Tuple<>(firstName + " " + lastName, address);
        System.out.println(firstTuple.toString());

        String[] secondLine = reader.readLine().split("\\s+");
        String secondLineName = secondLine[0];
        int secondLineLitersOfBeer = Integer.parseInt(secondLine[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(secondLineName, secondLineLitersOfBeer);
        System.out.println(secondTuple.toString());

        String[] thirdLine = reader.readLine().split("\\s+");
        int thirdLineInt = Integer.parseInt(thirdLine[0]);
        double thirdLineDouble = Double.parseDouble(thirdLine[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(thirdLineInt, thirdLineDouble);
        System.out.println(thirdTuple.toString());

    }
}
