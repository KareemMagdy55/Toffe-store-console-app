import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ToffeeApp {
    boolean isLoggedUser = false;
    Register register;
    Catalog catalog;
    Login login;
    DataBase db;
    ShippingCart cart;
    Customer customer;
    OrderHistory orderHistory;
    public ToffeeApp() throws FileNotFoundException {
        db = new DataBase();
        catalog = new Catalog();
        cart = new ShippingCart();
    }
    public void runApp() throws IOException {
        showWelcomeInterface();
        int choice = Validator.takeIntChoice(0, 3 + (isLoggedUser ? 3 : 0));
        if (choice == 1) {
            if (isLoggedUser)
                System.out.println("Already Logged In");
            else
                showLoginInterface();
        } else if (choice == 2) {
            if (isLoggedUser)
                System.out.println("Already Logged In");
            else
                showRegisterInterface();
        } else if (choice == 3) {
            catalog.display();
            if (isLoggedUser) {
                int payOrExit = chooseProductToCart();
                while (payOrExit == 2) {
                    payOrExit = chooseProductToCart();
                }
                if (payOrExit == 1) {
                    cart.userInteract(customer.getID(), db);
                } else if (payOrExit == 0)
                    ;
            } else
                System.out.println("Login to add items to your cart!");
        } else if (choice == 4) {
            cart.userInteract(customer.getID(), db);
        } else if (choice == 5) {
            orderHistory = new OrderHistory(db, customer);
            orderHistory.userInteract();
        } else if (choice == 6) {
            isLoggedUser = false;
            customer = null;
            cart = new ShippingCart();
        } else if (choice == 0)
            return;
        System.out.println("_".repeat(50));
        runApp();
    }
    private int chooseProductToCart() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String productName;
        System.out.println("Write product name to add to your shipping cart: ");
        System.out.println("(Write 1 to go to shipping cart or 0 to go back)");
        productName = in.nextLine();
        if (Objects.equals(productName, "1"))
            return 1;
        else if (Objects.equals(productName, "0"))
            return 0;
        Product productToAdd = catalog.search(productName);
        if (productToAdd != null) {
            if (cart.addToCart(productToAdd))
                System.out.println(productToAdd.getName() + " Product added successfully to cart");
            else
                System.out.println("Sorry out of stuck!");
        }
        return 2;
    }
    private void showLoginInterface() throws IOException {
        Scanner in = new Scanner(System.in);
        String username, password;
        System.out.print("UserName: ");
        username = in.nextLine();
        System.out.print("Password: ");
        password = in.nextLine();
        login = new Login(username, password);
        if (!login.validate())
            runApp();
        else {
            isLoggedUser = true;
            customer = login.getCustomer();
        }
    }
    private void showRegisterInterface() throws FileNotFoundException {
        register = new Register();
        System.out.print("Name: ");
        register.setName();
        System.out.print("Email: ");
        register.setEmail();
        System.out.print("Password: ");
        register.setPassword();
        System.out.print("Address: ");
        register.setAddress();
        System.out.print("Phone Number: ");
        register.setPhoneNum();
        register.saveCustomer();
        isLoggedUser = true;
        db = new DataBase();
        login = new Login(register.getName(), register.getPass());
        customer = login.getCustomer();
        System.out.println("Registration is completed successfully, You can buy products now!");
    }
    private void showWelcomeInterface() {
        if (isLoggedUser)
            System.out.println("Hello, " + customer.getName());
        System.out.println("Welcome to Toffee Store!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Show Catalog");
        if (isLoggedUser) {
            System.out.println("4. Shipping Cart");
            System.out.println("5. Order History");
            System.out.println("6. Log Out");
        }
        System.out.println("0. Exit");
    }
}
