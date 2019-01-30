import java.util.Scanner;

public class ExchangeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = 0;

        System.out.println("Before:");
        System.out.println("a = " +a);
        System.out.println("b = " +b);

        c = a;
        a = b;
        b = c;

        System.out.println("After:");
        System.out.println("a = " +a);
        System.out.println("b = " +b);


    }
}
