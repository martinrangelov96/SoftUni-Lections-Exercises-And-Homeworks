import java.util.Scanner;

public class html {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleTitle = scanner.nextLine();
        String articleContent = scanner.nextLine();

        StringBuilder htmlString = new StringBuilder();
        htmlString.append(String.format("<h1>%n %s%n</h1>%n", articleTitle));
        htmlString.append(String.format("<article>%n %s%n</article>%n", articleContent));

        String articleComments = scanner.nextLine();

        while (!articleComments.equals("end of comments")) {
            htmlString.append(String.format("<div>%n %s%n</div>%n", articleComments));

            articleComments = scanner.nextLine();
        }

        System.out.println(htmlString);

    }
}
