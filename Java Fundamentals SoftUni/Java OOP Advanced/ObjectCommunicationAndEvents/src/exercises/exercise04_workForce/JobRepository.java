package exercises.exercise04_workForce;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class JobRepository {

    private Map<String, Job> jobs;

    public JobRepository() {
        this.jobs = new LinkedHashMap<>();
    }

    public void addJob(Job job) {
        this.jobs.putIfAbsent(job.getJobName(), job);
    }

    public void removeJob(String jobName) {
        this.jobs.remove(jobName);
    }

    public Map<String, Job> getJobs() {
        return Collections.unmodifiableMap(jobs);
    }
}
