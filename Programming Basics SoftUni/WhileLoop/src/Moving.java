import java.util.Scanner;

public class Moving {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int volume = width * length * height;

        String input = scanner.nextLine();

        int allBoxes = 0;

        while (!input.equals("Done")) {
            int countBox = Integer.parseInt(input);

            allBoxes += countBox;

            if (allBoxes > volume) {
                break;
            }

            input = scanner.nextLine();
        }

        if (volume > allBoxes) {
            System.out.printf("%d Cubic meters left.", volume - allBoxes);
        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", allBoxes - volume);
        }


    }

}
