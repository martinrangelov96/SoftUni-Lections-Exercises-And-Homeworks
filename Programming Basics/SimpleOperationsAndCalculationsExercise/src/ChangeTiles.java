import java.util.Scanner;

public class ChangeTiles {

    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        int playGroundSide = Integer.parseInt(scanner.nextLine());
        double tileWidth = Double.parseDouble(scanner.nextLine());
        double tileLength = Double.parseDouble(scanner.nextLine());
        double benchWidth = Double.parseDouble(scanner.nextLine());
        double benchLength = Double.parseDouble(scanner.nextLine());

        int playGroundArea = (playGroundSide * playGroundSide);
        double benchArea = (benchWidth * benchLength);
        double tileArea = (tileWidth * tileLength);
        double tilesNeeded = ((playGroundArea - benchArea) / tileArea);
        double timeNeeded = tilesNeeded * 0.2;

        System.out.println(tilesNeeded);
        System.out.println(timeNeeded);

    }

}
