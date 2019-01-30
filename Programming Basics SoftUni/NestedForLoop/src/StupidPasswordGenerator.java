import java.util.Scanner;

public class StupidPasswordGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int num1 = 1; num1 <= n ; num1++) {

            for (int num2 = 1; num2 <= n; num2++) {

                for (int letter1 = 'a'; letter1 < 'a' + l ; letter1++) {

                    for (int letter2 = 'a'; letter2 < 'a' + l; letter2++) {

                        for (int num3 = Math.max(num1, num2) + 1; num3 <= n ; num3++) {

                            System.out.printf("%d%d%c%c%d ",num1, num2, letter1, letter2, num3);

                        }
                        
                    }

                }
                
            }

        }

    }

}
