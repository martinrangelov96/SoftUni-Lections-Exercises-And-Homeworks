package app.task04_hospital_database;

import app.Visitation;
import app.task04_hospital_database.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient extends BaseEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private boolean hasMedicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicaments> medicaments;

    public Patient() {
    }


    @Column(name = "first_name")
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

    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "picture")
    @Lob
    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "has_medical_insurance", nullable = false)
    public boolean isHasMedicalInsurance() {
        return this.hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    @OneToMany(targetEntity = Visitation.class, mappedBy = "patient")
    public Set<Visitation> getVisitations() {
        return this.visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany
    @JoinTable(
            name = "patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id",
                    referencedColumnName = "id")
    )
    public Set<Diagnose> getDiagnoses() {
        return this.diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }


    @ManyToMany
    @JoinTable(
            name = "patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicaments_id",
                    referencedColumnName = "id")
    )
    public Set<Medicaments> getMedicaments() {
        return this.medicaments;
    }

    public void setMedicaments(Set<Medicaments> medicaments) {
        this.medicaments = medicaments;
    }
}
