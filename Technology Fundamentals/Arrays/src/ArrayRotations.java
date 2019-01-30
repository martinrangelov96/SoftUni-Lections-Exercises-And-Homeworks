import java.util.Scanner;

public class ArrayRotations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strNumbers = scanner.nextLine().split(" ");

        int rotations = Integer.parseInt(scanner.nextLine());

        rotations = rotations % strNumbers.length;

        for (int i = 0; i < rotations; i++) {
            String element = strNumbers[0];
            for (int j = 0; j <strNumbers.length - 1; j++) {
                strNumbers[j] = strNumbers[j+1];
            }
            strNumbers[strNumbers.length - 1] = element;
        }

        for (String str : strNumbers) {
            System.out.print(str + " ");
        }
        System.out.println();

    }
}
