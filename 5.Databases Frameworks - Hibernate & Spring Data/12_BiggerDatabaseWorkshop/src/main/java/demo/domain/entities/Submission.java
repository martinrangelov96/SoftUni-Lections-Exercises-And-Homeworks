package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "submissions")
public class Submission extends BaseEntity {

    private User user;
    private Strategy strategy;
    private Double codePerformance;
    private Double points;
    private Problem problem;

    public Submission() {
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user_id", referencedColumnName = "id"
    )
    public User getUser() {
        return user;
    }

    @ManyToOne(targetEntity = Strategy.class)
    @JoinColumn(
            name = "used_strategy_id", referencedColumnName = "id"
    )
    public Strategy getStrategy() {
        return strategy;
    }

    @Column(name = "code_performance")
    public Double getCodePerformance() {
        return codePerformance;
    }

    @Column(name = "points")
    public Double getPoints() {
        return points;
    }

    @ManyToOne(targetEntity = Problem.class)
    @JoinColumn(
            name = "problem_id", referencedColumnName = "id"
    )
    public Problem getProblem() {
        return problem;
    }

    //

    public void setUser(User user) {
        this.user = user;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setCodePerformance(Double codePerformance) {
        this.codePerformance = codePerformance;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
