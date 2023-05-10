import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws IOException {
        DataBase DB = new DataBase();
        String str = (DB.customers.get(3).makeString());
        DB.saveCustomers();
//        System.out.println("=======================");
//        DB.products.get(3).printProduct();
        System.out.print(str);

    }


}