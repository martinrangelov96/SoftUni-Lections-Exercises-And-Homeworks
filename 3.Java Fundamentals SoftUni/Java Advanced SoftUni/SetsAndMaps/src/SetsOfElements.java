import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nAndM = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = nAndM[0];
        int m = nAndM[1];

        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int nNumber = Integer.parseInt(scanner.nextLine());
            nSet.add(nNumber);
        }

        for (int i = 0; i < m; i++) {
            int mNumber = Integer.parseInt(scanner.nextLine());
            mSet.add(mNumber);
        }

        for (Integer nNumber : nSet) {
            for (Integer mNumber : mSet) {
                if (mNumber.equals(nNumber)) {
                    System.out.print(nNumber + " ");
                }
            }
        }

    }
}
