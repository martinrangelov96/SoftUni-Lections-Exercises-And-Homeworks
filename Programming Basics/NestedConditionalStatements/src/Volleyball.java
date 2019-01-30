import java.util.Scanner;

public class Volleyball {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOfYear = scanner.nextLine();
        int numberOfHolidays = Integer.parseInt(scanner.nextLine());
        int hometownWeekends = Integer.parseInt(scanner.nextLine());

        int numberOfWeekendsInSofia = 48 - hometownWeekends;
        double numberOfGamesInSofiaWeekends = numberOfWeekendsInSofia * (3.0/4);
        double numberOfGamesInHolidays = numberOfHolidays * (2.0/3);
        double totalNumberOfGames = numberOfGamesInSofiaWeekends + hometownWeekends + numberOfGamesInHolidays;

        if (typeOfYear.equals("normal")) {
            System.out.printf("%.0f",Math.floor(totalNumberOfGames));
        } else if(typeOfYear.equals("leap")) {
            double leapYearGames = totalNumberOfGames + (0.15 * totalNumberOfGames);
            System.out.printf("%.0f",Math.floor(leapYearGames));
        }

    }

}
