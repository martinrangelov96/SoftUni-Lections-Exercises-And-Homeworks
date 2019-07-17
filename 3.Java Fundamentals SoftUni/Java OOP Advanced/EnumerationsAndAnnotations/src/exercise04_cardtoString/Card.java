package exercise04_cardtoString;

import exercise04_cardtoString.enums.RankType;
import exercise04_cardtoString.enums.SuitType;

public class Card {

    private RankType rankType;
    private SuitType suitType;

    public Card(String rank, String suit) {
        this.rankType = RankType.valueOf(rank.toUpperCase());
        this.suitType = SuitType.valueOf(suit.toUpperCase());
    }

    public int getPower() {
        return this.rankType.getValue() + this.suitType.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rankType, this.suitType);
    }
}
