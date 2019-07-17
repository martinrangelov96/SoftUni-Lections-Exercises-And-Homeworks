import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColumns = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(rowsAndColumns[0]);
        int cols = Integer.parseInt(rowsAndColumns[1]);

        int[][] matrixNumbers = new int[rows][cols];
        for (int row = 0; row < rows ; row++) {
            String[] matrix = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrixNumbers[row][col] = Integer.parseInt(matrix[col]);
            }
        }

        int sum = 0;
        int bestSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;

        for (int row = 0; row < matrixNumbers.length - 2; row++) {
            for (int col = 0; col < matrixNumbers[row].length - 2 ; col++) {
                sum = matrixNumbers[row][col] + matrixNumbers[row][col+1] + matrixNumbers[row][col+2]
                        +matrixNumbers[row + 1][col] + matrixNumbers[row + 1][col + 1] + matrixNumbers[row + 1][ col + 2]
                        + matrixNumbers[row + 2][col] + matrixNumbers[row + 2][col + 1] + matrixNumbers[row + 2][ col + 2];
                if (sum > bestSum) {
                    bestSum = sum;
                    rowIndex = row;
                    colIndex = col;
                }
            }

        }

        System.out.println("Sum = " +bestSum);
        System.out.println(matrixNumbers[rowIndex][colIndex] + " " + matrixNumbers[rowIndex][colIndex + 1] + " " + matrixNumbers[rowIndex][colIndex + 2]);
        System.out.println(matrixNumbers[rowIndex + 1][colIndex] + " " + matrixNumbers[rowIndex + 1][colIndex + 1] + " " + matrixNumbers[rowIndex + 1][colIndex + 2]);
        System.out.println(matrixNumbers[rowIndex + 2][colIndex] + " " + matrixNumbers[rowIndex + 2][colIndex + 1] + " " + matrixNumbers[rowIndex + 2][colIndex + 2]);
    }
}
