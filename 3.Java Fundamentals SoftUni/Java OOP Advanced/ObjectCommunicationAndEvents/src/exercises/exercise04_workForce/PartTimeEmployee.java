package exercises.exercise04_workForce;

import exercises.exercise04_workForce.abstractions.BaseEmployee;
import exercises.exercise04_workForce.interfaces.Employee;

public class PartTimeEmployee extends BaseEmployee implements Employee {
    private final static int PART_TIME_EMPLOYEE_HOURS_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name);
        super.setWorkHoursPerWeek(PART_TIME_EMPLOYEE_HOURS_PER_WEEK);
    }

    @Override
    public int getWorkHoursPerWeek() {
        return super.getWorkHoursPerWeek();
    }
}
