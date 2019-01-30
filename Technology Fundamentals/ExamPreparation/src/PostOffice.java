import java.util.Scanner;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split("\\|");

        String firstPart = parts[0];
        String secondPart = parts[1];
        String thirdPart = parts[2];

        String capitalLetters = "";

        for (int i = 0; i < firstPart.length() ; i++) {
            char symbol = firstPart.charAt(i);

            //"#, $, %, *, &"
            if (symbol == '#' || symbol == '$' || symbol == '%'
                || symbol == '*' || symbol == '&') {

                int index = firstPart.indexOf(symbol, i+1);

                if (index != -1) {
                    capitalLetters = firstPart.substring(i+1, index);

                }
            }
        }

        String[] words = thirdPart.split("\\s+");

        for (int i = 0; i < capitalLetters.length() ; i++) {
            String asciiCode = (int)capitalLetters.charAt(i) + "";

            int index = secondPart.indexOf(asciiCode);

            int length = 0;

            while (index != -1) {

                char firstSymbol = secondPart.charAt(index + 3);
                char secondSymbol = secondPart.charAt(index + 4);

                if (Character.isDigit(firstSymbol) && Character.isDigit(secondSymbol)) {
                    length = Integer.parseInt(secondPart.substring(index + 3, index + 5));
                    index = -1;
                } else {
                    index = secondPart.indexOf(asciiCode, index + 1);
                }
            }

            char capital = capitalLetters.charAt(i);

            for (int j = 0; j < words.length ; j++) {
                if (words[j].charAt(0) == capital && words[j].length() == length + 1) {
                    System.out.println(words[j]);
                    break;
                }
            }

        }

    }
}
