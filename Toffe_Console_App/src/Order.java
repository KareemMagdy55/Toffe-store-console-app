/**
 * Represents an order placed by a customer.
 */
import java.util.ArrayList;
import java.util.Date;
public class Order {
    private final int id; // the unique identifier of the order
    private final int customerID; // the unique identifier of the customer who placed the order
    private final Date date; // the date the order was placed
    ArrayList<OrderedProduct> products; // the list of products ordered
    private final double totalPrice; // the total price of the order
    private final int status; // the status of the order (open or closed)

    /**
     * Constructs a new order object with the given parameters.
     * @param id the unique identifier of the order
     * @param customerID the unique identifier of the customer who placed the order
     * @param date the date the order was placed
     * @param products the list of products ordered
     * @param totalPrice the total price of the order
     * @param status the status of the order (open or closed)
     */
    public Order(int id, int customerID, Date date, ArrayList<OrderedProduct> products,
                 double totalPrice, int status) {
        this.id = id;
        this.customerID = customerID;
        this.date = date;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    /**
     * Returns a string representation of the order.
     * @return a string representation of the order
     */
    public String toString() {
        StringBuilder s = new StringBuilder(String.valueOf(id) + '\n' +
                customerID + '\n' +
                date.getTime() + '\n' +
                products.size() + '\n');
        for(OrderedProduct p : products){
            s.append(p.getID()).append(" ");
            s.append(p.getOrderedQuantity()).append("\n");
        }
        s.append(totalPrice).append("\n");
        s.append(status).append("\n");
        return s.toString();
    }

    /**
     * Prints a summary of the order.
     */
    public void print(){
        StringBuilder s = new StringBuilder(
                "Order ID: " + id + '\n' +
                "Date: " + date.toString() + '\n'
                );
        s.append("Number Of Products: ").append(products.size()).append('\n');
        s.append("Total Price: ").append(totalPrice).append("\n");
        s.append("Status: ");
        if(status == 1) s.append("Closed Order");
        else s.append("Open Order");
        System.out.println(s);
    }

    /**
     * Prints a detailed summary of the order, including the ordered items.
     */
    public void detailedPrint(){
        print();
        System.out.println("Ordered Items in This Order:");
        System.out.println("_".repeat(50));
        for(OrderedProduct p : products){
            p.printProduct();
            System.out.println("_".repeat(50));
        }
    }

    /**
     * Returns the unique identifier of the customer who placed the order.
     * @return the unique identifier of the customer who placed the order
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Returns the unique identifier of the order.
     * @return the unique identifier of the order
     */
    public int getId() {
        return id;
    }
}
