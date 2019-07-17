package BoatRacingSimulator.models.engines;

public class JetEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getCachedOutput() {
        //TODO: may be time performance issue
//        if (this.cachedOutput != 0) {
//            return this.cachedOutput;
//        }

        return  (this.getHorsepower() * MULTIPLIER) + this.getDisplacement();
    }

}
