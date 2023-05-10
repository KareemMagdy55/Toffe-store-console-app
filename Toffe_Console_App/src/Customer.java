

public class Customer {
    public Integer id ;
    public String name ;
    public String phoneNo;
    public String address;
    public String email;
    public String password;


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
//    public String makeString(){
//        String customer =toString(id)+'\n'+name+'\n'+phoneNo+'\n'+address+'\n'+email+'\n'+password+'\n';
//        return toString;
//    }
    public String makeString() {
        String customer =Integer.toString(id)+'\n'+name+'\n'+phoneNo+'\n'+address+'\n'+email+'\n'+password+'\n';
        return customer;
    }

}
//1
//        John Smith
//        01123456789
//        25 Main St, Cairo, Egypt
//        john.smith@email.com
//P@ssw0rd
