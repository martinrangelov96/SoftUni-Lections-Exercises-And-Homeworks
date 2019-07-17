import java.util.Scanner;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();

        StringBuilder output = new StringBuilder();
        int multiplyTimes = 0;
        StringBuilder finalOutput = new StringBuilder();
        int uniqueSymbolCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                if (!finalOutput.toString().contains(Character.toString(input.charAt(i)))) {
                    uniqueSymbolCounter++;
                }
                output.append(input.charAt(i));
            } else {
                multiplyTimes = input.charAt(i) - '0';
                if (multiplyTimes == 0) {
                    for (int j = 0; j < output.length() ; j++) {
                        uniqueSymbolCounter--;
                    }
                }
                if (i < input.length() - 1) {
                    if (Character.isDigit(input.charAt(i + 1))) {
                        i++;
                        uniqueSymbolCounter--;
                        String wholeNumber = "";
                        wholeNumber = String.valueOf(multiplyTimes + "" + (input.charAt(i) - '0'));
                        multiplyTimes = Integer.parseInt(wholeNumber);
                    }
                }
                for (int j = 0; j < multiplyTimes; j++) {
                    finalOutput.append(output.toString().toUpperCase());
                }
                output = new StringBuilder();
            }
        }

        System.out.println("Unique symbols used: " + uniqueSymbolCounter);
        System.out.println(finalOutput);

    }
}
