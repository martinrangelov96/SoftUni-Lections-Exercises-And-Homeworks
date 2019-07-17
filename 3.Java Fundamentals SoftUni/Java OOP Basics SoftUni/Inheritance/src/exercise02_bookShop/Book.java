package exercise02_bookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    protected String getTitle() {
        return this.title;
    }

    protected String getAuthor() {
        return this.author;
    }

    protected double getPrice() {
        return this.price;
    }

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        for (int i = 0; i < author.length(); i++) {
            if (Character.isDigit(author.charAt(i))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }


    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Title: %s%n" +
                "Author: %s%n" +
                "Price: %.1f%n", this.getClass().getSimpleName(), this.getTitle(), this.getAuthor(), this.getPrice());
    }
}
