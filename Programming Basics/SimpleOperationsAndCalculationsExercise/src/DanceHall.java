import java.util.Scanner;

public class DanceHall {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double wardrobeSide = Double.parseDouble(scanner.nextLine());

        double hallArea = (( length * 100) * ( width * 100));
        double wardrobeArea = ((wardrobeSide * 100) * (wardrobeSide * 100));
        double bench = (hallArea/10);

        double freeHallSpace = (hallArea - wardrobeArea - bench);
        double people = (freeHallSpace / (40+7000));

        System.out.println((int) people);
    }

}
