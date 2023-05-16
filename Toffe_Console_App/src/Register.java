/**

 The Register class is responsible for registering new customers and saving their information in the database.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class Register {
    Customer customer;
    DataBase db;
    /**
     * Creates a new instance of Register and increments the counter to assign a new ID to the customer.
     */
    Register() throws FileNotFoundException {
        db = new DataBase();
        customer = new Customer();
        customer.id = String.valueOf(db.getLargestCustomerID() + 1);
    }

    /**
     * Sets the name of the customer by taking input from the user and validating it.
     */
    public void setName(){
        Scanner scan = new Scanner(System.in);
        customer.name = scan.nextLine();
        String nameRegex = "^[a-zA-Z]+([\\s][a-zA-Z]+)*$";
        while (!customer.name.matches(nameRegex)){
            System.out.println("Invalid name, please enter a new one : ");
            customer.name = scan.nextLine();
        }
    }

    /**
     * Sets the email of the customer by taking input from the user and validating it.
     */
    public void setEmail(){
        Scanner scan = new Scanner(System.in);
        OTP otp = new OTP();
        String userCode;
        customer.email = scan.nextLine();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        while (!customer.email.matches(emailRegex)){
            System.out.println("Email is invalid (e.g. example@website.com) , please enter a new one : ");
            customer.email= scan.nextLine();
        }
        System.out.println("Please wait OTP is being sent to your email..");
        otp.send(customer.email);
        System.out.print("Please enter your OTP code: ");
        userCode = scan.nextLine();
        while(!Objects.equals(userCode, otp.getCode())){ 
            System.out.println("Wrong OTP!");
            System.out.print("Enter your OTP code:");
            userCode = scan.nextLine();
        }
    }

    /**
     * Sets the phone number of the customer by taking input from the user and validating it.
     */
    public void setPhoneNum(){
        Scanner scan = new Scanner(System.in);

        customer.phoneNo = scan.nextLine();
        String phoneRegex = "01[0-9]{9}"; // example@website.com

        while (!customer.phoneNo.matches(phoneRegex)){
            System.out.println("phone number is invalid (e.g 01150225864) , please enter a new one : ");
            customer.phoneNo= scan.nextLine();
        }

    }

    /**
     * Sets the address of the customer by taking input from the user and validating it.
     */
    public void setAddress(){
        Scanner scan = new Scanner(System.in);

        customer.address = scan.nextLine();

    }

    /**
     * Sets the password of the customer by taking input from the user and validating it.
     */
    public void setPassword(){
        Scanner scan = new Scanner(System.in);

        customer.password = scan.nextLine();
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

        while (!customer.password.matches(passwordRegex)){
            System.out.println("Password must contain numbers, small and capital letters, and be at least 8 characters long" +
                    ", input a new one : ");
            customer.password= scan.nextLine();
        }

    }

    /**
     * Saves the information of the customer in the database.
     *
     * @throws FileNotFoundException if the database file is not found.
     */
    public void saveCustomer() throws FileNotFoundException {
        db.customers.add(customer);
        try {
            db.saveCustomers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName(){
        return customer.name;
    }

    public String getPass(){
        return customer.password;
    }
}