package BoatRacingSimulator.models.engines;

public class SterndriveEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getCachedOutput() {
        //TODO: may be time performance issue
//        if (this.cachedOutput != 0) {
//            return this.cachedOutput;
//        }

        return (this.getHorsepower() * MULTIPLIER) + this.getDisplacement();
    }
}
