package exercise03_mankind;

public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(int workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return (this.getWeekSalary() / this.getWorkHoursPerDay()) / 7;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%n" +
                "Last Name: %s%n" +
                "Week Salary: %.2f%n" +
                "Hours per day: %.2f%n" +
                "Salary per hour: %.2f",
                this.getFirstName(), this.getLastName(), this.getWeekSalary(), this.getWorkHoursPerDay(), this.getSalaryPerHour());
    }

}
