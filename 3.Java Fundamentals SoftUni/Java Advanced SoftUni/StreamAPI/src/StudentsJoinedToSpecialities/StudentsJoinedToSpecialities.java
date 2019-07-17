package StudentsJoinedToSpecialities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsJoinedToSpecialities {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpeciality> studentSpecialities = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        String line;
        while (true) {
            if ("Students:".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String specialtyNameFirst = tokens[0];
            String specialtyNameSecond = tokens[1];
            String facultyNumber = tokens[2];

            StudentSpeciality studentSpeciality = new StudentSpeciality
                    (specialtyNameFirst + " " + specialtyNameSecond, facultyNumber);

            studentSpecialities.add(studentSpeciality);
        }

        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String facultyNumber = tokens[0];
            String studentFirstName = tokens[1];
            String studentLastName = tokens[2];

            Student student = new Student
                    (studentFirstName + " " + studentLastName, facultyNumber);

            students.add(student);
        }

        studentSpecialities.stream()
                .flatMap(sp -> students.stream())
                .forEach(s -> {

                });

    }
}

class StudentSpeciality {
    String specialityByName;
    String facultyNumber;

    public StudentSpeciality(String specialityByName, String facultyNumber) {
        this.specialityByName = specialityByName;
        this.facultyNumber = facultyNumber;
    }
}

class Student {
    String studentName;
    String facultyNumber;

    public Student(String studentName, String facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }
}
