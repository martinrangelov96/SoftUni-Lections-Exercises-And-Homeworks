import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == '>') {
                result += symbol;
                i++;
                int explosion = text.charAt(i) - '0';
                explosion--;

                while (explosion > 0 && i < text.length() - 1) {
                    i++;
                    symbol = text.charAt(i);
                    if (symbol == '>') {
                        result += symbol;
                        i++;
                        explosion += text.charAt(i) - '0';
                        explosion--;
                        continue;
                    }
                    explosion--;
                }


            } else {
                result += symbol;
            }
        }

        System.out.println(result);

    }
}
