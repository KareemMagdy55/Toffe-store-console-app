import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int id;
    private int customerID;
    private Date date;
    ArrayList<OrderedProduct> products;
    private double totalPrice;
    private int status;

    public Order(int id, int customerID, Date date, ArrayList<OrderedProduct> products,
                 double totalPrice, int status) {
        this.id = id;
        this.customerID = customerID;
        this.date = date;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(String.valueOf(id) + '\n' +
                String.valueOf(customerID) + '\n' +
                String.valueOf(date.getTime()) + '\n' +
                String.valueOf(products.size()) + '\n');
        for(OrderedProduct p : products){
            s.append(String.valueOf(p.getID())).append(" ");
            s.append(String.valueOf(p.getOrderedQuantity()));
        }
        s.append(totalPrice);
        s.append(status);
        return s.toString();
    }
}
