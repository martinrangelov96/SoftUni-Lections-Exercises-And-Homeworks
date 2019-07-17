import java.util.Scanner;

public class AreaOfTriangleCoordinate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numsA = scanner.nextLine();
        String[] sidesA = numsA.split(" ");

        int Ax = Integer.parseInt(sidesA[0]);
        int Ay = Integer.parseInt(sidesA[1]);

        String numsB = scanner.nextLine();
        String[] sidesB = numsB.split(" ");
        int Bx = Integer.parseInt(sidesB[0]);
        int By = Integer.parseInt(sidesB[1]);

        String numsC = scanner.nextLine();
        String[] sidesC = numsC.split(" ");
        int Cx = Integer.parseInt(sidesC[0]);
        int Cy = Integer.parseInt(sidesC[1]);

        int area = Math.abs(Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By));
        int finalArea = area / 2;

        System.out.println(finalArea);

    }
}
