package task07_mankind;

public abstract class BaseHuman {

    private String firstName;
    private String lastName;

    protected BaseHuman(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        } else if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format
                ("First Name: %s%n" +
                                "Last Name: %s%n",
                        this.getFirstName(), this.getLastName());
    }


}
