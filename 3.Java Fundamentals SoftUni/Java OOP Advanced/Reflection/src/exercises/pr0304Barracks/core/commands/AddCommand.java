package exercises.pr0304Barracks.core.commands;

import exercises.pr0304Barracks.annotations.Inject;
import exercises.pr0304Barracks.contracts.Executable;
import exercises.pr0304Barracks.contracts.Repository;
import exercises.pr0304Barracks.contracts.Unit;
import exercises.pr0304Barracks.contracts.UnitFactory;
import exercises.pr0304Barracks.data.UnitRepository;
import jdk.jshell.spi.ExecutionControl;

public class AddCommand implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
