import java.util.ArrayList;
import java.util.Date;

public class Order {
    private final int id;
    private final int customerID;
    private final Date date;
    ArrayList<OrderedProduct> products;
    private final double totalPrice;
    private final int status;

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
                customerID + '\n' +
                date.getTime() + '\n' +
                products.size() + '\n');
        for(OrderedProduct p : products){
            s.append(p.getID()).append(" ");
            s.append(p.getOrderedQuantity());
        }
        s.append(totalPrice);
        s.append(status);
        return s.toString();
    }
}
