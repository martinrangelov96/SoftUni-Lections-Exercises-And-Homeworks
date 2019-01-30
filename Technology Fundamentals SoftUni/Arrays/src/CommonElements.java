import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");

        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < first.length; j++) {
                if (second[i].equals(first[j])) {
                    System.out.print(second[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}
