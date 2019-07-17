import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DicesDemo {

    static class Dice {
        private int sides;

        public Dice(int sides) throws IllegalArgumentException {
            if (sides <= 0 || sides % 2 == 1) {
                throw new IllegalArgumentException("The dice must have at least one side and at least two sides and it must be even.");
            }
            this.sides = sides;
        }

        int roll() {
            Random rnd = new Random();
            int randomNumer = rnd.nextInt(this.sides);
            int result = randomNumer + 1;

            return result;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int diceCount = Integer.parseInt(sc.nextLine());
        int sidesPerDice = Integer.parseInt(sc.nextLine());
        int winningSumMinimum = Integer.parseInt(sc.nextLine());

        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < diceCount; i++) {
            Dice dice = new Dice(sidesPerDice);
            dices.add(dice);
        }

        int sum = 0;
        for (Dice dice : dices) {
            sum += dice.roll();
        }

        System.out.println("Your sum is " + sum);

        if (sum >= winningSumMinimum) {
            System.out.println("Congratulations, you have won the big nothing!");
        } else {
            System.out.println("Sorry, you lost!");
        }

    }
}

