import java.io.FileNotFoundException;

public class Login {
    String username ;
    String password ;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setUserName(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    private boolean validate() throws FileNotFoundException {
        DataBase DB = new DataBase();
        for(Customer c : DB.customers){
            if (username.equals(c.name)){
                System.out.println("Correct credentials!");
                return true;
            }
        }
        System.out.println("Incorrect credentials!");
        return false ;
    }


}
