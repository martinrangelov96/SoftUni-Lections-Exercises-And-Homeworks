import java.util.Scanner;

class RadiansToDegrees {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double rad = Double.parseDouble(scanner.nextLine());
        double deg = Math.toDegrees(rad);

        System.out.println(String.format("%.0f", deg));

    }

}
