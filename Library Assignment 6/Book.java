package demo;

public class Book {
    private double id;
    private String title;
    private String author;
    private int year;

    public double getID() { return this.id; }

    public Book(double id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

