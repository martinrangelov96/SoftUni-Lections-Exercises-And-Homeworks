package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "strategies")
public class Strategy extends BaseEntity {

    private String name;
    private Set<Contest> contests;

    public Strategy() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToMany(targetEntity = Contest.class)
    @JoinTable(
            name = "contests_strategies",
            joinColumns = @JoinColumn(
                    name = "strategy_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "contest_id", referencedColumnName = "id"
            )
    )
    public Set<Contest> getContests() {
        return contests;
    }

    //

    public void setName(String name) {
        this.name = name;
    }

    public void setContests(Set<Contest> contests) {
        this.contests = contests;
    }
}
