import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(input[0]);
        String matrixType = input[1];

        printArray(matrixA(matrixSize));

    }

    public static int[][] matrixA(int matrixSize) {
        int[][] arrayA = new int[matrixSize][matrixSize];

        int currentNumber = 1;

        for (int row = 0; row < arrayA.length ; row++) {
            for (int col = 0; col < arrayA[0].length; col++) {
                arrayA[row][col] = currentNumber;
                currentNumber++;
            }
        }
        return arrayA;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length ; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }

}
