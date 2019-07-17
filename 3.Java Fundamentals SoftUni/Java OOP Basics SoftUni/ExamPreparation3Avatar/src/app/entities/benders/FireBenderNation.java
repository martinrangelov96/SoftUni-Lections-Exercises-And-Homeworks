package app.entities.benders;

import app.entities.monuments.EarthMonument;
import app.entities.monuments.FireMonument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FireBenderNation {

    private List<FireBender> fireBenderNation;
    private List<FireMonument> fireMonuments;

    public FireBenderNation() {
        this.fireBenderNation = new ArrayList<>();
        this.fireMonuments = new ArrayList<>();
    }

    public List<FireBender> getFireBenderNation() {
        return Collections.unmodifiableList(this.fireBenderNation);
    }

    public double calculateTotalPower() {
        double totalPowerSum = 0.0;
        int fireMonumentSum = 0;
        for (FireBender fireBender : fireBenderNation) {
            totalPowerSum += fireBender.calculateTotalPower();
        }
        for (FireMonument fireMonument : fireMonuments) {
            fireMonumentSum += fireMonument.getAffinity();
        }
        totalPowerSum += (totalPowerSum / 100) * fireMonumentSum;
        return totalPowerSum;
    }

    public String getNationName() {
        return super.toString();
    }
}
