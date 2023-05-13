import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderHistory {
    ArrayList<Order> orders = new ArrayList<>();
    Customer customer;
    DataBase db;
    public OrderHistory(DataBase db, Customer customer){
        this.db = db;
        this.customer = customer;
        loadOrders(db, customer);
    }
    public void userInteract(){
        System.out.println("Your Order History: ");
        if(!showOrderHistory())
            return;
        String messageError = "Wrong Order ID, Try Again!";
        String reqMessage = "Type Order ID to show details or -1 to exit: ";
        System.out.print(reqMessage);
        while(true) {
            int orderChoice = Validator.takeIntChoice(-1, db.getLargestOrderID(), messageError + "\n" + reqMessage);
            boolean found = false;
            if (orderChoice == -1)
                return;
            for (Order order : orders) {
                if (order.getId() == orderChoice) {
                    order.detailedPrint();
                    System.out.println("_".repeat(50));
                    found = true;
                    break;
                }
            }
            if(!found)
                System.out.print(messageError + "\n" + reqMessage);
            else
                System.out.println(reqMessage);
        }
    }
    private void loadOrders(DataBase db, Customer customer){
        if(!orders.isEmpty())
            orders.clear();
        for (Order order : db.getOrders()) {
            if (order.getCustomerID() == customer.getID())
                orders.add(order);
        }
    }
    private boolean showOrderHistory(){
        if(orders.isEmpty()){
            System.out.println("Empty Order History, Go buy something!");
            return false;
        }
        for (Order order : orders){
            order.print();
            System.out.println("_".repeat(50));
        }
        return true;
    }
}
