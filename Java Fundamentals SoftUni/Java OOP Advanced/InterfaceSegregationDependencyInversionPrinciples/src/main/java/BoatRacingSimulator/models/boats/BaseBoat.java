package BoatRacingSimulator.models.boats;

import BoatRacingSimulator.contracts.Boat;
import BoatRacingSimulator.contracts.Modelable;
import BoatRacingSimulator.utility.Constants;
import BoatRacingSimulator.utility.Validator;

public abstract class BaseBoat implements Boat {

    private String model;

    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public int getWeight() {
        return this.weight;
    }

}
