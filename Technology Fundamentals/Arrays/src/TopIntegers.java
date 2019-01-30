import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split(" ");
        int[] inputInt = new int[inputString.length];

        for (int i = 0; i < inputString.length; i++) {
            inputInt[i] = Integer.parseInt(inputString[i]);
        }

        int lastNum = inputInt[inputInt.length-1];

        boolean isBigger = false;

        for (int i = 0; i < inputInt.length - 1; i++) {
            for (int j = i; j < inputInt.length - 1; j++) {
                if (inputInt[i] > inputInt[j + 1]) {
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(inputInt[i] + " ");
            }
        }

        System.out.print(lastNum);

    }
}
