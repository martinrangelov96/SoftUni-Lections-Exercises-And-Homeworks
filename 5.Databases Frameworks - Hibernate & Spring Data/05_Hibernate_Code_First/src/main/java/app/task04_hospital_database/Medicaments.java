package app.task04_hospital_database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicaments extends BaseEntity {

    private String name;
    private Set<Patient> patients;

    public Medicaments() {
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Patient.class, mappedBy = "medicaments")
    public Set<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
