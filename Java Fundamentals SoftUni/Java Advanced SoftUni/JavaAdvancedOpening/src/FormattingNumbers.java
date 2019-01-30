import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputs = input.split("\t");

        int a = Integer.parseInt(inputs[0]);
        String aHex = Integer.toHexString(a).toUpperCase();
        String aBin = Integer.toBinaryString(a);
        String aBinZeros = String.format("%10s", aBin).replace(' ', '0');
        double b = Double.parseDouble(inputs[1]);
        double c = Double.parseDouble(inputs[2]);

        System.out.print(String.format("%s%-10s" , "|", aHex ));
        System.out.print(String.format("%s%10s", "|", aBinZeros + "|"));
        System.out.print(String.format("%-5s%.2f" , "", b));
        System.out.print("|");
        System.out.print(String.format("%.3f%1s",c, " "));
        System.out.print("|");



    }
}
