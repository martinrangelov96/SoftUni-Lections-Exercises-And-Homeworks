package lection01_constructors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public Book(String title, int year, String... values) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>();

        Collections.addAll(this.authors, values);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Author(name = "Pesho")
    private String print() {
        return this.title + " method";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Title: ")
                .append(this.title)
                .append(" year: ")
                .append(this.year)
                .append(" Authors: ")
                .append(String.join(", ", this.authors));

        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        if (this.title.compareTo(o.title) == 0) {
            return Integer.compare(this.year, o.year);
        }

        return this.title.compareTo(o.title);
    }
}
