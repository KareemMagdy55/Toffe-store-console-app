public class Product {
    private int id ;
    private String name ;
    private String category ;
    private int quantity;
    private float price;

    public int getID() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, int id, String category, int quantity, float price){
        this.name = name;
        this.id = id ;
        this.category = category;
        this.quantity = quantity;
        this.price = price ;
    }
    public void printProduct(){
        System.out.println("Product ID: " + id );
        System.out.println("Name: " + name );
        System.out.println("Category: " + category );
        System.out.println("Price: " + price + "$");
        System.out.println("Available Quantity: " + quantity );
    }
    public String getName()
    {
        return name;
    }
}

