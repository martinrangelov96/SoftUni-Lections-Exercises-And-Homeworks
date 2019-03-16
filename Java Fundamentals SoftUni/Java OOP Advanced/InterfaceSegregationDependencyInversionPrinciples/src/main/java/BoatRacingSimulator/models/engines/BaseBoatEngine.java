package BoatRacingSimulator.models.engines;

import BoatRacingSimulator.contracts.BoatEngine;
import BoatRacingSimulator.utility.Constants;
import BoatRacingSimulator.utility.Validator;

public abstract class BaseBoatEngine implements BoatEngine {

    private String model;

    public int cachedOutput;

    private int horsepower;

    private int displacement;

    protected BaseBoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    protected int getHorsepower() {
        return this.horsepower;
    }

    protected int getDisplacement() {
        return this.displacement;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getCachedOutput() {
        return this.cachedOutput;
    }
}
