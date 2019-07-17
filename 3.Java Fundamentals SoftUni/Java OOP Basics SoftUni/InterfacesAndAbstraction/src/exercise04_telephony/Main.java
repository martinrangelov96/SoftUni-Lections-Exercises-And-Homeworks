package exercise04_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split("\\s+");
        String[] websites = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();

        Arrays.stream(phoneNumbers).forEach(phoneNumber -> {
            try {
                System.out.println(smartphone.callANumber(phoneNumber));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        });

        Arrays.stream(websites).forEach(webSite -> {
            try {
                System.out.println(smartphone.browseAWebSite(webSite));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        });

    }
}
