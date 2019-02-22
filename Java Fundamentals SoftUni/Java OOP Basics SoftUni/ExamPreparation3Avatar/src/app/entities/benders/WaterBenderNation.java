package app.entities.benders;

import app.entities.monuments.FireMonument;
import app.entities.monuments.WaterMonument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaterBenderNation  {

    private List<WaterBender> waterBenderNation;
    private List<WaterMonument> waterMonuments;

    public WaterBenderNation() {
        this.waterBenderNation = new ArrayList<>();
        this.waterMonuments = new ArrayList<>();
    }

    public List<WaterBender> getWaterBenderNation() {
        return Collections.unmodifiableList(this.waterBenderNation);
    }

    public double calculateTotalPower() {
        double totalPowerSum = 0.0;
        int waterMonumentSum = 0;
        for (WaterBender waterBender : waterBenderNation) {
            totalPowerSum += waterBender.calculateTotalPower();
        }
        for (WaterMonument waterMonument : waterMonuments) {
            waterMonumentSum += waterMonument.getAffinity();
        }
        totalPowerSum += (totalPowerSum / 100) * waterMonumentSum;
        return totalPowerSum;
    }

    public String getNationName() {
        return super.toString();
    }
}
