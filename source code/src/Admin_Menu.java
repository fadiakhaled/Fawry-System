import java.util.HashMap;
import java.util.Scanner;


public class Admin_Menu {
    private final Discount_Controller discountController = new Discount_Controller();
    private final RefundController refundC = new RefundController();
    Scanner sc = new Scanner(System.in);
    public static String Email;
    public static String Password;

    static Admin currentAdmin = new Admin("maimostafa", "maimostafa@gmail.com", "321");


    public void ShowAdminMenu() {
        while (true) {
            int x;
            System.out.println("[1]: Sign in");
            System.out.println("[1]: Sign up");
             x= sc.nextInt();
            if (x == 1)//Sign In admin
            {
                System.out.print("Please Enter your email: ");
                Email = sc.next().toLowerCase();
                System.out.print("Please Enter your password: ");
                Password = sc.next();
                SignInBoundry s = new SignInBoundry(Email,Password);
                while (!s.SignInAdmin()) {
                    System.out.println("Email or Password is not correct");
                    System.out.println();
                    System.out.print("Please Enter your email: ");
                    Email = sc.next().toLowerCase();
                    System.out.print("Please Enter your password: ");
                    Password = sc.next();
                    System.out.println();
                    s = new SignInBoundry(Email,Password);
                    if (s.SignInAdmin()) {
                        currentAdmin = s.getAdmin(Email);
                    }
                }
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
                            case 1 -> {
                                discountController.createOverallDiscount(amount);
                                discountController.returnDiscounts();
                            }

                            case 2 -> {
                                System.out.print("Add service name: ");
                                sc.nextLine();
                                String sname = sc.nextLine();
                                discountController.createSpecificDiscount(amount, sname);
                                discountController.returnDiscounts();
                            }
                        }

                    }
                    case 3 -> {
                        System.out.println("[1]Remove all discounts\n[2]Remove a Specific Discount");
                        int ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1 -> discountController.removeAllDiscount();
                            case 2 -> {
                                sc.nextLine();
                                System.out.print("Add service name: ");
                                String sname = sc.nextLine();
                                discountController.removeSpecificDiscount(sname);
                            }
                        }
                    }
                }
                //m.checkDiscounts();
                System.out.println("[1]Continue\n[2] Exit Program");
                System.out.print("===> ");
                int ch = sc.nextInt();
                if (ch == 2) break;
            }
        }

    }
}