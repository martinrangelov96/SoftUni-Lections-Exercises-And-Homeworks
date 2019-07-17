import java.util.Scanner;

public class TimePlus15Minutes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int plusFifteenMinutes = 15;

        if (hours == 23 && minutes >= 45) {
            hours = 0;
            minutes+=plusFifteenMinutes - 60;
        } else if (hours == 23 && minutes < 45) {
            minutes+=plusFifteenMinutes;
        } else if (hours < 23 && minutes < 45) {
            minutes+=plusFifteenMinutes;
        } else if(hours < 23 && minutes >= 45) {
            hours+=1;
            minutes+=plusFifteenMinutes - 60;
        }

        if (minutes >= 10) {
            System.out.printf("%d:%d", hours, minutes);
        }
        if (minutes < 10) {
            System.out.printf("%d:0%d", hours, minutes);
        }

    }

}
