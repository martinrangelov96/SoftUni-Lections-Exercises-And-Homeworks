import java.util.Scanner;

public class SleepyTomCat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int restDays = Integer.parseInt(scanner.nextLine());

        int workDays = 365 - restDays;

        int playTimeInWorkDays = 63;
        int playTimeInRestDays = 127;

        int yearNorm = 30000;

        int playTimeSummed = (workDays * playTimeInWorkDays)  + (restDays * playTimeInRestDays);

        int hours = (playTimeSummed - yearNorm) / 60;
        double minutes = (playTimeSummed - yearNorm) % 60;

        if (playTimeSummed >= yearNorm) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %.0f minutes more for play", hours, minutes);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %.0f minutes less for play", Math.abs(hours), Math.abs(minutes));
        }

    }

}
