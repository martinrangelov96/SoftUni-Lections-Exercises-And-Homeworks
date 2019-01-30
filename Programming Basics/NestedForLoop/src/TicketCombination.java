import java.util.Scanner;

public class TicketCombination {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int prize = 0;

        for (int i = 'B'; i <= 'L' ; i++) {
            for (int j = 'f'; j >= 'a' ; j--) {
                for (int k = 'A'; k <= 'C' ; k++) {
                    for (int l = 1; l <= 10 ; l++) {
                        for (int m = 10; m >= 1; m--) {
                            if (i % 2 == 0) {
                                counter++;
                                if (counter == number) {
                                    prize = i + j + k + l + m;
                                    System.out.printf("Ticket combination: %c%c%c%d%d%n",i,j,k,l,m);
                                    System.out.printf("Prize: %d lv.",prize);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
