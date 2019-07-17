import java.util.*;
import java.util.stream.Collectors;

public class BakingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        double maxAverage = Integer.MIN_VALUE;
        double bestArrayAverageSum = 0;
        double tiedBestArrayAverageSum = 0;
        boolean sameQualityCheck = false;

        List<Integer> bestArray = new ArrayList<>();
        List<Integer> tiedBestArray = new ArrayList<>();

        while (!input.equals("Bake It!")) {

            List<String> breads = Arrays.stream(input.split("#")).collect(Collectors.toList());

            for (int i = 0; i < breads.size(); i++) {
                sum += Integer.valueOf(breads.get(i));
            }

            if (sum > maxSum) {
                bestArray = new ArrayList<>();
                maxSum = sum;
                for (int i = 0; i < breads.size(); i++) {
                    bestArray.add(i, Integer.parseInt(breads.get(i)));
                }
            } else if (sum == maxSum) {
                sameQualityCheck = true;
                for (int i = 0; i < breads.size(); i++) {
                    tiedBestArray.add(i, Integer.parseInt(breads.get(i)));
                }
                bestArrayAverageSum = bestArray.stream().mapToInt(Integer::intValue).sum() * 1.0 / bestArray.size();
                tiedBestArrayAverageSum = tiedBestArray.stream().mapToInt(Integer::intValue).sum() * 1.0 / tiedBestArray.size();

            }

            sum = 0;

            input = scanner.nextLine();
        }

        if (sameQualityCheck) {
            System.out.printf("Best Batch quality: %d%n", maxSum);
            if (bestArrayAverageSum > tiedBestArrayAverageSum) {
                for (int bestAverageNums : bestArray) {
                    System.out.print(bestAverageNums + " ");
                }
            } else if (tiedBestArrayAverageSum > bestArrayAverageSum) {
                for (int bestAverageNums : tiedBestArray) {
                    System.out.print(bestAverageNums + " ");
                }
            } else {
                if (bestArray.size() < tiedBestArray.size()) {
                    for (int bestAverageNums : bestArray) {
                        System.out.print(bestAverageNums + " ");
                    }
                } else {
                    for (int bestAverageNums : tiedBestArray) {
                        System.out.print(bestAverageNums + " ");
                    }
                }
            }
        } else {
            System.out.printf("Best Batch quality: %d%n", maxSum);
            for (int bestNums : bestArray) {
                System.out.print(bestNums + " ");
            }
        }
    }
}
