import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        robesPrice *= students;

        double sabersPrice = Math.ceil(students * 1.1) * lightSaberPrice;

        beltsPrice *= (students - students / 6);

        double totalCost = robesPrice + sabersPrice + beltsPrice;

        if (budget >= totalCost) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalCost - budget);
        }

    }
}
