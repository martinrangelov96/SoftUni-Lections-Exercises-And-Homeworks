package studentsTask;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private double grade;

    Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    double getGrade() {
        return grade;
    }

}

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);

            Student student = new Student(firstName, lastName, grade);

            students.add(student);
        }

        students.stream().sorted((g1, g2) -> Double.compare(g2.getGrade(), g1.getGrade()))
                .forEach(s -> System.out.printf("%s %s: %.2f%n", s.getFirstName(), s.getLastName(), s.getGrade()));

    }
}
