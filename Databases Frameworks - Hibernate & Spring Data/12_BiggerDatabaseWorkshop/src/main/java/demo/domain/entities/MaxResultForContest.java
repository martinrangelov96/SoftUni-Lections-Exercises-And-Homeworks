package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "max_results_for_contests")
public class MaxResultForContest extends BaseEntity {

    private User user;
    private Contest contest;
    private Double averagePerformance;
    private Double overallPoints;

    public MaxResultForContest() {
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user_id", referencedColumnName = "id"
    )
    public User getUser() {
        return user;
    }

    @ManyToOne(targetEntity = Contest.class)
    @JoinColumn(
            name = "contest_id", referencedColumnName = "id"
    )
    public Contest getContest() {
        return contest;
    }

    @Column(name = "average_performance")
    public Double getAveragePerformance() {
        return averagePerformance;
    }

    @Column(name = "overall_points")
    public Double getOverallPoints() {
        return overallPoints;
    }

    //

    public void setUser(User user) {
        this.user = user;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public void setAveragePerformance(Double averagePerformance) {
        this.averagePerformance = averagePerformance;
    }

    public void setOverallPoints(Double overallPoints) {
        this.overallPoints = overallPoints;
    }
}
