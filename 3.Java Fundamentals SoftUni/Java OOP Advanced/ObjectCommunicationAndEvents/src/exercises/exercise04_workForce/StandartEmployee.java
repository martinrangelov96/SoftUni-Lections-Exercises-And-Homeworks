package exercises.exercise04_workForce;

import exercises.exercise04_workForce.abstractions.BaseEmployee;
import exercises.exercise04_workForce.interfaces.Employee;

public class StandartEmployee extends BaseEmployee implements Employee {
    private final static int STANDART_EMPLOYEE_HOURS_PER_WEEK = 40;

    public StandartEmployee(String name) {
        super(name);
        super.setWorkHoursPerWeek(STANDART_EMPLOYEE_HOURS_PER_WEEK);
    }

    @Override
    public int getWorkHoursPerWeek() {
        return super.getWorkHoursPerWeek();
    }

}
