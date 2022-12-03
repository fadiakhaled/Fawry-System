public class SignInBoundry {
    private String Email;
    private String Password;
    private String user;
    AuthenticationController controller=new AuthenticationController();
    SignInBoundry(){}
    SignInBoundry(String userName,String email,String password)
    {
        Email=email;
        Password=password;
        user=userName;

    }
    SignInBoundry(String e,String p)
    {
        Email=e;
        Password=p;
    }
    void setEmail(String e)
    {
        Email=e;
    }
    void setPassword(String p)
    {
        Password=p;
    }
    String getEmail()
    {
        return Email;
    }
    String getPassword()
    {
        return Password;
    }
    void setUserl(String e)
    {
        user=e;
    }
    String getuser()
    {
        return user;
    }


    boolean SignInAdmin()
    {
        return controller.SignInAdmin(Email,Password);
    }
    boolean SignInUSer()
    {
       return controller.SignInUser(Email,Password);
    }
    String SignUp()
    {
        return controller.SignUpUser(user,Email,Password);
    }


}
