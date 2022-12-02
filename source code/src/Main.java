import java.util.Scanner;

public class Main{

    public static void main(String arg[]) {
        Scanner sc=new Scanner(System.in);
        Customer_Menu m=new Customer_Menu();
        //AuthenticationEntity entity=new AuthenticationEntity();
        String Email;
        String Password;
        String userName;
        String service;
        int x;
        int y;
        System.out.println("1 :if you are Admin");
        System.out.println( "2: if you are user");
        x= sc.nextInt();
        if(x==1)//Sign In admin
        { System.out.print("Please Enter your email: ");
            Email = sc.next().toLowerCase();
            System.out.print("Please Enter your password: ");
            Password = sc.next();
            SignInBoundry s = new SignInBoundry(Email, Password);
            while (!s.SignInAdmin())
            {
                System.out.println("Email or Password is not correct");
                System.out.println();
                System.out.print("Please Enter your email: ");
                Email = sc.next().toLowerCase();
                System.out.print("Please Enter your password: ");
                Password = sc.next();
                System.out.println();
                s = new SignInBoundry(Email, Password);
                if(s.SignInAdmin())
                {
                    break;
                }
            }

            System.out.println("Add service");
            System.out.println("Add discount");
            System.out.println("list of refunds");
        }
        else if(x==2)//sign in user
        {
            int n=2;
            while(n>0){
                n--;
                System.out.println("1 :Sign In" );
                System.out.println("2: Sign Up");
                y= sc.nextInt();
                if(y==1)
                {
                    System.out.print("Please Enter your email: ");
                    Email = sc.next().toLowerCase();
                    System.out.print("Please Enter your password: ");
                    Password = sc.next();
                    System.out.println();
                    SignInBoundry s = new SignInBoundry(Email, Password);
                    while (!s.SignInUSer())
                    {
                        System.out.println("Email or Password is not correct");
                        System.out.println();
                        System.out.print("Please Enter your email: ");
                        Email = sc.next().toLowerCase();
                        System.out.print("Please Enter your password: ");
                        Password = sc.next();
                        System.out.println();
                        s = new SignInBoundry(Email, Password);
                        if(s.SignInUSer())
                        {
                            break;
                        }
                    }
                    System.out.println("1: Search for services");
                    System.out.println("2: Check for discount");
                    System.out.println("3: Add to wallet");
                    System.out.println("4: Ask for refund");
                    int choice= sc.nextInt();
                    switch (choice)
                    {
                        case 1 ->
                        {
                            System.out.print("Please Enter service name: ");
                            service=sc.next().toLowerCase();
                            System.out.println(m.Search(service));
                        }
                        case 2 ->
                        {
                            m.checkDiscounts();
                        }
                    }
                }
                else if(y==2)//sign up user
                {
                    System.out.print("Please Enter user name: ");
                    userName= sc.next();
                    sc.nextLine();
                    System.out.print("Please Enter your email: ");
                    Email = sc.next().toLowerCase();
                    System.out.print("Please Enter your password: ");
                    Password = sc.next();
                    SignInBoundry s = new SignInBoundry(userName,Email, Password);
                    System.out.println(s.SignUp());
                }
            }}

    }
}
