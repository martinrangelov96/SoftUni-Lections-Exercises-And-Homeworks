import java.util.Scanner;

public class PersonalTitles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);

        if (gender == 'f') {
            if (age < 16) {
                System.out.println("Miss");
            } else {
                System.out.println("Ms.");
            }
        } else if (gender == 'm') {
            if (age < 16) {
                System.out.println("Master");
            } else {
                System.out.println("Mr.");
            }
        } else {
            System.out.println("Erorr");
        }

    }

}
