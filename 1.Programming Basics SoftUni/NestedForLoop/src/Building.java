import java.util.Scanner;

public class Building {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int floorCount = Integer.parseInt(scanner.nextLine());
        int roomsCount = Integer.parseInt(scanner.nextLine());

        for (int floor = floorCount; floor >= 1; floor--) {
            for (int rooms = 0; rooms < roomsCount; rooms++) {
                if (floor == floorCount) {
                    System.out.printf("L%d%d ",floor,rooms);
                    continue;
                }

                if (floor % 2 ==0) {
                    System.out.printf("O%d%d ",floor,rooms);
                } else {
                    System.out.printf("A%d%d ",floor,rooms);
                }
            }
            System.out.println();
        }

    }

}
