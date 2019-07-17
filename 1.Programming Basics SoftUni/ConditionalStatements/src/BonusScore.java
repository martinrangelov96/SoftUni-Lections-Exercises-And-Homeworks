    import java.util.Scanner;

    public class BonusScore {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int number = Integer.parseInt(scanner.nextLine());

            double bonus = 0.0;
            int secondBonus = 0;

            if (number <= 100) {
                bonus = 5;
            } else if (number > 1000) {
                bonus = 0.10 * number;
            } else if (number > 100) {
                bonus = 0.20 * number;
            }

            if (number % 2 == 0) {
                secondBonus = 1;
            } else if (number % 10 == 5) {
                secondBonus = 2;
            }

            System.out.println(bonus + secondBonus);
            System.out.println(number + bonus + secondBonus);

        }

    }
