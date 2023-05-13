/**

Main class for running the ToffeeApp.
The ToffeeApp class is responsible for starting and running the application.
This class creates a new instance of ToffeeApp and calls the runApp() method to start the application.
*/
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    /**
 * The main method creates a new instance of ToffeeApp and calls the runApp() method to start the application.
 *
 * @param args an array of command-line arguments for the application.
 * @throws IOException if an I/O error occurs.
 */
public static void main(String[] args) throws IOException {
    ToffeeApp app = new ToffeeApp();
    app.runApp();
}
}
