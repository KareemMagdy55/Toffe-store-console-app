import java.io.*;
import java.nio.file.Files;
import java.util.*;
public class DataBase {
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public ArrayList<Product> products = new ArrayList<Product>();
    public ArrayList<Order> orders = new ArrayList<Order>();

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
    public void saveCustomers() throws IOException {
        File customersFile = new File("customersDB.txt");
        Integer fileLen = Math.toIntExact((Files.lines(customersFile.toPath()).count()));
        fileLen = fileLen/ 6 ;

        for (int i = fileLen ; i < customers.size() - fileLen; i ++){
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("customersDB.txt", true));

            out.write(customers.get(i).makeString());
            out.close();
        }
    }
}
