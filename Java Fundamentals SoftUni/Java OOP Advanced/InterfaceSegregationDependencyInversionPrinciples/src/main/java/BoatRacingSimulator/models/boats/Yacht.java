package BoatRacingSimulator.models.boats;

import BoatRacingSimulator.contracts.BoatEngine;
import BoatRacingSimulator.contracts.Race;
import BoatRacingSimulator.utility.Validator;

public class Yacht extends BaseBoat {

    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, int cargoWeight, BoatEngine boatEngine) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.boatEngine = boatEngine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.boatEngine.getCachedOutput() - super.getWeight() - this.cargoWeight + (race.getOceanCurrentSpeed() / 2d);
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }
}
