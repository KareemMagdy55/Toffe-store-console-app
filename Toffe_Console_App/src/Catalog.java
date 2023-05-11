import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog extends DataBase {

    Catalog()throws FileNotFoundException{};
    public void search(String str) throws FileNotFoundException {
        boolean f = false;

        for(int i = 0 ; i<products.size();i++)
        {
            if (products.get(i).getName().contains(str))
            {
                products.get(i).printProduct();
                f = true;

            }
        }
        if (f==false)
            System.out.println("We don't have this product in our store , sorry");
    }
    public void display() throws FileNotFoundException {
        for(Product p : products)
        {
            p.printProduct();
        }

    }
}
