import java.util.Scanner;

public class Main{

    public static void main(String arg[]) {
        Scanner sc=new Scanner(System.in);

        Customer_Menu m=new Customer_Menu();
        Admin_Menu adminMenu = new Admin_Menu();
        String Email;
        String Password;
        String userName;
        String service;
        int x;
        int y;
        System.out.println("[1]: Admin");
        System.out.println("[2]: User");
        x= sc.nextInt();
            if (x == 1)//Sign In admin
            {
                System.out.print("Please Enter your email: ");
                Email = sc.next().toLowerCase();
                System.out.print("Please Enter your password: ");
                Password = sc.next();
                SignInBoundry s = new SignInBoundry(Email, Password);
                while (!s.SignInAdmin()) {
                    System.out.println("Email or Password is not correct");
                    System.out.println();
                    System.out.print("Please Enter your email: ");
                    Email = sc.next().toLowerCase();
                    System.out.print("Please Enter your password: ");
                    Password = sc.next();
                    System.out.println();
                    s = new SignInBoundry(Email, Password);
                    if (s.SignInAdmin()) {
                        break;
                    }
                }
                adminMenu.ShowAdminMenu();
            }
            else if (x == 2)//sign in user
            {
                int n = 2;
                while (n > 0) {
                    n--;
                    System.out.println("1 :Sign in");
                    System.out.println("2: Sign up");
                    y = sc.nextInt();
                    if (y == 1) {
                        System.out.print("Please Enter your email: ");
                        Email = sc.next().toLowerCase();
                        System.out.print("Please Enter your password: ");
                        Password = sc.next();
                        System.out.println();
                        SignInBoundry s = new SignInBoundry(Email, Password);
                        while (!s.SignInUSer()) {
                            System.out.println("Email or Password is not correct");
                            System.out.println();
                            System.out.print("Please Enter your email: ");
                            Email = sc.next().toLowerCase();
                            System.out.print("Please Enter your password: ");
                            Password = sc.next();
                            System.out.println();
                            s = new SignInBoundry(Email, Password);
                            if (s.SignInUSer()) {
                                break;
                            }
                        }
                        m.ShowUserMenu();
                    } else if (y == 2)//sign up user
                    {
                        System.out.print("Please Enter user name: ");
                        userName = sc.next();
                        sc.nextLine();
                        System.out.print("Please Enter your email: ");
                        Email = sc.next().toLowerCase();
                        System.out.print("Please Enter your password: ");
                        Password = sc.next();
                        SignInBoundry s = new SignInBoundry(userName, Email, Password);
                        System.out.println(s.SignUp());
                        m.ShowUserMenu();
                    }
                }
            }
    }
}
