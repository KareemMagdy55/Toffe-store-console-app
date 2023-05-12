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

    /**
     * Class constructor that initializes the username and password fields
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     */
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
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
    private boolean validate() throws FileNotFoundException {
        DataBase DB = new DataBase();
        for (Customer c : DB.customers) {
            if (username.equals(c.name)) {
                System.out.println("Correct credentials!");
                return true;
            }
        }
        System.out.println("Incorrect credentials!");
        return false;
    }
}