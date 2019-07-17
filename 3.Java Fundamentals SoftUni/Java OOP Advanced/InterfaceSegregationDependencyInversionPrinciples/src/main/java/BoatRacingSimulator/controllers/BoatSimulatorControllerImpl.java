package BoatRacingSimulator.controllers;

import BoatRacingSimulator.contracts.Boat;
import BoatRacingSimulator.contracts.BoatEngine;
import BoatRacingSimulator.contracts.BoatSimulatorController;
import BoatRacingSimulator.contracts.Race;
import BoatRacingSimulator.database.BoatSimulatorDatabase;
import BoatRacingSimulator.exeptions.*;
import BoatRacingSimulator.models.RaceImpl;
import BoatRacingSimulator.models.boats.PowerBoat;
import BoatRacingSimulator.models.boats.RowBoat;
import BoatRacingSimulator.models.boats.SailBoat;
import BoatRacingSimulator.models.boats.Yacht;
import BoatRacingSimulator.models.engines.JetEngine;
import BoatRacingSimulator.models.engines.SterndriveEngine;
import BoatRacingSimulator.utility.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private Map<Boat, Double> finishedBoats;
    private Map<Boat, Double> unfinishedBoats;

    private BoatSimulatorDatabase database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(BoatSimulatorDatabase database) {
        this.database = database;
        this.finishedBoats = new LinkedHashMap<>();
        this.unfinishedBoats = new LinkedHashMap<>();
    }

    private String isFinished(Double time) {
        if (time <= 0 || time == Double.POSITIVE_INFINITY || time == Double.NEGATIVE_INFINITY) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", time);
    }

    private void findFastest(List<Boat> participants) {

        for (Boat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;

            if (time <= 0) {
                this.unfinishedBoats.put(participant, time);
            } else {
                this.finishedBoats.put(participant, time);
            }
        }

        if (this.finishedBoats.size() >= 3) {
            this.unfinishedBoats.clear();
        }

    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException {
        BoatEngine engine;
        switch (engineType) {
            case "JET":
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case "STERNDRIVE":
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                return null;
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistentModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().getItem(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().getItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistentModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().getItem(engineModel);
        Boat boat = new Yacht(model, weight, cargoWeight, engine);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsBoats) throws RaceAlreadyExistsException {
        this.validateRaceIsEmpty();

        this.currentRace = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsBoats);

        return
                String.format(
                        "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistentModelException, DuplicateModelException, NoSetRaceException {
        this.validateRaceIsSet();

        Boat boat = this.database.getBoats().getItem(model);

        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        this.findFastest(participants);

        String[] places = {"First", "Second", "Third"};
        final int[] index = {0};

        StringBuilder result = new StringBuilder();

        this.finishedBoats.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(boat -> {

                    if (index[0] < 3) {
                        result.append(String.format("%s place: %s Model: %s Time: %s",
                                places[index[0]++],
                                boat.getKey().getClass().getSimpleName(),
                                boat.getKey().getModel(),
                                isFinished(boat.getValue())))
                                .append(System.lineSeparator());
                    }

                });

        for (Map.Entry<Boat, Double> doubleBoatEntry : this.unfinishedBoats.entrySet()) {

            if (index[0] == 3) {
                break;
            }

            result.append(String.format("%s place: %s Model: %s Time: %s",
                    places[index[0]++],
                    doubleBoatEntry.getKey().getClass().getSimpleName(),
                    doubleBoatEntry.getKey().getModel(),
                    isFinished(doubleBoatEntry.getValue())))
                    .append(System.lineSeparator());
        }

        this.currentRace = null;
        this.finishedBoats.clear();
        this.unfinishedBoats.clear();

        return result.toString().trim();
    }

    @Override
    public String getStatistic() {
        List<Boat> participants = this.currentRace.getParticipants();
        int countOfParticipants = participants.size();

        StringBuilder statistic = new StringBuilder();

        participants.stream()
                .collect(Collectors.groupingBy((Boat boat) -> boat.getClass().getSimpleName()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(boatsGroup -> {
                    String boatType = boatsGroup.getKey();
                    double percentage = ((double) boatsGroup.getValue().size() / countOfParticipants * 100);
                    statistic.append(String.format("%s -> %.2f%%",
                            boatType,
                            percentage))
                            .append(System.lineSeparator());
                });

        return statistic.toString().trim();
    }

}
