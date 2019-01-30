import java.util.Scanner;

public class ExamPreparation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfFails = Integer.parseInt(scanner.nextLine());
        int failCounter = 0;

        int numberOfProblems = 0;
        int sumGrade = 0;

        double averageScore = 0;

        String tasks = "";
        String taskName = "";

        while (numberOfFails > failCounter) {
            taskName = scanner.nextLine();

            if (taskName.equals("Enough")) {
                break;
            }

            int grade = Integer.parseInt(scanner.nextLine());
            sumGrade += grade;
            numberOfProblems++;

            averageScore = sumGrade *1.0 / numberOfProblems;

            if (grade <= 4) {
                failCounter++;
            }

            tasks = taskName;
        }

        if (taskName.equals("Enough")) {
            System.out.printf("Average score: %.2f%n", averageScore);
            System.out.printf("Number of problems: %d%n", numberOfProblems);
            System.out.printf("Last problem: %s", tasks);
        }

        if (numberOfFails == failCounter) {
            System.out.printf("You need a break, %d poor grades.", failCounter);
        }

    }

}
