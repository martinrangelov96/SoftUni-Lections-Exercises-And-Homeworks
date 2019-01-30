import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());

        int vowelSum = 0;
        int[] nonSortedArray = new int[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            vowelSum = 0;
            String nameAsString = scanner.nextLine();
            char[] chars = nameAsString.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u'
                        || chars[j] == 'A' || chars[j] == 'E' || chars[j] == 'I' || chars[j] == 'O' || chars[j] == 'U') {
                    vowelSum += chars[j] * nameAsString.length();
                } else {
                    vowelSum += chars[j] / nameAsString.length();
                }
            }
            nonSortedArray[i] = vowelSum;
        }

        int[] sortedArray = new int[nonSortedArray.length];
        int temp;
        for (int j = 0; j < nonSortedArray.length - 1; j++) {
            for (int i = 0; i < nonSortedArray.length - 1; i++) {
                if (nonSortedArray[i] > nonSortedArray[i + 1]) {
                    temp = nonSortedArray[i];
                    nonSortedArray[i] = nonSortedArray[i + 1];
                    nonSortedArray[i + 1] = temp;
                    sortedArray = nonSortedArray;
                }
            }
        }

        System.out.println();

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }

        System.out.println();

    }
}
