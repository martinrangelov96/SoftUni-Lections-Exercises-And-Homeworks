package app;

import app.engines.Engine;
import app.core.Manager;
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
        Manager manager = new Manager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, manager);

        engine.run();
    }
}
