package task04_telephony;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {
    }

    @Override
    public void browse(String url) {
        if (url.matches(".*\\d.*")) {
            System.out.println("Invalid URL!");
        } else {
            System.out.println(System.out.printf("Browsing: %s!", url));
        }
    }

    @Override
    public void call(String number) {
        if (!number.matches(".*\\d.*")) {
            System.out.println("Invalid number!");
        } else {
            System.out.println(String.format("Calling... %s", number));
        }
    }
}
