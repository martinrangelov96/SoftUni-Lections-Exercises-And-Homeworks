package task07_mankind;

public class Student extends BaseHuman {

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Faculty number: %s%n", super.toString(), this.getFacultyNumber());
    }
}
