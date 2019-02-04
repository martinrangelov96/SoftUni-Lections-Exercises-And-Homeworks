package exercise03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentData = reader.readLine().split("\\s+");
        String[] workerData = reader.readLine().split("\\s+");

        String firstNameStudent = studentData[0];
        String lastNameStudent = studentData[1];
        String facultyNumber = studentData[2];

        String firstNameWorker = workerData[0];
        String lastNameWorker = workerData[1];
        double weekSalaryWorker = Double.parseDouble(workerData[2]);
        int workingHours = Integer.parseInt(workerData[3]);

        try {
            Student student = new Student(firstNameStudent, lastNameStudent, facultyNumber);
            Worker worker = new Worker(firstNameWorker, lastNameWorker, weekSalaryWorker, workingHours);
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

}

