package app.task03_university_database;

import app.BasePerson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends BasePerson {

    private double averageGrade;
    private int attendance;
    private Set<Course> courses;

    public Student() {

    }

    @Column(name = "average_grade")
    public double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column(name = "attendance")
    public int getAttendance() {
        return this.attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(targetEntity = Course.class, mappedBy = "students")
    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
