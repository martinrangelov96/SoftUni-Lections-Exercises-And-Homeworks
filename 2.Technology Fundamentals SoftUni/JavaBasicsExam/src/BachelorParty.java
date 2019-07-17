import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int moneyForSinger = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int couvert = 0;
        int couvertSum = 0;
        int peopleSum = 0;

        while (!input.equals("The restaurant is full")) {
            int people = Integer.parseInt(input);
            couvert = 0;

            if (people < 5) {
                couvert = 100;
            } else {
                couvert = 70;
            }

            peopleSum += people;
            couvertSum += people * couvert;

            input = scanner.nextLine();
        }

        if (couvertSum >= moneyForSinger) {
            System.out.printf("You have %d guests and %d leva left.", peopleSum, couvertSum - moneyForSinger);
        } else {
            System.out.printf("You have %d guests and %d leva income, but no singer.", peopleSum, couvertSum);
        }

    }
}
