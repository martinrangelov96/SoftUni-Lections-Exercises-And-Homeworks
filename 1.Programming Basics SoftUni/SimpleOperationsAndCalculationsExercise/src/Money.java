import java.util.Scanner;

public class Money {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double chineseYen = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        int bitcoinToLeva = 1168;
        double bitcoinToEuro = bitcoinToLeva/1.95;

        double chineseYenToDollar = 0.15;
        double chineseYenToLeva = chineseYenToDollar * 1.76;

        double chineseYenToEuro = chineseYenToLeva / 1.95;

        double euroHeCanGetNoCommision = ((bitcoins * bitcoinToEuro) + (chineseYen * chineseYenToEuro));
        double commisionCalculated = (commission/100) * euroHeCanGetNoCommision;
        double finalEuro = euroHeCanGetNoCommision - commisionCalculated;

        System.out.println(finalEuro);

    }

}
