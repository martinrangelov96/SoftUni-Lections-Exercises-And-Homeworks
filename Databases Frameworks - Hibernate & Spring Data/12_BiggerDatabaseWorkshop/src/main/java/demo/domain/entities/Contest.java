package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "contests")
public class Contest extends BaseEntity {

    private String name;
    private Category category;
    private Set<Problem> problems;
    private Set<User> contestants;
    private Set<MaxResultForContest> maxResultsForContests;

    public Contest() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(
            name = "category_id", referencedColumnName = "id"
    )
    public Category getCategory() {
        return category;
    }

    @OneToMany(targetEntity = Problem.class, mappedBy = "contest")
    public Set<Problem> getProblems() {
        return problems;
    }

    @ManyToMany(targetEntity = User.class, mappedBy = "contests")
    public Set<User> getContestants() {
        return contestants;
    }

    @OneToMany(targetEntity = MaxResultForContest.class, mappedBy = "contest")
    public Set<MaxResultForContest> getMaxResultsForContests() {
        return maxResultsForContests;
    }

    //

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }

    public void setContestants(Set<User> contestants) {
        this.contestants = contestants;
    }

    public void setMaxResultsForContests(Set<MaxResultForContest> maxResultsForContests) {
        this.maxResultsForContests = maxResultsForContests;
    }
}
