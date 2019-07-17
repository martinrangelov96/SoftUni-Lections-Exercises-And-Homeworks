package bookshopsystemap.domain.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "authors")
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;

    public Author() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
