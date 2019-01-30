import java.util.Scanner;

public class CelsiusToFahrenheit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsium = Double.parseDouble(scanner.nextLine());
        double fahrenheit = ((celsium *1.8) +32);

        System.out.println(String.format("%.2f", fahrenheit));
    }

}
