import java.util.Scanner;

public class MetricConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double m = 1;
        double mm = m/1000;
        double cm = m/100;
        double mi = m/0.000621371192;
        double in = m/39.3700787;
        double km = m/0.001;
        double ft = m/3.2808399;
        double yd = m/1.0936133;

        double distance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        if(input.equals("m")) {
            distance = (distance*m);
        } else if (input.equals("mm")) {
            distance = (distance*mm);
        } else if (input.equals("cm")) {
            distance = (distance*cm);
        } else if (input.equals("mi")) {
            distance = (distance*mi);
        } else if (input.equals("in")) {
            distance = (distance*in);
        } else if (input.equals("km")) {
            distance = (distance*km);
        } else if (input.equals("ft")) {
            distance = (distance*ft);
        } else if (input.equals("yd")) {
            distance = (distance*yd);
        } else {
            System.out.println("Wrong value!");
            return;
        }

        if(output.equals("m")) {
            distance = (distance*m);
        } else if (output.equals("mm")) {
            distance = (distance/mm);
        } else if (output.equals("cm")) {
            distance = (distance/cm);
        } else if (output.equals("mi")) {
            distance = (distance/mi);
        } else if (output.equals("in")) {
            distance = (distance/in);
        } else if (output.equals("km")) {
            distance = (distance/km);
        } else if (output.equals("ft")) {
            distance = (distance/ft);
        } else if (output.equals("yd")) {
            distance = (distance/yd);
        } else {
            System.out.println("Wrong value!");
            return;
        }

        System.out.printf("%.8f",distance);

    }

}
