package lection11_threeuple;

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
        String city = firstLine[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(firstName + " " + lastName, address, city);
        System.out.println(firstThreeuple.toString());

        String[] secondLine = reader.readLine().split("\\s+");
        String secondLineName = secondLine[0];
        int secondLineLitersOfBeer = Integer.parseInt(secondLine[1]);
        String drunkOrNot = secondLine[2];
        boolean isDrunk = false;
        if ("drunk".equals(drunkOrNot)) {
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(secondLineName, secondLineLitersOfBeer, isDrunk);
        System.out.println(secondThreeuple.toString());

        String[] thirdLine = reader.readLine().split("\\s+");
        String thirdLineName = thirdLine[0];
        double thirdLineAccountBalance = Double.parseDouble(thirdLine[1]);
        String thirdLineBankName = thirdLine[2];
        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(thirdLineName, thirdLineAccountBalance, thirdLineBankName);
        System.out.println(thirdThreeuple.toString());

    }
}
