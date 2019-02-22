package app.engines;

import app.core.Manager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.Constants;
import app.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private Manager manager;


    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, Manager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.manager = manager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            //INPUT_TERMINATING_COMMAND - this is your terminated command
            if (inputLine.equals(Constants.INPUT_TERMINATING_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        //Bender Fire Tony 1000 2500.5667

        String type = null;
        String name = null;
        String nation = null;

        switch (command) {
            case "Bender":
//                String unit = commandParams.get(1);
                type = commandParams.get(0);
                name = commandParams.get(1);
                int power = Integer.parseInt(commandParams.get(2));
                double secondaryParameter = Double.parseDouble(commandParams.get(3));
                this.manager.createBender(type, name, power, secondaryParameter);
                break;
            case "Monument":
                type = commandParams.get(0);
                name = commandParams.get(1);
                int affinity = Integer.parseInt(commandParams.get(2));
                this.manager.createMonument(type, name, affinity);
                break;
            case "Status":
                nation = commandParams.get(0);
                this.outputWriter.writeLine(this.manager.getStatus(nation));
                break;
            case "War":
                nation = commandParams.get(0);
                this.manager.war(nation);
                break;
            case "Quit":
                this.outputWriter.writeLine(this.manager.quit());
        }
    }
}
