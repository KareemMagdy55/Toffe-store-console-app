public class Product {
    private String name ;
    private String id ;
    private String category ;

    private Integer quantity;
    private Float price;

    public Product(String name, String id, String category, Integer quantity, Float price){
        this.name = name;
        this.id = id ;
        this.category = category;
        this.quantity = quantity;
        this.price = price ;
    }
    public void printProduct(){
        System.out.println("name: " + name );
        System.out.println("id: " + id );
        System.out.println("category: " + category );
        System.out.println("quantity: " + quantity );
        System.out.println("price: " + price + "$");
    }
}
//lollipops
//        10
//        sweets
//        2
//        1.99 $
