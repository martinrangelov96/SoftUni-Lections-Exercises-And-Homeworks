package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.io.InputReaderImpl;
import panzer.io.OutputWriterImpl;
import panzer.manager.ManagerImpl;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();
        PanzerBattleOperator panzerBattleOperator = new PanzerBattleOperator();
        Manager manager = new ManagerImpl(panzerBattleOperator);

        while (true) {
            String[] tokens = inputReader.readLine().split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Vehicle":
                    outputWriter.println(manager.addVehicle(Arrays.asList(tokens)));
                    break;
                case "Part":
                    outputWriter.println(manager.addPart(Arrays.asList(tokens)));
                    break;
                case "Inspect":
                    outputWriter.println(manager.inspect(Arrays.asList(tokens)));
                    break;
                case "Battle":
                    outputWriter.println(manager.battle(Arrays.asList(tokens)));
                    break;
                case "Terminate":
                    outputWriter.println(manager.terminate(null));
                    return;

            }

        }

    }
}
