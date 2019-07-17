package exercise07_deckOfCards;


import exercise07_deckOfCards.enums.RankType;
import exercise07_deckOfCards.enums.SuitType;

public class Card{

    private RankType rankType;
    private SuitType suitType;

    public Card(RankType rankType, SuitType suitType) {
        this.rankType = rankType;
        this.suitType = suitType;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rankType, this.suitType);
    }
}
