package lection.commands;

import lection.interfaces.AttackGroup;
import lection.interfaces.Command;
import lection.interfaces.Target;

public class GroupTargetCommand implements Command {
    private AttackGroup group;
    private Target target;

    public GroupTargetCommand(AttackGroup group, Target target) {
        this.group = group;
        this.target = target;
    }

    @Override
    public void execute() {
        this.group.groupTarget(this.target);
    }
}
