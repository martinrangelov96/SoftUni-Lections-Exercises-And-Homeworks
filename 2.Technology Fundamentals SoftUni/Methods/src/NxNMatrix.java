import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixNumber = Integer.parseInt(scanner.nextLine());

        numbersMatrix(matrixNumber);

    }

    public static void numbersMatrix(int matrixNumber) {
        for (int i = 0; i < matrixNumber; i++) {
            for (int j = 0; j < matrixNumber; j++) {
                System.out.print(matrixNumber + " ");
            }
            System.out.println();
        }
    }

}
