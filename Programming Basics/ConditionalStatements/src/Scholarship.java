import java.util.Scanner;

public class Scholarship {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double familyIncome = Double.parseDouble(scanner.nextLine());
        double averageGrades = Double.parseDouble(scanner.nextLine());
        double minimalWage = Double.parseDouble(scanner.nextLine());

        double socialScholarship = 0.35 * minimalWage;
        double excellentScholarship = 25 * averageGrades;

        if (familyIncome < minimalWage && averageGrades >= 4.50 && averageGrades <= 5.50) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
        } else if (familyIncome < minimalWage && averageGrades >= 4.50 && socialScholarship > excellentScholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
        } else if (familyIncome < minimalWage && averageGrades >= 5.50 && excellentScholarship > socialScholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentScholarship));
        } else if(familyIncome >= minimalWage && averageGrades >= 5.50) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentScholarship));
        } else {
            System.out.println("You cannot get a scholarship!");
        }

    }

}
