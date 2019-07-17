import java.util.Scanner;

public class GraduationPt2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int years = 1;
        double sum = 0;
        int failCounter = 0;

        while (years <=12 && failCounter < 2) {

            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 4.00) {
                sum += grade;
                years++;
            }else {
                failCounter++;
            }

        }

        double average = sum / 12;

        if (failCounter == 2) {
            System.out.printf("%s has been excluded at %d grade", name, years);
        } else if(average >= 4.00) {
            System.out.printf("%s graduated. Average grade: %.2f",name, average);
        }

    }

}