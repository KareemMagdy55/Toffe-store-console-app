import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class ShippingCart {
    private final ArrayList<OrderedProduct> products = new ArrayList<OrderedProduct>();
    double totalPrice;

    public void userInteract(int custId, DataBase db) throws IOException {
        updateTotalPrice();
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
        if (pid == -1)
            return;
        else if(pid == -2) {
            placeOrderToDB(custId, db);
            userInteract(custId, db);
            return;
        }
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
        } else {
            return;
        }
        userInteract(custId, db);
    }

    private void placeOrderToDB(int custId, DataBase db) throws IOException {
        db.addNewOrder(
                new Order(db.getLargestOrderID() + 1,
                        custId, new Date(), new ArrayList<>(products),
                        totalPrice, 1
                )
        );
        System.out.println("Your order has been created successfully");
    }

    private double updateTotalPrice() {
        double price = 0;
        for (OrderedProduct prod : products) {
            price += prod.getPrice() * prod.getOrderedQuantity();
        }
        totalPrice = price;
        return totalPrice;
    }

    private int chooseProductID() {
        int pid = -3;
        boolean firstIterate = true;
        Scanner in = new Scanner(System.in);
        OrderedProduct chosenProduct = null;
        System.out.println("Choose Product ID:");
        System.out.println("(-1 to exit or -2 to create order)");
        while (chosenProduct == null) {
            if (!firstIterate) {
                System.out.println("Invalid Product ID, Try Again:");
                System.out.println("(-1 to exit or -2 to create order)");
            }
            else
                firstIterate = false;
            try {
                pid = in.nextInt();
                if (pid == -1 || pid == -2) {
                    return pid;
                }
                chosenProduct = findProduct(String.valueOf(pid));
            } catch (Exception ignored) {
                in.nextLine();
            }
        }
        return pid;
    }

    private int chooseChoice() {
        boolean firstIterate = true;
        int choice = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("1. Increase Quantity");
        System.out.println("2. Decrease Quantity");
        System.out.println("3. Delete Item");
        System.out.println("0. Exit");
        return Validator.takeIntChoice(0, 3);
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
        System.out.println("Total Price = " + totalPrice);
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
