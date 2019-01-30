import java.util.Scanner;

public class OnTimeForTheExam {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        double examTime = (examHour * 60) + examMinutes;
        double arrivalTime = (arrivalHour * 60) + arrivalMinutes;

        double timeLeft = arrivalTime - examTime;
        double earlyTime = examTime - arrivalTime;

        if (examTime < arrivalTime) {
            System.out.println("Late");
            double hoursLate = Math.floor(timeLeft / 60);
            double minutesLate = timeLeft % 60;
            if (arrivalTime - examTime >= 60 && minutesLate > 0 && minutesLate < 10) {
                System.out.printf("%.0f:0%.0f hours after the start", hoursLate, minutesLate);
            } else if (arrivalTime - examTime >= 60 && minutesLate == 0) {
                System.out.printf("%.0f:00 hours after the start", hoursLate);
            } else if (arrivalTime - examTime >= 60) {
                System.out.printf("%.0f:%.0f hours after the start", hoursLate, minutesLate);
            } else {
                System.out.printf("%.0f minutes after the start", minutesLate);
            }
        } else if (examTime == arrivalTime) {
            System.out.println("On Time");
        } else if (examTime - arrivalTime <= 30) {
            System.out.println("On time");
            System.out.printf("%.0f minutes before the start", earlyTime);
        } else {
            System.out.println("Early");
            double hoursEarly = Math.floor(earlyTime / 60);
            double minutesEarly = earlyTime % 60;
            if (examTime - arrivalTime > 60 && minutesEarly > 0 && minutesEarly < 10) {
                System.out.printf("%.0f:0%.0f hours before the start",hoursEarly, minutesEarly);
            } else if(examTime - arrivalTime >= 60 && minutesEarly == 0) {
                System.out.printf("%.0f:00 hours before the start", hoursEarly);
            } else if (examTime - arrivalTime > 60){
                System.out.printf("%.0f:%.0f hours before the start", hoursEarly, minutesEarly);
            } else if (examTime - arrivalTime < 60) {
                System.out.printf("%.0f minutes before the start", earlyTime);
            } else {
                System.out.printf("%.0f:00 hours before the start", hoursEarly);
            }
        }

    }

}
