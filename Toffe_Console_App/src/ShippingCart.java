import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ShippingCart {
    private ArrayList<OrderedProduct> products = new ArrayList<OrderedProduct>();
    public void userInteract() {
        Scanner in = new Scanner(System.in);
        int pid, choice;
        OrderedProduct chosenProduct;
        if (products.isEmpty()) {
            System.out.println("Empty Shipping Cart, Go Buy Something!");
            return;
        }
        System.out.println("This is the list of products in Shipping Cart:");
        showCart();
        pid = chooseProductID();
        // User Pressed Exit
        if (pid == -1) return;
        chosenProduct = findProduct(String.valueOf(pid));
        choice = chooseChoice();
        if (choice == 1) {
            assert chosenProduct != null;
            if (chosenProduct.increaseOrderedQuantity())
                System.out.println("Quantity increased successfully");
            else
                System.out.println("Sorry, out of stock!");
        } else if (choice == 2) {
            assert chosenProduct != null;
            chosenProduct.decreaseOrderedQuantity();
            if (chosenProduct.getOrderedQuantity() == 0)
                removeItem(String.valueOf(pid));
        } else if (choice == 3) {
            removeItem(String.valueOf(pid));
        } else if (choice == 4) {
//            placeOrder();
        } else {
            return;
        }
        userInteract();
    }

    private int chooseProductID() {
        int pid = -2;
        boolean firstIterate = true;
        Scanner in = new Scanner(System.in);
        OrderedProduct chosenProduct = null;
        System.out.print("Choose Product ID (or -1 to exit): ");
        while (chosenProduct == null) {
            if (!firstIterate)
                System.out.println("Invalid Product ID, Try Again:");
            else
                firstIterate = false;
            try {
                pid = in.nextInt();
                if (pid == -1) {
                    return pid;
                }
                chosenProduct = findProduct(String.valueOf(pid));
            } catch (Exception ignored) {
            }
        }
        in.close();
        return pid;
    }

    private int chooseChoice() {
        boolean firstIterate = true;
        int choice = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("1. Increase Quantity");
        System.out.println("2. Decrease Quantity");
        System.out.println("3. Delete Item");
        System.out.println("4. Create Order");
        System.out.println("0. Exit");
        while (choice > 4 || choice < 0) {
            if (!firstIterate)
                System.out.println("Invalid Product ID, Try Again:");
            else
                firstIterate = false;
            try {
                choice = in.nextInt();
            } catch (Exception ignored) {
            }
        }
        in.close();
        return choice;
    }

    private OrderedProduct findProduct(String pid) {
        for (OrderedProduct p : products) {
            if (Objects.equals(pid, p.getID()))
                return p;
        }
        return null;
    }

    private void showCart() {
        for (OrderedProduct p : products) {
            p.printProduct();
            System.out.println("_".repeat(50));
        }
    }

    public boolean addToCart(Product prod) {
        for (OrderedProduct p : products) {
            if (Objects.equals(p.getID(), prod.getID()))
                return p.increaseOrderedQuantity();
        }
        if (prod.getQuantity() >= 1) {
            products.add(new OrderedProduct(prod, 1));
            return true;
        }
        return false;
    }

    private void removeItem(String pid) {
        for (OrderedProduct p : products) {
            if (Objects.equals(pid, p.getID())) {
                products.remove(p);
                return;
            }
        }
    }
}
