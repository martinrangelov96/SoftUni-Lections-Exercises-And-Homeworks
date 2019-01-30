import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (validatePassword(password)) {
            System.out.println("Password is valid");
        }

    }

    public static boolean validatePassword(String p) {

        boolean correctCharCount = validateCount(p);
        boolean containsOnlyLettersAndDigits = validateContain(p);
        boolean haveTwoDigits = validateDigitsCount(p);

        return correctCharCount && containsOnlyLettersAndDigits && haveTwoDigits;

    }

    private static boolean validateDigitsCount(String p) {
        int digitCount = 0;
        for (int i = 0; i < p.length(); i++) {
            char digits = p.charAt(i);
            if (Character.isDigit(digits)) {
                digitCount++;
                if (digitCount >= 2) {
                    return true;
                }
            }
        }

        System.out.println("Password must have at least 2 digits");
        return false;

    }

    private static boolean validateContain(String p) {

        for (int i = 0; i < p.length(); i++) {
            char symbol = p.charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }

        return true;

    }

    public static boolean validateCount(String p) {
        boolean isValid = p.length() >= 6 && p.length() <= 10;

        if (!isValid) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }

        return true;

    }

}
