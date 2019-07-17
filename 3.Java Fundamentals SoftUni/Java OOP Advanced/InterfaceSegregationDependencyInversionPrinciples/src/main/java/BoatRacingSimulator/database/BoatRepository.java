package BoatRacingSimulator.database;

import BoatRacingSimulator.contracts.Boat;
import BoatRacingSimulator.contracts.Repository;
import BoatRacingSimulator.exeptions.DuplicateModelException;
import BoatRacingSimulator.exeptions.NonExistentModelException;
import BoatRacingSimulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements Repository<Boat> {
    
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }

    @Override
    public void add(Boat item) throws DuplicateModelException {
        if (this.boats.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.boats.put(item.getModel(), item);

    }

    @Override
    public Boat getItem(String model) throws NonExistentModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.boats.get(model);
    }
}
