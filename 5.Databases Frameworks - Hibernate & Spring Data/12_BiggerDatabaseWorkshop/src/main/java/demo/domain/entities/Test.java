package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tests")
public class Test extends BaseEntity {

    private String expectedResult;
    private String textContent;
    private Problem problem;

    public Test() {
    }

    @Column(name = "expected_result")
    public String getExpectedResult() {
        return expectedResult;
    }

    @Column(name = "text_content")
    public String getTextContent() {
        return textContent;
    }

    @ManyToOne(targetEntity = Problem.class)
    @JoinColumn(
            name = "problem_id", referencedColumnName = "id"
    )
    public Problem getProblem() {
        return problem;
    }

    //

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
