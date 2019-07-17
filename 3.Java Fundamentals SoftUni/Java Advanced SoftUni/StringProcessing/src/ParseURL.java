import java.util.Scanner;

public class ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] url = scanner.nextLine().split("://");

        if (url.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = url[0];
        String server = url[1].substring(0, url[1].indexOf("/"));
        String resources = url[1].substring(url[1].indexOf("/") + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);


    }
}
