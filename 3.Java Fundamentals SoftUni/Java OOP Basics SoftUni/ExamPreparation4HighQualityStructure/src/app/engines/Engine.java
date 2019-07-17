package app.engines;

import app.entities.Colony;
import app.entities.colonists.Colonist;
import app.entities.colonists.engineers.HardwareEngineer;
import app.entities.colonists.engineers.SoftwareEngineer;
import app.entities.colonists.medics.GeneralPractitioner;
import app.entities.colonists.medics.Surgeon;
import app.entities.colonists.soldiers.Soldier;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private Colony colony;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, Colony colony) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.colony = colony;
    }

    public void run() {
        String inputLine;

        while(true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            //INPUT_TERMINATING_COMMAND - this is your terminated command
            if (inputLine.equals("end")) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.get(0);

        String sign = null;
        Colonist colonist = null;
        String familyId = null;

        switch(command) {
            case "insert":
                //{class} {colonistId} {familyId} {talent} {age} {sign?}
                String colonistClass = commandParams.get(1);
                String colonistId = commandParams.get(2);
                familyId = commandParams.get(3);
                int talent = Integer.parseInt(commandParams.get(4));
                int age= Integer.parseInt(commandParams.get(5));
                switch (colonistClass) {
                    case "SoftwareEngineer":
                       colonist = new SoftwareEngineer(colonistId, familyId, talent, age);
                        break;
                    case "HardwareEngineer":
                        colonist = new HardwareEngineer(colonistId, familyId, talent, age);
                        break;
                    case "Soldier":
                        colonist = new Soldier(colonistId, familyId, talent, age);
                        break;
                    case "GeneralPractitioner":
                        sign = commandParams.get(6);
                        colonist = new GeneralPractitioner(colonistId, familyId, talent, age, sign);
                        break;
                    case "Surgeon":
                        sign = commandParams.get(6);
                        colonist = new Surgeon(colonistId, familyId, talent, age, sign);
                        break;
                }
                colony.addColonist(colonist);
                break;
            case "remove":
                String modificator = commandParams.get(1);
                switch (modificator) {
                    case "family":
                        familyId = commandParams.get(2);
                        colony.removeFamily(familyId);
                        break;
                    case "colonist":
                        familyId = commandParams.get(2);
                        String memberId = commandParams.get(3);
                        colony.removeColonist(familyId, memberId);
                        break;
                }
                break;
            case "grow":
                int growYears = Integer.parseInt(commandParams.get(1));
                colony.grow(growYears);
                break;
            case "potential":
                System.out.println("potential: " +colony.getPotential());
                break;
            case "capacity":
                outputWriter.writeLine(colony.getCapacity());
                break;
            case "family":
                familyId = commandParams.get(1);
                System.out.print((colony.getFamily(familyId)));
        }
    }
}
