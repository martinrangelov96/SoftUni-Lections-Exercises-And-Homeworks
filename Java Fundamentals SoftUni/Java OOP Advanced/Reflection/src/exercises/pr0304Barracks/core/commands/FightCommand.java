package exercises.pr0304Barracks.core.commands;

import exercises.pr0304Barracks.contracts.Executable;
import exercises.pr0304Barracks.contracts.Repository;
import exercises.pr0304Barracks.contracts.UnitFactory;
import exercises.pr0304Barracks.data.UnitRepository;

public class FightCommand implements Executable {

    @Override
    public String execute() {
        return "fight";
    }
}
