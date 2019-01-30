import java.util.Scanner;

public class SumSeconds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstSeconds = Integer.parseInt(scanner.nextLine());
        int secondSeconds = Integer.parseInt(scanner.nextLine());
        int thirdSeconds = Integer.parseInt(scanner.nextLine());

        int sumSeconds = firstSeconds + secondSeconds + thirdSeconds;

        if (sumSeconds >= 10 && sumSeconds <= 59) {
            System.out.printf("0:%d", sumSeconds);
        } else if(sumSeconds >= 0 && sumSeconds <= 9) {
            System.out.printf("0:0%d", sumSeconds);
        } else if (sumSeconds >= 60 && sumSeconds <= 119 && sumSeconds - 60 < 10) {
            System.out.printf("1:0%d", sumSeconds - 60);
        } else if (sumSeconds >= 60 && sumSeconds <= 119) {
            System.out.printf("1:%d", sumSeconds - 60);
        } else if (sumSeconds >= 120 && sumSeconds <= 179 && sumSeconds - 120 < 10) {
            System.out.printf("2:0%d", sumSeconds - 120);
        } else if (sumSeconds >= 120 && sumSeconds <= 179) {
            System.out.printf("2:%d", sumSeconds - 120);
        }

    }
}
