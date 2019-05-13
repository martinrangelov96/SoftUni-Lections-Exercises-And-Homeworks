package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "max_results_for_problems")
public class MaxResultForProblem extends BaseEntity {

    private Problem problem;
    private Submission submission;
    private User user;

    public MaxResultForProblem() {
    }

    @ManyToOne(targetEntity = Problem.class)
    @JoinColumn(
            name = "problem_id", referencedColumnName = "id"
    )
    public Problem getProblem() {
        return problem;
    }

    @ManyToOne(targetEntity = Submission.class)
    @JoinColumn(
            name = "submission_id", referencedColumnName = "id"
    )
    public Submission getSubmission() {
        return submission;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user_id", referencedColumnName = "id"
    )
    public User getUser() {
        return user;
    }

    //

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
