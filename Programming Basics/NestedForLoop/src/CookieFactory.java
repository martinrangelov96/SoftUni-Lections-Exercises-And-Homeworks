import java.util.Scanner;

public class CookieFactory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int batch = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= batch; i++) {
            boolean flour = false;
            boolean eggs = false;
            boolean sugar = false;
            String component = scanner.nextLine();
            while (!(component.equals("Bake!") && flour && sugar && eggs)) {

                if (component.equals("Bake!")) {
                    System.out.println("The batter should contain flour, eggs and sugar!");
                }

                switch (component) {
                    case "flour" : flour = true;
                    break;
                    case "eggs" : eggs = true;
                    break;
                    case "sugar" : sugar = true;
                    break;
                    default: break;
                }
                component = scanner.nextLine();
            }

            System.out.printf("Baking batch number %d...%n",i);

        }

    }

}
