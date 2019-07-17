import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String smallerString = "";
        String biggerString = "";

        if (input[0].length() > input[1].length()) {
            smallerString = input[1];
            biggerString = input[0];
        } else {
            smallerString = input[0];
            biggerString = input[1];
        }

        int totalSum = 0;

        for (int i = 0; i < smallerString.length(); i++) {
            String str1 = input[0];
            String str2 = input[1];

            if (str1.length() == str2.length()) {
                totalSum += str1.charAt(i) * str2.charAt(i);
            } else {
                for (int j = 0; j < smallerString.length() ; j++) {
                    totalSum += str1.charAt(i) * str2.charAt(i);
                }
                for (int j = smallerString.length(); j < biggerString.length(); j++) {
                    totalSum += biggerString.charAt(j);
                }
                break;
            }
        }

        System.out.println(totalSum);

    }
}
