import java.io.FileNotFoundException;

/**
 * This class is responsible for user login functionality
 */
public class Login {

    /**
     * The username entered by the user
     */
    String username;
    /**
     * The password entered by the user
     */
    String password;
    Customer customer;
    DataBase DB;

    /**
     * Class constructor that initializes the username and password fields
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     */
    public Login(String username, String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
        DB = new DataBase();
        customer = findCustomer();
    }

    /**
     * Set the username for the login object
     *
     * @param username the username entered by the user
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * Set the password for the login object
     *
     * @param password the password entered by the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Validates the user's credentials by checking if the username exists in the database
     *
     * @return true if the user's credentials are correct, false otherwise
     * @throws FileNotFoundException if the database file is not found
     */
    public boolean validate() throws FileNotFoundException {
        for (Customer c : DB.customers) {
            if (username.equals(c.name) && password.equals(c.password)) {
                System.out.println("Correct credentials!");
                customer = c;
                return true;
            }
        }
        System.out.println("Incorrect credentials!");
        return false;
    }
    public Customer getCustomer(){
        return customer;
    }

    private Customer findCustomer() throws FileNotFoundException {
        for (Customer c : DB.customers) {
            if (username.equals(c.name) && password.equals(c.password)) {
                return c;
            }
        }
        return null;
    }
}