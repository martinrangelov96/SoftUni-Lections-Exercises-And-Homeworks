import java.util.Scanner;

public class Kino {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOftickets = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        int numberOfPeople = rows * columns;
        double price = 0.0;

        if (typeOftickets.equals("Premiere")){
            price = numberOfPeople * 12.00;
        } else if(typeOftickets.equals("Normal")) {
            price = numberOfPeople * 7.50;
        } else if(typeOftickets.equals("Discount")) {
            price = numberOfPeople * 5.00;
        } else {
            System.out.println("Wrong Projection");
        }

        System.out.printf("%.2f leva", price);

    }

}
