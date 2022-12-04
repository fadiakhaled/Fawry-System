
import java.util.HashMap;

public class AuthenticationEntity  {

    private static  HashMap<String, Customer> user = new HashMap<>();
    private static HashMap<String, Admin> admin = new HashMap<>();
    private static HashMap<String, Customer> username = new HashMap<>();



    public AuthenticationEntity() {
        Customer c= new Customer( "habibayasser",  "habibayasser@gmail.com",  "123");

        user.put(c.getEmail(),c);
        username.put(c.getCustomerName(),c);

        Admin a=new Admin("maimostafa","maimostafa@gmail.com","321");
        admin.put(a.getEmail(),a);

    }

     static public boolean CheckAccountForUser(String Email, String Password)
    {
        if (user.containsKey(Email))
        {
            if (Password.equals(user.get(Email).getPassword()))
            {
               details(user.get(Email).getCustomerName(),Email,Password);
               return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    static boolean CheckAccountForAdmin(String Email, String Password )
    {
         if(admin.containsKey(Email))
         {
            if (Password.equals(admin.get(Email).getPassword()))
            {

                Info(admin.get(Email).getAdminName(), Email, Password);
                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }
    }

     static String CreateAccount(String UserName, String Email,String Password)
    {

        if(user.containsKey(Email))
        {
            return "This email is not valid";
        }
        else if(username.containsKey(UserName))
        {
           return "This UserName is not valid";
        }
        else
        {

            Customer cus=new Customer(UserName,Email,Password);
            user.put(cus.getEmail(), cus);
            username.put(cus.getCustomerName(), cus);
            details(user.get(Email).getCustomerName(),Email,Password);
            return "Sign up successfully";

        }
    }
    static Customer details(String username,String email,String password)
    {
        return new Customer(username,email,password);
    }
    static Admin Info(String username,String email,String password)
    {
        return new Admin(username,email,password);
    }



}
