import java.util.Scanner;

public class PointInRectangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.next());
        double y1 = Double.parseDouble(scanner.next());
        double x2 = Double.parseDouble(scanner.next());
        double y2 = Double.parseDouble(scanner.next());
        double x = Double.parseDouble(scanner.next());
        double y = Double.parseDouble(scanner.next());

        if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
            System.out.println("Inside");
        } else {
            System.out.println("Outside");
        }

    }

}
