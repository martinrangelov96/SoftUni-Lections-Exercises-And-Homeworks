import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        int firstDiagonalRow = 0;
        int firstDiagonalCol = 0;

        int secondDiagonalRow = 0;
        int secondDiagonalCol = matrix.length - 1;


        while (true) {
            firstDiagonalSum += matrix[firstDiagonalRow][firstDiagonalCol];
            secondDiagonalSum += matrix[secondDiagonalRow][secondDiagonalCol];

            firstDiagonalRow++;
            firstDiagonalCol++;
            secondDiagonalRow++;
            secondDiagonalCol--;
            if (firstDiagonalRow >= matrix.length || secondDiagonalCol < 0) {
                break;
            }
        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));

    }
}
