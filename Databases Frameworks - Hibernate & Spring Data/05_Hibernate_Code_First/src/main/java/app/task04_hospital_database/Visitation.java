package app;

import app.task04_hospital_database.BaseEntity;
import app.task04_hospital_database.Patient;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {

    private LocalDate date;
    private String comments;
    private Patient patient;

    public Visitation() {
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "coments", columnDefinition = "TEXT")
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
