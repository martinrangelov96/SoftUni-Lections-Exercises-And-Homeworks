package exercise04_telephony;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {

    }

    @Override
    public String browseAWebSite(String webSite) {
        if (webSite.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Invalid URL!");
        }
        return String.format("Browsing: %s!", webSite);
    }

    @Override
    public String callANumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid number!");
        }
        return String.format("Calling... %s", phoneNumber);
    }
}
