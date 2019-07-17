package exercise02_bookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String authorName = reader.readLine();
        String bookName = reader.readLine();
        double price = Double.parseDouble(reader.readLine());

        Book book = null;

        try {
            book = new Book(authorName, bookName, price);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        GoldenEditionBook goldenEditionBook = null;
        try {
            goldenEditionBook = new GoldenEditionBook(authorName, bookName, price);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        System.out.println(book.toString());
        if (goldenEditionBook!= null) {
            System.out.println(goldenEditionBook.toString());
        }


    }
}