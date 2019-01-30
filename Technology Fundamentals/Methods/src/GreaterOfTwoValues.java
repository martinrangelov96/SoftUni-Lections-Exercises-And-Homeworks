import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfValue = scanner.nextLine();

        if (typeOfValue.equals("int")) {
            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            int maxNumber = getMax(number1, number2);
            System.out.println(maxNumber);
        } else if (typeOfValue.equals("char")) {
            char char1 = scanner.next().charAt(0);
            char char2 = scanner.next().charAt(0);
            char maxChar = getMax(char1, char2);
            System.out.println(maxChar);
        } else {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();
            String maxWord = getMax(word1, word2);
            System.out.println(maxWord);
        }

    }

    public static int getMax(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        }

        return number2;
    }

    public static char getMax(char char1, char char2) {
        if (char1 > char2) {
            return char1;
        }

        return char2;
    }

    public static String getMax(String word1, String word2) {
        if (word1.compareTo(word2) >= 0) {
            return word1;
        }

        return word2;
    }
}
