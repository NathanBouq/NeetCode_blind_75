package demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<Double, ArrayList<Book>> inventory;

    public void placeOrder(double[] ids) {
        for ( double id : ids ) {
            if ( inventory.get(id).size() > 0 )
                inventory.get(id).remove(0);
            else {
                throw new NoSuchBookInInventoryException("Book with id "+id+" not found in inventory.");    
            }
        }
    }

    public void addBook(Book book) {
        double id = book.getID();
        if ( inventory.containsKey(id) ) {
            inventory.get(id).add(book);
        }
        else {
            ArrayList<Book> arrayList = new ArrayList<>();
            arrayList.add(book);
            inventory.put(id, arrayList);
        }
    }

    public double getQuantity(double id) {
        return inventory.get(id).size();
    }

    public Inventory() {
        this.inventory = new HashMap<>();
    }
    
}

class NoSuchBookInInventoryException extends RuntimeException {
    public NoSuchBookInInventoryException(String reason) {
        super(reason);
    }
}
