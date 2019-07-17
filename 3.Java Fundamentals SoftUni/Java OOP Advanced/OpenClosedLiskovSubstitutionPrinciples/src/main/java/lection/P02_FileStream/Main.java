package lection.P02_FileStream;

public class Main {
    public static void main(String[] args) {

        StreamProgressInfo spi = new StreamProgressInfo(new Music(100, 20));
        StreamProgressInfo spi2 = new StreamProgressInfo(new File(150, 45));

        System.out.println(spi.calculateCurrentPercent());
        System.out.println(spi2.calculateCurrentPercent());

    }
}
