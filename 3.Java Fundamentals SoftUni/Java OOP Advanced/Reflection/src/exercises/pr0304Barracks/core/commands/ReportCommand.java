package exercises.pr0304Barracks.core.commands;

import exercises.pr0304Barracks.annotations.Inject;
import exercises.pr0304Barracks.contracts.Executable;
import exercises.pr0304Barracks.contracts.Repository;
import exercises.pr0304Barracks.contracts.UnitFactory;
import exercises.pr0304Barracks.data.UnitRepository;
import jdk.jshell.spi.ExecutionControl;

public class ReportCommand implements Executable {

    @Inject
    private Repository repository;

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
