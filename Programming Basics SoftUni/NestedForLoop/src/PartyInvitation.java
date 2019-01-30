import java.util.Scanner;

public class PartyInvitation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double invalidNamesCounter = 0;
        double validNamesCounter = 0;
        boolean isValid = true;

        while (!name.equals("Statistic")) {
            for (int i = 0; i < name.length(); i++) {
                if (!(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') && !(name.charAt(i) >= 'a' && (name.charAt(i) <= 'z'))) {
                    System.out.println("Invalid name!");
                    isValid = false;
                    invalidNamesCounter++;
                    break;
                } else {
                    isValid = true;
                }
            }

            if (isValid) {
                System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
                validNamesCounter++;
            }

            name = scanner.nextLine();
        }

        double validInvalidSum = validNamesCounter + invalidNamesCounter;

        System.out.printf("Valid names are %.2f%% from %.0f names.%n", (validNamesCounter / validInvalidSum) * 100 , validInvalidSum);
        System.out.printf("Invalid names are %.2f%% from %.0f names.", (invalidNamesCounter / validInvalidSum) * 100, validInvalidSum);

    }

}

