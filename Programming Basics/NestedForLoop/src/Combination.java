import java.util.Scanner;

public class Combination {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int combinationsCounter = 0;

        for (int x1 = 0; x1 <= number; x1++) {
            for (int x2 = 0; x2 <= number ; x2++) {
                for (int x3 = 0; x3 <= number ; x3++) {
                    for (int x4 = 0; x4 <= number ; x4++) {
                        for (int x5 = 0; x5 <= number ; x5++) {
                            int sum = x1 + x2 + x3 + x4 + x5;
                            if (sum == number) {
                                combinationsCounter++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(combinationsCounter);

    }

}
