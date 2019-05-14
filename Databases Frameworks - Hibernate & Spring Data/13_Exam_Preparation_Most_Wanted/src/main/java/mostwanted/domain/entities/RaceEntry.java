package mostwanted.domain.entities;

import mostwanted.domain.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "race_entries")
public class RaceEntry extends BaseEntity {

    private Boolean hasFinished;
    private Double finishTime;
    private Car car;
    private Racer racer;
    private Race race;

    public RaceEntry() {
    }

    @Column(name = "has_finished")
    public Boolean getHasFinished() {
        return hasFinished;
    }

    @Column(name = "finish_time")
    public Double getFinishTime() {
        return finishTime;
    }

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(
            name = "car_id", referencedColumnName = "id"
    )
    public Car getCar() {
        return car;
    }

    @ManyToOne(targetEntity = Racer.class)
    @JoinColumn(
            name = "racer_id", referencedColumnName = "id"
    )
    public Racer getRacer() {
        return racer;
    }

    @ManyToOne(targetEntity = Race.class)
    @JoinColumn(
            name = "race_id", referencedColumnName = "id"
    )
    public Race getRace() {
        return race;
    }

    //

    public void setHasFinished(Boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public void setFinishTime(Double finishTime) {
        this.finishTime = finishTime;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
