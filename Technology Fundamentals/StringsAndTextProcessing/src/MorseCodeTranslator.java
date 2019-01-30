import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] morseInput = scanner.nextLine().split(" ");

        StringBuilder newMorseInput = new StringBuilder();

        for (String aMorseInput : morseInput) {
            if (!aMorseInput.equals("|")) {
                if (aMorseInput.equals(".-")) {
                    newMorseInput.append("A");
                } else if (aMorseInput.equals("-...")) {
                    newMorseInput.append("B");
                } else if (aMorseInput.equals("-.-.")) {
                    newMorseInput.append("C");
                } else if (aMorseInput.equals("-..")) {
                    newMorseInput.append("D");
                } else if (aMorseInput.equals(".")) {
                    newMorseInput.append("E");
                } else if (aMorseInput.equals("..-.")) {
                    newMorseInput.append("F");
                } else if (aMorseInput.equals("--.")) {
                    newMorseInput.append("G");
                } else if (aMorseInput.equals("....")) {
                    newMorseInput.append("H");
                } else if (aMorseInput.equals("..")) {
                    newMorseInput.append("I");
                } else if (aMorseInput.equals(".---")) {
                    newMorseInput.append("J");
                } else if (aMorseInput.equals("-.-")) {
                    newMorseInput.append("K");
                } else if (aMorseInput.equals(".-..")) {
                    newMorseInput.append("L");
                } else if (aMorseInput.equals("--")) {
                    newMorseInput.append("M");
                } else if (aMorseInput.equals("-.")) {
                    newMorseInput.append("N");
                } else if (aMorseInput.equals("---")) {
                    newMorseInput.append("O");
                } else if (aMorseInput.equals(".--.")) {
                    newMorseInput.append("P");
                } else if (aMorseInput.equals("--.-")) {
                    newMorseInput.append("Q");
                } else if (aMorseInput.equals(".-.")) {
                    newMorseInput.append("R");
                } else if (aMorseInput.equals("...")) {
                    newMorseInput.append("S");
                } else if (aMorseInput.equals("-")) {
                    newMorseInput.append("T");
                } else if (aMorseInput.equals("..-")) {
                    newMorseInput.append("U");
                } else if (aMorseInput.equals("...-")) {
                    newMorseInput.append("V");
                } else if (aMorseInput.equals(".--")) {
                    newMorseInput.append("W");
                } else if (aMorseInput.equals("-..-")) {
                    newMorseInput.append("X");
                } else if (aMorseInput.equals("-.--")) {
                    newMorseInput.append("Y");
                } else if (aMorseInput.equals("--..")) {
                    newMorseInput.append("Z");
                }
            } else {
                newMorseInput.append(" ");
            }
        }

        System.out.println(newMorseInput);

    }
}
