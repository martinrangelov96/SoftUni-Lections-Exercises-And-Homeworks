package task04_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split("\\s+");
        String[] sites = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();

        for (String phoneNumber : phoneNumbers) {
            smartphone.call(phoneNumber);
        }

        for (String site : sites) {
            smartphone.browse(site);
        }


    }
}
