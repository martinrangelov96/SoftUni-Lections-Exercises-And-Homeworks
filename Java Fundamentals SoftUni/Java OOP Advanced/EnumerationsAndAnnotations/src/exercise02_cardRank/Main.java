package exercise02_cardRank;

import exercise02_cardRank.enums.CardSuits;
import exercise02_cardRank.enums.CardTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        CardTypes[] cardTypes = CardTypes.values();

        if ("Card Ranks".equals(input)) {
            System.out.println("Card Ranks:");
            for (CardTypes cardType : cardTypes) {
                System.out.println(String.format("Ordinal value: %d; Name value: %s", cardType.ordinal(), cardType.name()));
            }
        }
    }
}
