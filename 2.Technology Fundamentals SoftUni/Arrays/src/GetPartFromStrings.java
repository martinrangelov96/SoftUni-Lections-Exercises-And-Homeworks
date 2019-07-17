import java.util.Scanner;

public class GetPartFromStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] stuff = new String[size];

        while (true) {
            String positionCandidate = scanner.nextLine();
            if (positionCandidate.equals("END")) {
                break;
            }

            int position = Integer.parseInt(positionCandidate);
            String item = scanner.nextLine();
            stuff[position] = item;
        }

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            int position = Integer.parseInt(line);

            String item = stuff[position];
            System.out.println(item.substring(3));
            line = scanner.nextLine();
        }

    }
}
