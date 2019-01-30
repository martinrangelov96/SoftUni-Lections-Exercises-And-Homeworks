import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        closestToCenter(x1, y1, x2, y2);

    }

    public static void closestToCenter(double x1, double y1, double x2, double y2) {
        double c1 = Math.abs(Math.sqrt(Math.pow(x1, 2)) + Math.pow(y1, 2));
        double c2 = Math.abs(Math.sqrt(Math.pow(x2, 2)) + Math.pow(y2, 2));

        if (c2 < c1) {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        } else {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        }

    }

}
