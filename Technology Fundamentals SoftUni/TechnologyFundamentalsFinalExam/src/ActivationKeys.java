import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("&");

        String result = "";

        for (int i = 0; i < input.length; i++) {
            String code = input[i];

            if (onlyLettersAndNumbers(code)) {
                if (code.length() == 16) {
                    for (int j = 0; j < code.length(); j++) {
                        if (j % 4 == 0 && j != 0) {
                            result += "-";
                        }
                        result += code.charAt(j);
                    }
                    result += ", ";
                } else if (code.length() == 25) {
                    for (int j = 0; j < code.length(); j++) {
                        if (j % 5 == 0 && j != 0) {
                            result += "-";
                        }
                        result += code.charAt(j);
                    }
                    result += ", ";
                }
            }
        }

        String finalResult = result.replaceAll(", $", "");
        char[] changeChars = new char[0];

        for (int i = 0; i < finalResult.length(); i++) {
            finalResult = finalResult.toUpperCase();

            if (i == 0) {
                changeChars = finalResult.toCharArray();
            }

            if (Character.isDigit(finalResult.charAt(i))) {
                int num = finalResult.charAt(i) - '0';
                char updatedDigit = (char) (57 - num);

                changeChars[i] = updatedDigit;
                finalResult = String.valueOf(changeChars);

            }
        }
        System.out.println(finalResult);
    }

    private static boolean onlyLettersAndNumbers(String code) {
        for (int i = 0; i < code.length(); i++) {
            if (!Character.isLetterOrDigit(code.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
