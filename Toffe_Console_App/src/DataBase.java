import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DataBase {
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public ArrayList<Product> products = new ArrayList<Product>();


    public DataBase() throws FileNotFoundException {
        loadCustomers();
        loadProducts();

    }
    private void loadCustomers() throws FileNotFoundException {
        File customersFile = new File("customersDB.txt");
        Scanner Reader = new Scanner(customersFile);
        while (Reader.hasNextLine()) {
            Customer tempCustomer = new Customer(
                    Integer.parseInt( Reader.nextLine()),
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
                    Integer.parseInt( Reader.nextLine()),
                    Float.parseFloat( Reader.nextLine())
                    );
            products.add(tempProduct);
        }
        Reader.close();
    }
}
