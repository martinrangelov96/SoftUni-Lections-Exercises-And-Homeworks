package exercises.exercise04_workForce.abstractions;

public abstract class BaseEmployee {

    private String name;
    private int workHoursPerWeek;

    protected BaseEmployee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }

    public void setWorkHoursPerWeek(int workHoursPerWeek) {
        this.workHoursPerWeek = workHoursPerWeek;
    }
}
