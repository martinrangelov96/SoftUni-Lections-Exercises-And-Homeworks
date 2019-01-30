import java.util.Scanner;

public class WorldSwimmingRecord {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double recordInMeters = Double.parseDouble(scanner.nextLine());
        double secondsForOneMeter = Double.parseDouble(scanner.nextLine());

        double hisTimeNoResistance = recordInMeters * secondsForOneMeter;
        double resistance = Math.floor(recordInMeters / 15) * 12.5;
        double hisTimeWithResistance = hisTimeNoResistance + resistance;


        if (hisTimeWithResistance < recordInSeconds) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", hisTimeWithResistance);
        } else {
            double ifHeFails = recordInSeconds - hisTimeWithResistance;
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(ifHeFails));
        }

    }

}
