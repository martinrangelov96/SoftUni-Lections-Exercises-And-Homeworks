import java.util.Scanner;

public class TrainTheTrainers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfJury = Integer.parseInt(scanner.nextLine());
        String input = "";
        double juryScoresSum = 0;
        double finalAssessement = 0;
        double juryScores = 0;
        int projectsCounter = 0;

        while (true) {
            input = scanner.nextLine();
            if (input.equals("Finish")) {
                break;
            }
            for (int i = 0; i < numberOfJury; i++) {
                juryScores = Double.parseDouble(scanner.nextLine());
                juryScoresSum += juryScores;
            }
            finalAssessement += juryScoresSum / numberOfJury;
            System.out.printf("%s - %.2f.%n", input, juryScoresSum / numberOfJury);
            juryScoresSum = 0;
            projectsCounter++;
        }

        System.out.printf("Student's final assessment is %.2f.%n", finalAssessement / projectsCounter);

    }

}
