import java.util.Scanner;

public class Main{

    public static void main(String arg[]) {
        Scanner sc=new Scanner(System.in);
        Customer_Menu m=new Customer_Menu();
        Admin_Menu adminMenu = new Admin_Menu();

        //AuthenticationEntity entity=new AuthenticationEntity();
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
                while (true) {
                    System.out.println("[1]Add service\n[2]Add Discount\n[3]Remove Discounts\n[4]Show Refunds");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> System.out.println("lesa");
                        case 2 -> {
                            System.out.println("[1]Add Overall Discount\n[2]Add a Specific Discount");
                            int ch2 = sc.nextInt();
                            System.out.print("Add discount amount: ");
                            double amount = sc.nextDouble();
                            switch (ch2) {
                                case 1 -> adminMenu.createOverallDiscount(amount);
                                case 2 -> {
                                    System.out.print("Add service name: ");
                                    sc.nextLine();
                                    String sname = sc.nextLine();
                                    adminMenu.createSpecificDiscount(amount, sname);
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("[1]Remove all discounts\n[2]Remove a Specific Discount");
                            int ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1 -> adminMenu.removeAllDiscount();
                                case 2 -> {
                                    sc.nextLine();
                                    System.out.print("Add service name: ");
                                    String sname = sc.nextLine();
                                    adminMenu.removeSpecificDiscount(sname);
                                }
                            }
                        }
                    }
                    m.checkDiscounts();
                    System.out.println("[1]Continue\n[2] Exit Program");
                    System.out.print("===> ");
                    int ch = sc.nextInt();
                    if (ch == 2) break;
                }
            } else if (x == 2)//sign in user
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
                        System.out.println("1: Search for services");
                        System.out.println("2: Check for discount");
                        System.out.println("3: Add to wallet");
                        System.out.println("4: Ask for refund");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.print("Please Enter service name: ");
                                service = sc.next().toLowerCase();
                                System.out.println(m.Search(service));
                            }
                            case 2 -> {
                                m.checkDiscounts();
                            }
                        }
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
                    }
                }
            }
    }
}
