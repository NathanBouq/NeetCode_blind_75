package demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;  

public class Order {
    private double[] ids;
    private int quantity;
    
    // source:
    // https://www.javatpoint.com/java-get-current-date
    private String date;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

    public Order(double[] ids, Inventory inventory) {
        this.ids = ids;
        this.quantity = ids.length;
        
        LocalDateTime now = LocalDateTime.now();  
        this.date = formatter.format(now);

        inventory.placeOrder(ids);
    }
}


