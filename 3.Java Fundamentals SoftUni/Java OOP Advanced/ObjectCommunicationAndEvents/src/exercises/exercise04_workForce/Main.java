package exercises.exercise04_workForce;

import exercises.exercise04_workForce.interfaces.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        String employeeName;
        Map<String, Employee> employees = new LinkedHashMap<>();
        Job job;
        JobRepository jobRepository = new JobRepository();
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Job":
                    String nameOfJob = tokens[1];
                    int hoursOfWorkRequired = Integer.parseInt(tokens[2]);
                    employeeName = tokens[3];
                    Employee employee = employees.get(employeeName);

                    job = new Job(employee, nameOfJob, hoursOfWorkRequired, jobRepository);
                    jobRepository.addJob(job);

                    break;
                case "StandartEmployee":
                    employeeName = tokens[1];
                    Employee standartEmployee = new StandartEmployee(employeeName);
                    employees.putIfAbsent(employeeName, standartEmployee);

                    break;
                case "PartTimeEmployee":
                    employeeName = tokens[1];
                    Employee partTimeEmployee = new PartTimeEmployee(employeeName);
                    employees.putIfAbsent(employeeName, partTimeEmployee);

                    break;
                case "Pass":
                    for (Map.Entry<String, Job> entry : jobRepository.getJobs().entrySet()) {
                        entry.getValue().update();
                    }

                    break;
                case "Status":
                    //Job: <jobName> Hours Remaining: <hoursOfWorkRequired>
                    for (Map.Entry<String, Job> entry : jobRepository.getJobs().entrySet()) {
                        System.out.println(String.format("Job: %s Hours Remaining: %d",
                                entry.getValue().getJobName(), entry.getValue().getHoursOfWorkRequired()));
                    }

                    break;
            }
        }
    }
}
