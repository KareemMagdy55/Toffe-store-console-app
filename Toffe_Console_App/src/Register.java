

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    Customer customer;
    private static int counter = 11;


    Register(){
        counter ++ ;
        customer.id = counter;
    }
    public void setName(){
        Scanner scan = new Scanner(System.in);

        customer.name = scan.nextLine();
        String nameRegex = "^[a-zA-Z]+$"; // check whether it contains spaces or not ;

        while (!customer.name.matches(nameRegex)){
            System.out.println("Name is invalid (it contains spaces) , please enter a new one : ");
            customer.name = scan.nextLine();
        }
    }
    public void setEmail(){
        Scanner scan = new Scanner(System.in);

        customer.email = scan.nextLine();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$"; // example@website.com

        while (!customer.email.matches(emailRegex)){
            System.out.println("Email is invalid (e.g. example@website.com) , please enter a new one : ");
            customer.email= scan.nextLine();
        }

    }
    public void setPhoneNum(){
        Scanner scan = new Scanner(System.in);

        customer.phoneNo = scan.nextLine();
        String phoneRegex = "^(011|012|010|015)\\\\w{8}$"; // example@website.com

        while (!customer.phoneNo.matches(phoneRegex)){
            System.out.println("phone number is invalid (e.g 01150225864) , please enter a new one : ");
            customer.phoneNo= scan.nextLine();
        }

    }

    public void setAddress(){
        Scanner scan = new Scanner(System.in);

        customer.address = scan.nextLine();
        String addressRegex = "^[\\\\w\\\\s]+, [\\\\w\\\\s]+, [\\\\w\\\\s]+$"; // Cit, street, homeNo

        while (!customer.address.matches(addressRegex)){
            System.out.println("Address is invalid (e.g Giza, dokki, 123), please enter a new one : ");
            customer.address= scan.nextLine();
        }

    }
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
    public void saveCustomer() throws FileNotFoundException {
        DataBase db  = new DataBase();
        db.customers.add(customer);
        try {
            db.saveCustomers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
