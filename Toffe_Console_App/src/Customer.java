

public class Customer {
    private Integer id ;
    private String name ;
    private String phoneNo;
    private String address;
    private String email;
    private String password;


    public Customer(Integer id , String name, String phoneNo, String address, String email, String password){
        this.id = id ;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    public void printCustomer(){
        System.out.println("id: " + id );
        System.out.println("name: " + name );
        System.out.println("phoneNo: " + phoneNo );
        System.out.println("address: " + address );
        System.out.println("email: " + email );
        System.out.println("password: " + password );
    }


}
//1
//        John Smith
//        01123456789
//        25 Main St, Cairo, Egypt
//        john.smith@email.com
//P@ssw0rd
