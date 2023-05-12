public class Product {
    private String id ;
    private String name ;
    private String category ;
    private int quantity;
    private float price;

    public String  getID() {
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

    public Product(String name, String id, String category, int quantity, float price){
        this.id = id ;
        this.name = name;
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

