package BoatRacingSimulator.database;

import BoatRacingSimulator.contracts.BoatEngine;
import BoatRacingSimulator.contracts.Repository;
import BoatRacingSimulator.exeptions.DuplicateModelException;
import BoatRacingSimulator.exeptions.NonExistentModelException;
import BoatRacingSimulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository implements Repository<BoatEngine> {

    private Map<String, BoatEngine> boatEngines;

    public BoatEngineRepository() {
        this.boatEngines = new LinkedHashMap<>();
    }

    @Override
    public void add(BoatEngine item) throws DuplicateModelException {
        if (this.boatEngines.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.boatEngines.put(item.getModel(), item);

    }

    @Override
    public BoatEngine getItem(String model) throws NonExistentModelException {
        if (!this.boatEngines.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.boatEngines.get(model);
    }

}
