package app.entities.benders;

import app.entities.monuments.AirMonument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirBenderNation  {

    private List<AirBender> airBenderNation;
    private List<AirMonument> airMonuments;

    public AirBenderNation() {
        this.airBenderNation = new ArrayList<>();
        this.airMonuments = new ArrayList<>();

    }

    public List<AirBender> getAirBenderNation() {
        return Collections.unmodifiableList(this.airBenderNation);
    }

    public double calculateTotalPower() {
        double totalPowerSum = 0.0;
        int airMonumentSum = 0;
        for (AirBender airBender : airBenderNation) {
            totalPowerSum += airBender.calculateTotalPower();
        }
        for (AirMonument airMonument : airMonuments) {
            airMonumentSum += airMonument.getAffinity();
        }
        totalPowerSum += (totalPowerSum / 100) * airMonumentSum;
        return totalPowerSum;
    }

    public String getNationName() {
        return super.toString();
    }
}
