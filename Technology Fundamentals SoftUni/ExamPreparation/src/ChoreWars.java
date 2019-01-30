import java.util.Scanner;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int dishes = 0, cleaning = 0, laundry = 0;

        while (!input.equals("wife is happy")) {

            if (input.contains("{") && input.contains("}")) {
                int begin = input.indexOf("{") + 1;
                int end = input.indexOf("}");

                String data = input.substring(begin, end);
                for (int i = 0; i < data.length(); i++) {
                    if (Character.isDigit(data.charAt(i))) {
                        laundry += data.charAt(i) - '0';
                    }
                }
            } else if (input.contains("<") && input.contains(">")) {
                int begin = input.lastIndexOf("<") + 1;
                int end = input.indexOf(">");

                String data = input.substring(begin, end);
                if (isValidDishes(data)) {
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isDigit(data.charAt(i))) {
                            dishes += data.charAt(i) - '0';
                        }
                    }
                }
            } else if (input.contains("[") && input.contains("]")) {
                int begin = input.lastIndexOf("[") + 1;
                int end = input.indexOf("]");

                String data = input.substring(begin, end);
                if (isValidCleaning(data)) {
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isDigit(data.charAt(i))) {
                            cleaning += data.charAt(i) - '0';
                        }
                    }
                }
            }

            input = scanner.nextLine();

        }

        System.out.printf("Doing the dishes - %d min.%n", dishes);
        System.out.printf("Cleaning the house - %d min.%n", cleaning);
        System.out.printf("Doing the laundry - %d min.%n", laundry);
        System.out.printf("Total - %d min.%n", dishes + cleaning + laundry);

    }

    private static boolean isValidDishes(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i)) && !Character.isLowerCase(data.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCleaning(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i)) && !Character.isUpperCase(data.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
