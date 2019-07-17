package app.entities.benders;

import app.entities.monuments.AirMonument;
import app.entities.monuments.EarthMonument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EarthBenderNation {

    private List<EarthBender> earthBenderNation;
    private List<EarthMonument> earthMonuments;

    public EarthBenderNation() {
        this.earthBenderNation = new ArrayList<>();
        this.earthMonuments = new ArrayList<>();
    }

    public List<EarthBender> getEarthBanderNation() {
        return Collections.unmodifiableList(this.earthBenderNation);
    }


    public double calculateTotalPower() {
        double totalPowerSum = 0.0;
        int earthMonumentSum = 0;
        for (EarthBender earthBender : earthBenderNation) {
            totalPowerSum += earthBender.calculateTotalPower();
        }
        for (EarthMonument earthMonuments : earthMonuments) {
            earthMonumentSum += earthMonuments.getAffinity();
        }
        totalPowerSum += (totalPowerSum / 100) * earthMonumentSum;
        return totalPowerSum;
    }

    public String getNationName() {
        return super.toString();
    }
}
