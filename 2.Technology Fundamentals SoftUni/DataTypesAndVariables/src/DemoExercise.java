import java.util.Scanner;

public class DemoExercise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        str1 += scanner.nextLine();
        str1 += scanner.nextLine();

        String result = "";

        for (int i = str1.length() - 1; i >= 0 ; i--) {
            result += str1.charAt(i);
            System.out.print(result + " ");
            result = "";
        }


    }
}
