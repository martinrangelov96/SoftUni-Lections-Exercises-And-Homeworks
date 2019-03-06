package exercises.pr0304Barracks.core.commands;

import exercises.pr0304Barracks.annotations.Inject;
import exercises.pr0304Barracks.contracts.Executable;
import exercises.pr0304Barracks.contracts.Repository;
import exercises.pr0304Barracks.contracts.Unit;
import exercises.pr0304Barracks.contracts.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    @Override
    public String execute() {
        String unitType = this.data[1];

        try {
            this.repository.removeUnit(unitType);

            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

}
