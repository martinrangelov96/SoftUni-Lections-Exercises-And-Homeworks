package lection_database_apps_introduction.repository_pattern;

public class Employee {

    private long id;
    private String firstName;
    private String lastName;

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this(0, firstName, lastName);
    }

    public Employee(long id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLatName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLatName(String latName) {
        this.lastName = latName
        ;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
