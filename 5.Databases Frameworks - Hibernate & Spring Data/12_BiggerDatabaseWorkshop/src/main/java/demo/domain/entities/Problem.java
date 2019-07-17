package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "problems")
public class Problem extends BaseEntity {

    private String name;
    private Set<Submission> submissions;
    private Set<User> contestants;
    private Contest contest;
    private Set<MaxResultForProblem> maxResultsForProblems;

    public Problem() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(targetEntity = Submission.class, mappedBy = "problem")
    public Set<Submission> getSubmissions() {
        return submissions;
    }

    @ManyToMany(targetEntity = User.class, mappedBy = "problems")
    public Set<User> getContestants() {
        return contestants;
    }

    @ManyToOne(targetEntity = Contest.class)
    @JoinColumn(
            name = "contest_id", referencedColumnName = "id"
    )
    public Contest getContest() {
        return contest;
    }

    @OneToMany(targetEntity = MaxResultForProblem.class, mappedBy = "problem")
    public Set<MaxResultForProblem> getMaxResultsForProblems() {
        return maxResultsForProblems;
    }

    //

    public void setName(String name) {
        this.name = name;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }

    public void setContestants(Set<User> contestants) {
        this.contestants = contestants;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public void setMaxResultsForProblems(Set<MaxResultForProblem> maxResultsForProblems) {
        this.maxResultsForProblems = maxResultsForProblems;
    }
}
