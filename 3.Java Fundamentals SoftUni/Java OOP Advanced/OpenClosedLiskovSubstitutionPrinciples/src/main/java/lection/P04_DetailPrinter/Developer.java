package lection.P04_DetailPrinter;

public class Developer extends Employee {

    private String projectName;

    public Developer(String name, String projectName) {
        super(name);
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return super.toString() + " project " +this.projectName;
    }
}
