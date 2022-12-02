public class AuthenticationController  {


    AuthenticationEntity athen=new AuthenticationEntity();

    boolean SignInUser(String Email,String Password)
    {
         return athen.CheckAccountForUser(Email, Password);

    }
    boolean SignInAdmin(String Email,String Password)
    {
       return athen.CheckAccountForAdmin(Email, Password);

    }
    String SignUpUser(String Username,String Email,String password)
    {

        return athen.CreateAccount(Username, Email,password);

   }



}
