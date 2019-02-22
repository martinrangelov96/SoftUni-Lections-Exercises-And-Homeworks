package app.engine;

import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.utils.Constants;

import java.io.IOException;

public class Engine {
    //consoleReader, consoleWriter, HealthManager

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private HealthManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new HealthManager();
    }

    public void run() throws IOException {


        String command = this.reader.readLine();
        while (!Constants.TERMINAL_COMMAND.equals(command)) {
            String[] cmdArgs = command.split("\\s+");

            String commandResult = null;
            String organismName = null;
            String clusterId = null;
            int rows = -1;
            int cols = -1;

            switch (cmdArgs[0]) {
                case "checkCondition":
                    commandResult = this.manager.checkCondition(cmdArgs[1]);
                    if (!Constants.EMPTY_STRING.equals(commandResult)) {
                        this.writer.writeLine(commandResult);
                    }
                    break;
                case "createOrganism":
                    this.writer.writeLine(this.manager.createOrganism(cmdArgs[1]));
                    break;
                case "addCluster":
                    organismName = cmdArgs[1];
                    clusterId = cmdArgs[2];
                    rows = Integer.parseInt(cmdArgs[3]);
                    cols = Integer.parseInt(cmdArgs[4]);
                    commandResult = this.manager.addCluster(organismName, clusterId, rows, cols);

                    if (!Constants.EMPTY_STRING.equals(commandResult)) {
                        this.writer.writeLine(commandResult);
                    }
                    break;
                case "addCell":
                    organismName = cmdArgs[1];
                    clusterId = cmdArgs[2];
                    String cellType = cmdArgs[3];
                    String cellId = cmdArgs[4];
                    int health = Integer.parseInt(cmdArgs[5]);
                    rows = Integer.parseInt(cmdArgs[6]);
                    cols = Integer.parseInt(cmdArgs[7]);
                    int addProperty = Integer.parseInt(cmdArgs[8]);

                    commandResult = this.manager.addCell(organismName, clusterId, cellType, cellId,
                            health, rows, cols, addProperty);
                    if (!Constants.EMPTY_STRING.equals(commandResult)) {
                        this.writer.writeLine(commandResult);
                    }
                    break;
                case "activateCluster":
                    organismName = cmdArgs[1];
                    commandResult = this.manager.activateCluster(organismName);
                    if (!Constants.EMPTY_STRING.equals(commandResult)) {
                        this.writer.writeLine(commandResult);
                    }
                    break;
            }
            command = this.reader.readLine();
        }
    }

}
