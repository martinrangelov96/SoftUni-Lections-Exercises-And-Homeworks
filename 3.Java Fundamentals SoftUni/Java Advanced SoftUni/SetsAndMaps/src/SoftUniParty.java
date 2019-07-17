import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String line = scanner.nextLine();

        while (!"PARTY".equals(line)) {
            guests.add(line);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!"END".equals(line)) {
            guests.remove(line);

            line = scanner.nextLine();
        }

        System.out.println(guests.size());

        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
