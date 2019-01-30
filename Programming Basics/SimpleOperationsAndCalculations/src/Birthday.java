import java.util.Scanner;

public class Birthday {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double percentageOfStuff = Double.parseDouble(scanner.nextLine());

        double aquariumCapacity = (length * width * height);
        double litersThatCanAssemble = (aquariumCapacity * 0.001);
        double calculatedPercentage = (percentageOfStuff*0.01);

        double finalResult = litersThatCanAssemble*(1-calculatedPercentage);

        System.out.println(String.format("%.3f",finalResult));

    }

}
