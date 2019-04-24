package task03_ferrari;

public class Ferrari implements Carable {

    private String model;
    private String driverName;

    public Ferrari(String driverName) {
        this.model = "488-Spider";
        this.driverName = driverName;
    }

    private String getModel() {
        return this.model;
    }

    private String getDriverName() {
        return this.driverName;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(),this.useBrakes(), this.pushTheGasPedal(), this.getDriverName());
    }
}
