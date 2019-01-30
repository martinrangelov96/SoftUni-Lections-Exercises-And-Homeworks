import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            boolean isRemoved = false;

            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String homeTown = tokens[3];

            Student student = new Student(firstName, lastName, age, homeTown);

            for (Student uniqueStudent : students) {
                if (uniqueStudent.getFirstName().equals(student.getFirstName())
                        && uniqueStudent.getLastName().equals(student.getLastName())) {
                    students.remove(uniqueStudent);
                    students.add(student);
                    isRemoved = true;
                }
            }

            if (!isRemoved) {
                students.add(student);
            }

            input = scanner.nextLine();

        }

        String hometownInput = scanner.nextLine();

        for (Student student : students) {
            if (hometownInput.equals(student.getHomeTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }
}
