/**

This class represents a catalog of products that extends the DataBase class.
It provides functionality for searching and displaying products in the catalog.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Catalog extends DataBase {/**
 * Constructor for the Catalog class.
 * 
 * @throws FileNotFoundException if the database file cannot be found
 */
Catalog() throws FileNotFoundException {
}

/**
 * Searches for a product in the catalog based on a given search string.
 * 
 * @param str the search string to match against product names
 * @throws FileNotFoundException if the database file cannot be found
 */
public void search(String str) throws FileNotFoundException {
    boolean f = false;

    for (int i = 0; i < products.size(); i++) {
        if (products.get(i).getName().contains(str)) {
            products.get(i).printProduct();
            f = true;
        }
    }
    if (f == false)
        System.out.println("We don't have this product in our store, sorry");
}

/**
 * Displays all products in the catalog.
 * 
 * @throws FileNotFoundException if the database file cannot be found
 */
public void display() throws FileNotFoundException {
    for (Product p : products) {
        p.printProduct();
    }
}
}
