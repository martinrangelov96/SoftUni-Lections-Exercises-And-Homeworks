package BoatRacingSimulator.models.boats;

import BoatRacingSimulator.contracts.Race;
import BoatRacingSimulator.utility.Validator;

public class RowBoat extends BaseBoat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    public int getOars() {
        return this.oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.oars * 100) - super.getWeight() + race.getOceanCurrentSpeed();
    }


    @Override
    public boolean isMotorBoat() {
        return false;
    }
}
