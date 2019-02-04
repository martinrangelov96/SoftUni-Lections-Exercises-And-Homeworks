package exercise02_bookShop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected void setPrice(double price) {
        double goldenEditionBookPrice = price * 1.30;
        super.setPrice(goldenEditionBookPrice);
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Title: %s%n" +
                "Author: %s%n" +
                "Price: %.1f", this.getClass().getSimpleName(), this.getTitle(), this.getAuthor(), this.getPrice());
    }
}
