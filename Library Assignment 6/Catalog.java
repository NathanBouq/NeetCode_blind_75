package demo;

import java.util.Collection;
import java.util.HashMap;

public class Catalog {
    private HashMap<Double, Book> catalog;

    public void addBook(Book book) {
        double id = book.getID();
        catalog.put(id, book);
    }

    public void deleteBook(Book book) {
        double id = book.getID();
        catalog.remove(id);
    }

    public void deleteBook(double id) {
        catalog.remove(id);
    }

    public Book getBook(double id) { return catalog.get(id); }

    public Collection<Book> getAllBooks() { return catalog.values(); }

    public Catalog() {
        this.catalog = new HashMap<>();
    }
}
