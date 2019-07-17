import java.util.Scanner;

public class CircleAreaAndPerimeter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());
        double area = (Math.PI * Math.pow(r,2));
        double perimeter = (2* Math.PI * r);

        System.out.println(area);
        System.out.println(perimeter);

    }

}
