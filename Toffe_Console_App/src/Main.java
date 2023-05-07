import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataBase DB = new DataBase();
        DB.customers.get(3).printCustomer();
        System.out.println("=======================");
        DB.products.get(3).printProduct();
    }
}