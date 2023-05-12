import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class DataBase {
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public ArrayList<Product> products = new ArrayList<Product>();
    public ArrayList<Order> orders = new ArrayList<Order>();
    private static int largestOrderID;
    public static int getLargestOrderID() {
        return largestOrderID;
    }
    public static void increaseLargestOrderID() {
        largestOrderID++;
    }
    public DataBase() throws FileNotFoundException {
        loadCustomers();
        loadProducts();
        loadOrders();
    }
    private void loadCustomers() throws FileNotFoundException {
        File customersFile = new File("customersDB.txt");
        Scanner Reader = new Scanner(customersFile);
        while (Reader.hasNextLine()) {
            Customer tempCustomer = new Customer(
                    Integer.parseInt(Reader.nextLine()),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine(),
                    Reader.nextLine()
            );
            customers.add(tempCustomer);
        }
        Reader.close();
    }

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

    public void loadOrders() throws FileNotFoundException {
        File ordersFile = new File("ordersDB.txt");
        Scanner in = new Scanner(ordersFile);
        int orderId, custId, numberOfOrderedProducts, prodId, quntity, status, maxOrderID = -1;
        double totalPrice;
        Date date;
        ArrayList<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
        while (in.hasNextInt()) {
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

    public void saveOrders() throws IOException {
        File ordersFile = new File("ordersDB.txt");
        int fileLen = Math.toIntExact(Files.lines(ordersFile.toPath()).count());
        BufferedWriter writer = new BufferedWriter(new FileWriter("ordersDB", true));
        for (int i = fileLen; i < orders.size(); i++) {
            writer.write(orders.get(i).toString());
        }
        writer.close();
    }

    private Product getProductByID(String pid) {
        for (Product p : products) {
            if (Objects.equals(p.getID(), pid))
                return p;
        }
        return null;
    }
}
