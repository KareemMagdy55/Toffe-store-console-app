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
            s.append(p.getOrderedQuantity()).append("\n");
        }
        s.append(totalPrice).append("\n");
        s.append(status).append("\n");
        return s.toString();
    }
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
    public void detailedPrint(){
        print();
        System.out.println("Ordered Items in This Order:");
        System.out.println("_".repeat(50));
        for(OrderedProduct p : products){
            p.printProduct();
            System.out.println("_".repeat(50));
        }
    }
    public int getCustomerID() {
        return customerID;
    }

    public int getId() {
        return id;
    }
}
