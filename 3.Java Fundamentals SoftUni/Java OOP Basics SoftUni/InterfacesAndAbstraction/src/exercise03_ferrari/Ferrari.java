package exercise03_ferrari;

public class Ferrari implements Car {

    private String driver;

    public Ferrari(String driver) {
        this.setDriver(driver);
    }

    @Override
    public String useBreaks() {
        return "Brakes!";
    }

    @Override
    public String pushTheGas() {
        return "Zadu6avam sA!";
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    protected String getDriver() {
        return this.driver;
    }

    @Override
    public String toString() {
        String model = "488-Spider";
        return String.format("%s/%s/%s/%s", model, this.useBreaks(),this.pushTheGas(),this.getDriver());
    }
}
