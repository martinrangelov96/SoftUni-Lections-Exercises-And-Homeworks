import java.util.Scanner;

public class Fishing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int quota = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int fishes = 0;
        double win = 0.0;

        while(!input.equals("Stop")) {
            fishes++;
            String name = input;
            double kg = Double.parseDouble(scanner.nextLine());
            double price = 0;
            for (int i = 0; i < name.length(); i++) {
                price += (int)name.charAt(i);
            }

            if (fishes % 3 ==0) {
                win += (price / kg);
            } else {
                win -= (price / kg);
            }
            if (fishes == quota) {
                break;
            }
            input = scanner.nextLine();
        }

        if (fishes == quota) {
            System.out.println("Lyubo fulfilled the quota!");
        }

        if (win < 0) {
            System.out.printf("Lyubo lost %.2f leva today.",Math.abs(win));
        } else {
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.",fishes, win);
        }

    }

}
