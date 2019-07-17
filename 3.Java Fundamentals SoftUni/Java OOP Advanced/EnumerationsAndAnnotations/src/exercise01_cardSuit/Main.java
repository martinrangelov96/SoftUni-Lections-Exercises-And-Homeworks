package exercise01_cardSuit;

import exercise01_cardSuit.enums.CardSuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        CardSuits[] cardSuits = CardSuits.values();

        if ("Card Suits".equals(input)) {
            System.out.println("Card Suits:");
            for (CardSuits cardSuit : cardSuits) {
                System.out.println(String.format("Ordinal value: %d; Name value: %s", cardSuit.ordinal(), cardSuit.name()));
            }
        }
    }
}
