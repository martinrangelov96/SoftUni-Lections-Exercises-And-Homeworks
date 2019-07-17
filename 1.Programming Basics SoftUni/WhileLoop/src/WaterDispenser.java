import java.util.Scanner;

public class WaterDispenser {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cupVolume = Integer.parseInt(scanner.nextLine());

        int waterSum = 0;
        int tapCounter = 0;

        while (cupVolume > waterSum) {
            String powerWater = scanner.nextLine();
            if (powerWater.equals("Easy")) {
                waterSum += 50;
                tapCounter++;
            } else if (powerWater.equals("Medium")) {
                waterSum += 100;
                tapCounter++;
            } else if (powerWater.equals("Hard")) {
                waterSum += 200;
                tapCounter++;
            }

        }
        if (waterSum > cupVolume) {
            System.out.printf("%dml has been spilled.", waterSum - cupVolume);
        } else {
            System.out.printf("The dispenser has been tapped %d times.", tapCounter);
        }

    }

}
