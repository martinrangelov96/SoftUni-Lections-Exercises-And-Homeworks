package app.core;

import app.entities.benders.*;
import app.entities.monuments.Monument;
import app.factories.BenderFactory;
import app.factories.MonumentFactory;
import app.utilities.Constants;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private Map<String, List<Bender>> benders;
    private Map<String, List<Monument>> monuments;
    private List<String> issuedWars;

    public Manager() {
        this.setBenders();
        this.setMonuments();
        this.issuedWars = new ArrayList<>();
    }

    public void createBender(String type, String name, int power, double secondaryParameter) {
        if (!benders.containsKey(type)) {
            benders.put(type, new ArrayList<>());
        }
        benders.get(type).add(BenderFactory.createBender(type, name, power, secondaryParameter));

    }

    public void createMonument(String type, String name, int affinity) {
        if (!monuments.containsKey(type)) {
            monuments.put(type, new ArrayList<>());
        }
        monuments.get(type).add(MonumentFactory.createMonument(type, name, affinity));
    }

    public void war(String nation) {
        this.issuedWars.add(nation);
        double winnerPower = Double.MIN_VALUE;
        String winnerNation = "";
        for (Map.Entry<String, List<Bender>> benderEntry : this.benders.entrySet()) {
            double currentPower = benderEntry.getValue().stream().mapToDouble(Bender::getPower).sum() + (((benderEntry.getValue().stream().mapToDouble(Bender::getPower).sum()) / Constants.DIVIDER) * this.monuments.get(benderEntry.getKey()).stream().mapToLong(Monument::getAffinity).sum());

            if (currentPower > winnerPower) {
                winnerPower = currentPower;
                winnerNation = benderEntry.getKey();
            }
        }
        String finalWinnerNation = winnerNation;
        this.benders.entrySet().stream().filter(x -> !x.getKey().equals(finalWinnerNation)).forEach(x -> x.getValue().clear());
        this.monuments.entrySet().stream().filter(x -> !x.getKey().equals(finalWinnerNation)).forEach(x -> x.getValue().clear());

    }

    public String quit() {
        long counter = 1;
        StringBuilder sb = new StringBuilder();
        for (String issuedWar : issuedWars) {
            sb.append(String.format(Constants.STRING_FORMAT_ISSUED_WAR, counter, issuedWar)).append(System.lineSeparator());
            counter++;
        }
        return sb.toString().trim();
    }

    public String getStatus(String nation) {

        StringBuilder sb = new StringBuilder();
        sb.append(nation).append(" Nation").append(System.lineSeparator()).append("Benders:");
        if (this.benders.get(nation).isEmpty()) {
            sb.append(" None").append(System.lineSeparator());
        } else {
            sb.append(System.lineSeparator());
            for (Bender bender : this.benders.get(nation)) {
                sb.append(bender).append(System.lineSeparator());
            }
        }
        sb.append("Monuments:");
        if (this.monuments.get(nation).isEmpty()) {
            sb.append(" None");
        } else {
            sb.append(System.lineSeparator());
            for (Monument monument : this.monuments.get(nation)) {
                sb.append(monument).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    private void setMonuments() {
        this.monuments = new LinkedHashMap<>();
        this.monuments.put(Constants.AIR, new ArrayList<>());
        this.monuments.put(Constants.WATER, new ArrayList<>());
        this.monuments.put(Constants.FIRE, new ArrayList<>());
        this.monuments.put(Constants.EARTH, new ArrayList<>());
    }

    private void setBenders() {
        this.benders = new LinkedHashMap<>();
        this.benders.put(Constants.AIR, new ArrayList<>());
        this.benders.put(Constants.WATER, new ArrayList<>());
        this.benders.put(Constants.FIRE, new ArrayList<>());
        this.benders.put(Constants.EARTH, new ArrayList<>());
    }
}
