import java.util.Scanner;

public class NumberPyramid {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int jCounter = 1;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                if (jCounter <= number) {
                    System.out.print(jCounter + " ");
                    jCounter++;
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }

}
