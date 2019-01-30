import java.util.Scanner;

public class TwoDRectangleArea {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double a = Math.abs(x1 - x2);
        double b = Math.abs(y1 - y2);

        double rectangleArea = (a*b);
        double rectanglePerimeter = (2 * (a+b));

        System.out.println(rectangleArea);
        System.out.println(rectanglePerimeter);

    }

}
