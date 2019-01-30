import java.util.Scanner;

public class FruitOrVegetable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fruitOrVegetable = scanner.nextLine();

        if (fruitOrVegetable.equals("banana") || fruitOrVegetable.equals("apple") || fruitOrVegetable.equals("kiwi") ||
                fruitOrVegetable.equals("lemon") || fruitOrVegetable.equals("grapes") || fruitOrVegetable.equals("cherry")) {
            System.out.println("fruit");
        } else if (fruitOrVegetable.equals("tomato") || fruitOrVegetable.equals("cucumber") ||
                fruitOrVegetable.equals("pepper") || fruitOrVegetable.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }

    }

}
