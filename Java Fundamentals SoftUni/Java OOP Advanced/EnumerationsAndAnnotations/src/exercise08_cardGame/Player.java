package exercise08_cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public boolean isHandFull() {
        return this.hand.size() == 5;
    }

    public Card getPowerfulCard() {
        return this.hand
                .stream()
                .max(Card::compareTo)
                .get();
    }

    public int getHandSize() {
        return this.hand.size();
    }

    public String getName() {
        return this.name;
    }
}
