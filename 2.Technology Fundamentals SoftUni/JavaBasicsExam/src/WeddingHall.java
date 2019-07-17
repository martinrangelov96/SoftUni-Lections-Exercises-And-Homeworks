import java.util.Scanner;

public class WeddingHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hallLength = Double.parseDouble(scanner.nextLine());
        double hallWidth = Double.parseDouble(scanner.nextLine());
        double barSide = Double.parseDouble(scanner.nextLine());

        double hallSize = hallLength * hallWidth;
        double barSize = barSide * barSide;
        double dancingSize = hallSize * 0.19;
        double freeSpace = hallSize - barSize - dancingSize;
        int people = (int) Math.ceil(freeSpace / 3.2);

        System.out.println(people);
    }
}
