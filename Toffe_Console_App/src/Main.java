import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Date d = new Date(1683874690466l);
//        System.out.println(d);
//        return;
        DataBase DB = new DataBase();
        String str = (DB.customers.get(3).makeString());
        DB.customers.add(new Customer(11, "Youssef",
                "0100", "ad123", "@gmail", "pass"));
        DB.saveCustomers();
        DB.products.get(3).printProduct();
        System.out.println("=======================");
        System.out.print(str);
    }
}