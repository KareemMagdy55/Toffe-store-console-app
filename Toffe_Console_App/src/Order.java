public class Order {
    private String id ;
    private String customerID;
    private String date ;
    private String products;
    private float totalPrice;
    private String status;

    public Order(String id, String customerID, String date, String products, float totalPrice, String status) {
        this.id = id;
        this.customerID = customerID;
        this.date = date;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }


}
