import java.util.Scanner;

public class EnglishNameOfTheLastDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());

        englishNameLastDigit(a);

    }

    private static void englishNameLastDigit(int a) {
        if(a % 10 == 1) {
            System.out.println("one");
        } else if (a % 10 == 2) {
            System.out.println("two");
        } else if (a % 10 == 3) {
            System.out.println("three");
        } else if (a % 10 == 4) {
            System.out.println("four");
        } else if (a % 10 == 5) {
            System.out.println("five");
        } else if (a % 10 == 6) {
            System.out.println("six");
        } else if (a % 10 == 7) {
            System.out.println("seven");
        } else if (a % 10 == 8) {
            System.out.println("eight");
        } else if (a % 10 == 9) {
            System.out.println("nine");
        }
    }


}
