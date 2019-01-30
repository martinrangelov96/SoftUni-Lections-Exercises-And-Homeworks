import java.util.ArrayList;
import java.util.Scanner;

class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Article> articles = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];

            Article article = new Article(title, content, author);

            articles.add(article);

        }

        String input = scanner.nextLine();

        if (input.equals("title")) {
            articles.stream().sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                    .forEach(t -> System.out.printf("%s - %s: %s%n", t.getTitle(), t.getContent(), t.getAuthor()));
        } else if (input.equals("content")) {
            articles.stream().sorted((a, b) -> a.getContent().compareTo(b.getContent()))
                    .forEach(c -> System.out.printf("%s - %s: %s%n", c.getTitle(), c.getContent(), c.getAuthor()));
        } else {
            articles.stream().sorted((a, b) -> a.getAuthor().compareTo(b.getAuthor()))
                    .forEach(a -> System.out.printf("%s - %s: %s%n", a.getTitle(), a.getContent(), a.getAuthor()));
        }

    }
}

