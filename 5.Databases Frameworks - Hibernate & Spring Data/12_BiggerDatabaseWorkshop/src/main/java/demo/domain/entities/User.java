package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity {

    private String username;
    private Set<Submission> submissions;
    private Set<MaxResultForProblem> maxResultsForProblems;
    private Set<MaxResultForContest> maxResultsForContests;
    private Set<Contest> contests;
    private Set<Problem> problems;

    public User() {
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    @OneToMany(targetEntity = Submission.class, mappedBy = "user")
    public Set<Submission> getSubmissions() {
        return submissions;
    }

    @OneToMany(targetEntity = MaxResultForProblem.class, mappedBy = "user")
    public Set<MaxResultForProblem> getMaxResultsForProblems() {
        return maxResultsForProblems;
    }

    @OneToMany(targetEntity = MaxResultForContest.class, mappedBy = "user")
    public Set<MaxResultForContest> getMaxResultsForContests() {
        return maxResultsForContests;
    }

    @ManyToMany(targetEntity = Contest.class)
    @JoinTable(
            name = "users_participations",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "contest_id", referencedColumnName = "id"
            )
    )
    public Set<Contest> getContests() {
        return contests;
    }

    @ManyToMany(targetEntity = Problem.class)
    @JoinTable(
            name = "users_problems",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "problem_id", referencedColumnName = "id"
            )
    )
    public Set<Problem> getProblems() {
        return problems;
    }

    //

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }

    public void setMaxResultsForProblems(Set<MaxResultForProblem> maxResultsForProblems) {
        this.maxResultsForProblems = maxResultsForProblems;
    }

    public void setMaxResultsForContests(Set<MaxResultForContest> maxResultsForContests) {
        this.maxResultsForContests = maxResultsForContests;
    }

    public void setContests(Set<Contest> contests) {
        this.contests = contests;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }
}
