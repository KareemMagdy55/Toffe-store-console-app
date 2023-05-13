import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Represents a database of customers, products, and orders.
 */
public class DataBase {
    /** An ArrayList of all the customers in the database. */
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    /** An ArrayList of all the products in the database. */
    public ArrayList<Product> products = new ArrayList<Product>();
    /** An ArrayList of all the orders in the database. */
    public ArrayList<Order> orders = new ArrayList<Order>();
    /** The largest order ID in the database. */
    private int largestOrderID, largestCustomerID;

    /**
     * Gets the largest order ID in the database.
     *
     * @return the largest order ID in the database
     */
    public int getLargestOrderID() {
        return largestOrderID;
    }

    /**
     * Increases the largest order ID in the database by 1.
     */
    public void increaseLargestOrderID() {
        largestOrderID++;
    }

    /**
     * Creates a new instance of the database and loads customers, products, and orders from files.
     *
     * @throws FileNotFoundException if one of the required files is not found
     */
    public DataBase() throws FileNotFoundException {
        loadCustomers();
        loadProducts();
        loadOrders();
    }

    /**
     * Loads the customers from the customersDB.txt file into the database.
     *
     * @throws FileNotFoundException if the customersDB.txt file is not found
     */
    public void loadCustomers() throws FileNotFoundException {
        File customersFile = new File("customersDB.txt");
        Scanner Reader = new Scanner(customersFile);
        largestCustomerID = -1;
        while (Reader.hasNextLine()) {
            Customer tempCustomer = new Customer(
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine()
            );
            customers.add(tempCustomer);
            largestCustomerID = Math.max(largestCustomerID, Integer.parseInt(tempCustomer.id));
        }
        Reader.close();
    }

    public int getLargestCustomerID(){
        return largestCustomerID;
    }
    /**
     * Loads the products from the productsDB.txt file into the database.
     *
     * @throws FileNotFoundException if the productsDB.txt file is not found
     */
    private void loadProducts() throws FileNotFoundException {
        File customersFile = new File("productsDB.txt");
        Scanner Reader = new Scanner(customersFile);
        while (Reader.hasNextLine()) {
            Product tempProduct = new Product(
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Integer.parseInt(Reader.nextLine()),
                    Float.parseFloat(Reader.nextLine())
            );
            products.add(tempProduct);
        }
        Reader.close();
    }

    /**
     * Saves the customers in the database to the customersDB.txt file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void saveCustomers() throws IOException {
        File customersFile = new File("customersDB.txt");
        int fileLen = Math.toIntExact(Files.lines(customersFile.toPath()).count());
        fileLen = fileLen / 6;
        for (int i = fileLen; i < customers.size(); i++) {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("customersDB.txt", true));

            out.write(customers.get(i).makeString());
            out.close();
        }
    }

    /**
     * Loads the orders from the ordersDB.txt file into the database.
     *
     * @throws FileNotFoundException if the ordersDB.txt file is not found
     */
    /**
     * Loads orders data from a text file and populates the orders list.
     *
     * @throws FileNotFoundException if the orders file cannot be found
     */
    public void loadOrders() throws FileNotFoundException {
        if(!orders.isEmpty()) orders.clear();
        File ordersFile = new File("ordersDB.txt");
        Scanner in = new Scanner(ordersFile);
        int orderId, custId, numberOfOrderedProducts, prodId, quntity, status, maxOrderID = -1;
        double totalPrice;
        Date date;
        ArrayList<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
        while (in.hasNextInt()) {
            in.nextLine();
            orderedProducts.clear();
            orderId = in.nextInt();
            maxOrderID = Math.max(maxOrderID, orderId);
            custId = in.nextInt();
            date = new Date(in.nextLong());
            numberOfOrderedProducts = in.nextInt();
            for (int i = 0; i < numberOfOrderedProducts; i++) {
                prodId = in.nextInt();
                quntity = in.nextInt();
                orderedProducts.add(new OrderedProduct(Objects.requireNonNull(getProductByID(String.valueOf(prodId))), quntity));
            }
            totalPrice = in.nextDouble();
            status = in.nextInt();
            Order order = new Order(orderId, custId, date, orderedProducts, totalPrice, status);
            orders.add(order);
        }
        largestOrderID = maxOrderID;
        in.close();
    }

    public void addNewOrder(Order order) throws IOException {
        orders.add(order);
        increaseLargestOrderID();
        saveOrders();
    }

    /**
     * Saves orders data to a text file.
     *
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveOrders() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("ordersDB.txt", false));
        for (int i = 0; i < orders.size(); i++) {
            writer.write("\n");
            writer.write(orders.get(i).toString());
        }
        writer.close();
    }

    /**
     * Returns the Product object with the given ID.
     *
     * @param pid the ID of the product to retrieve
     * @return the Product object with the given ID, or null if no such product exists
     */
    private Product getProductByID(String pid) {
        for (Product p : products) {
            if (Objects.equals(p.getID(), pid))
                return p;
        }
        return null;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}

