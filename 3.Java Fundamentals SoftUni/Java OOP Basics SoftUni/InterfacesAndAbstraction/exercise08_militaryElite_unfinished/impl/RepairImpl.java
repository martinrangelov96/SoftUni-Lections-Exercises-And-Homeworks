package exercise08_militaryElite_unfinished.impl;

import exercise08_militaryElite_unfinished.contracts.Repair;

public class RepairImpl implements Repair {

    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}
