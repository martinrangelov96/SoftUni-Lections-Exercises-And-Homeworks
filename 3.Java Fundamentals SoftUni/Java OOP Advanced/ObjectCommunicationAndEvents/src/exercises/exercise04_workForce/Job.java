package exercises.exercise04_workForce;

import exercises.exercise04_workForce.interfaces.Employee;

public class Job {

    private Employee employee;
    private String jobName;
    private int hoursOfWorkRequired;
    private JobRepository jobRepository;

    public Job(Employee employee, String jobName, int hoursOfWorkRequired, JobRepository jobRepository) {
        this.employee = employee;
        this.jobName = jobName;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.jobRepository = jobRepository;
    }

    public void update() {
        this.hoursOfWorkRequired = this.hoursOfWorkRequired - this.employee.getWorkHoursPerWeek();
        if (hoursOfWorkRequired <= 0) {
            System.out.println(String.format("Job %s done!", this.getJobName()));
            this.jobRepository.removeJob(jobName);
        }
    }

    public String getJobName() {
        return this.jobName;
    }

    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }
}
