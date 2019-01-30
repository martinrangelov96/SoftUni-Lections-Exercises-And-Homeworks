import java.util.Scanner;

public class Coding {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String length = String.valueOf(String.valueOf(number).length());
        int numberLength = Integer.parseInt(length);
        int numToPrint = 0;

        for (int i = 0; i < numberLength; i++) {
            numToPrint = number % 10;
            if (numToPrint == 0) {
                System.out.print("ZERO");
            }
            for (int j = 0; j < numToPrint; j++) {

                int printCharAscii = numToPrint + 33;
                System.out.print((char)printCharAscii);

            }
            number = number / 10;
            System.out.println();
        }

    }

}
