package homework02_pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void incrementBadges() {
        this.numberOfBadges++;
    }
}
