package homework02_pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String trainersInput;
        while (!"Tournament".equals(trainersInput = reader.readLine())) {
            String[] tokens = trainersInput.split("\\s+");

            String trainerName = tokens[0];

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }

            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).getPokemons().add(pokemon);
        }

        String elementInput;
        while (!"End".equals(elementInput = reader.readLine())) {

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                List<Pokemon> pokemons = trainer.getValue().getPokemons();
                boolean foundElement = false;
                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getElement().equals(elementInput)) {
                        foundElement = true;
                        break;
                    }
                }

                if (foundElement) {
                    trainer.getValue().incrementBadges();
                } else {
                    for (Pokemon pokemon : pokemons) {
                        pokemon.getHitBy10Dmg();
                        if (pokemon.getHealth() <= 0) {
                            pokemons.remove(pokemon);
                            if (pokemons.isEmpty()) {
                                break;
                            }
                        }
                    }
                }

            }

        }

        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumberOfBadges(), b1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getKey(), t.getValue().getNumberOfBadges(), t.getValue().getPokemons().size()));
    }
}
