package task07_mankind;

public class Worker extends BaseHuman {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double moneyEarnedByHour() {
        return (weekSalary / 7) / this.workHoursPerDay;
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Week Salary: %.2f%n" +
                "Hours per day: %.2f%n" +
                "Salary per hour: %.2f",super.toString(), this.weekSalary, this.workHoursPerDay, this.moneyEarnedByHour());
    }
}
