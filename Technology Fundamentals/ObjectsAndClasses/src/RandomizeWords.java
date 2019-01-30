import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(input.length);

        for (int i = 0; i < input.length - 1; i++) {
            String oldWord = input[i];
            input[i] = input[randomNumber];
            input[randomNumber] = oldWord;
        }

        for (String words : input) {
            System.out.println(words);
        }

    }
}
