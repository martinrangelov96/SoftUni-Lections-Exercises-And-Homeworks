import java.util.Scanner;

public class OwnBussiness {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int roomVolume = width * length * height;
        int computerSum = 0;

        String input = scanner.nextLine();

        while (true) {
            if (input.equals("Done")) {
                System.out.printf("%d Cubic meters left.", roomVolume - computerSum);
                break;
            }
            int numberOfComputers = Integer.parseInt(input);
            computerSum += numberOfComputers;

            if (computerSum > roomVolume) {
                System.out.printf("No more free space! You need %d Cubic meters more.", computerSum - roomVolume);
                break;
            }

            input = scanner.nextLine();
        }


    }

}
