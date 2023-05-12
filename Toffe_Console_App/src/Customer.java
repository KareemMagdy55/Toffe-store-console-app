/**

 The Customer class represents a customer entity, containing information such as their name, phone number, address, email, and password.
 */
public class Customer {

    /**

     The ID of the customer.
     */
    public String id;
    /**

     The name of the customer.
     */
    public String name;
    /**

     The phone number of the customer.
     */
    public String phoneNo;
    /**

     The address of the customer.
     */
    public String address;
    /**

     The email of the customer.
     */
    public String email;
    /**

     The password of the customer.
     */
    public String password;
    /**

     Creates a new instance of the Customer class with the specified id, name, phone number, address, email, and password.
     @param id The ID of the customer.
     @param name The name of the customer.
     @param phoneNo The phone number of the customer.
     @param address The address of the customer.
     @param email The email of the customer.
     @param password The password of the customer.
     */
    public Customer(Integer id, String name, String phoneNo, String address, String email, String password) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    /**

     Prints the details of the customer to the console.
     */
    public void printCustomer() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("phoneNo: " + phoneNo);
        System.out.println("address: " + address);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
    }
    /**

     Returns the string representation of the customer.
     @return The string representation of the customer.
     */
    public String makeString() {
        return id + '\n' + name + '\n' + phoneNo + '\n' + address + '\n' + email + '\n' + password + '\n';
    }
}