package app.task04_hospital_database;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private int id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
