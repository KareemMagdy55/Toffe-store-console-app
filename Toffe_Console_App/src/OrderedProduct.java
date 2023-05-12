public class OrderedProduct extends Product{
    private int orderedQuantity;
    public int getOrderedQuantity(){
        return orderedQuantity;
    }
    public OrderedProduct(String name, int id, String category, int quantity, float price, int orderedQuantity) {
        super(name, id, category, quantity, price);
        this.orderedQuantity = orderedQuantity;
    }
    public OrderedProduct(Product product, int orderedQuantity){
        super(product.getName(), product.getID(), product.getCategory(), product.getQuantity(), product.getPrice());
        this.orderedQuantity = orderedQuantity;
    }
    public void printProduct(){
        System.out.println("Product ID: " + getID() );
        System.out.println("Name: " + getName() );
        System.out.println("Ordered Quantity: " + orderedQuantity);
        System.out.println("Category: " + getCategory() );
        System.out.println("Price: " + getPrice() + "$");
    }
    public boolean increaseOrderedQuantity(){
        if (orderedQuantity == getQuantity())
            return false;
        orderedQuantity++;
        return true;
    }
    public void decreaseOrderedQuantity(){
        orderedQuantity--;
    }
}
