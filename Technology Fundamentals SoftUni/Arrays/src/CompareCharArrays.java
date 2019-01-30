import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstText = scanner.nextLine();
        String[] firstTextArray = firstText.split(" ");
        int firstLength = firstTextArray.length;

        char[] first = new char[firstLength];

        for (int i = 0; i < first.length ; i++) {
            first[i] = firstTextArray[i].charAt(0);
        }

        String secondText = scanner.nextLine();
        String[] secondTextArray = secondText.split(" ");
        int secondLength = secondTextArray.length;

        char[] second = new char[secondLength];

        for (int i = 0; i < second.length ; i++) {
            second[i] = secondTextArray[i].charAt(0);
        }

        int smallestLength = Math.min(first.length, second.length);

        char[] smallest = first.length <= second.length
                ? first
                : second;

        char[] biggest = first.length > second.length
                ? first
                : second;

        for (int i = 0; i < smallestLength; i++) {
            if (first[i] < second[i]) {
                break;
            }
            if (second[i] < first[i]) {
                smallest = second;
                biggest = first;
                break;
            }
        }

        for (int i = 0; i < smallest.length; i++) {
            System.out.print(smallest[i]);
        }
        System.out.println();
        for (int i = 0; i < biggest.length; i++) {
            System.out.print(biggest[i]);
        }
    }
}
