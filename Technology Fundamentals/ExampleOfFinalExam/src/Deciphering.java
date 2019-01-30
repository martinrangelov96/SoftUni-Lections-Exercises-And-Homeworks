import java.util.Scanner;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] replaceStrings = scanner.nextLine().split(" ");


        if (!text.matches("[d-z{}|#]+")) {
            System.out.println("This is not the book you are looking for.");
            return;
        }

        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length() ; i++) {
            char newChar = text.charAt(i);
            newChar -= 3;

            newText.append(newChar);
        }

        String finalText = "";

        String replaceThis = replaceStrings[0];
        String withThis = replaceStrings[1];


        finalText = newText.toString().replace(replaceThis,withThis);


        System.out.println(finalText);

    }
}
