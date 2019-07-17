package app;

import app.engines.Engine;
import app.entities.Colony;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        String[] colonyParameters = inputReader.readLine().split("\\s+");
        int maxFamilyCount = Integer.parseInt(colonyParameters[0]);
        int maxFamilyCapacity = Integer.parseInt(colonyParameters[1]);
        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);
        Engine engine = new Engine(inputReader, outputWriter, inputParser, colony);

        engine.run();
    }
}
