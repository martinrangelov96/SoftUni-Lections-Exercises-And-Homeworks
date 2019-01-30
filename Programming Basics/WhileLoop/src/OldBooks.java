import java.util.Scanner;

public class OldBooks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String searchedBook = scanner.nextLine();
        int bookInLibrary = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (counter < bookInLibrary) {
            String findingBook = scanner.nextLine();
            if (searchedBook.equals(findingBook)) {
                System.out.printf("You checked %d books and found it.",counter);
                break;
            }

            counter++;
        }

        if (counter == bookInLibrary) {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", bookInLibrary);
        }

    }

}
