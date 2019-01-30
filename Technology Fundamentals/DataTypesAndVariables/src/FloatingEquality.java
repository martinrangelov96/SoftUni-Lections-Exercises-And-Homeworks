import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        double eps = 0.000001;

        if (Math.abs(a - b) >= eps){
            System.out.println("False");
        } else {
            System.out.println("True");
        }

    }
}
