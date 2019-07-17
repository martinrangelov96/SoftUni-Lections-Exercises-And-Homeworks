package BoatRacingSimulator;

import BoatRacingSimulator.contracts.*;
import BoatRacingSimulator.contracts.Runnable;
import BoatRacingSimulator.controllers.BoatSimulatorControllerImpl;
import BoatRacingSimulator.core.CommandHandlerImpl;
import BoatRacingSimulator.core.Engine;
import BoatRacingSimulator.database.BoatEngineRepository;
import BoatRacingSimulator.database.BoatRepository;
import BoatRacingSimulator.database.BoatSimulatorDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Repository<BoatEngine> boatEngineRepository = new BoatEngineRepository();
        Repository<Boat> boatRepository = new BoatRepository();
        BoatSimulatorDatabase database = new BoatSimulatorDatabase(boatRepository, boatEngineRepository);

        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);

        CommandHandler commandHandler = new CommandHandlerImpl(controller);

        Runnable engine = new Engine(reader, commandHandler);

        engine.run();

    }
}
