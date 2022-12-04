import java.util.ArrayList;
import java.util.Scanner;

public class Customer_Menu {
    CustomerController customerController = new CustomerController();
    public RefundController refundC = new RefundController();
    Discount_Controller dis = new Discount_Controller();
    Scanner sc = new Scanner(System.in);
    public static String Email;
    public static String Password;
    public static String userName;
    private String service;
    private String creditcard;
    static Customer currentCustomer = new Customer("habibayasser",  "habibayasser@gmail.com",  "123");
    private double amount;
    private Payment payment;

    private final Discount_Controller discountController = new Discount_Controller();


    public void ShowUserMenu() {
        int y;
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
                    currentCustomer = s.getCustomer(Email);
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
            currentCustomer = s.getCustomer(Email);
        }


        System.out.println("1: Search for services");
        System.out.println("2: Check for discount");
        System.out.println("3: Add to wallet");
        System.out.println("4: Ask for refund");
        System.out.println("5: Check wallet");
        System.out.println("6: Pay for a service");
        System.out.println("7: Sign Out");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Please Enter service name: ");
                service = sc.next().toLowerCase();
                System.out.println(customerController.Search(service));
            }
            case 2 -> {
                dis.returnDiscounts();
            }
            case 3 -> {
                System.out.println("Please enter credit card number and the amount you'd like to add to your wallet");
                creditcard = sc.next();
                System.out.println("Please enter the amount you'd like to add to your wallet");
                amount = sc.nextDouble();
                System.out.println("Your wallet now contains " + customerController.AddToWallet(currentCustomer, creditcard, amount));
            }
            case 4 -> {
                System.out.println("Please Enter Transaction id");
                int id = sc.nextInt();
                requestRefund(id);
            }
            case 5 -> {
                System.out.println("You have" + currentCustomer.getWallet() + " L.E. in your wallet");
            }
            case 6 -> {
                System.out.println("Please choose a payment method:");
                System.out.println("1: Pay by cash");
                System.out.println("2: Pay by credit card");
                System.out.println("3: Pay by wallet");
                int ans = sc.nextInt();

                switch (ans) {
                    case 1 -> {
                        payment = new CashPayment();
                    }
                    case 2 -> {
                        System.out.print("Please enter your credit card number:");
                        String creditcard= sc.next();
                        payment = new CreditCardPayment(creditcard);
                    }
                    case 3 -> {
                        System.out.println("the wallet contains "+ currentCustomer.getWallet());
                        payment = new WalletPayment(currentCustomer.getWallet());
                    }
                }

                System.out.println("1: Internet Payment services");
                System.out.println("2: Mobile recharge services");
                System.out.println("3: Donations services");
                System.out.println("4: Landline services");
                System.out.println("5: cancel");
                int option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        InternetService_Provider ISP =  InternetService_Provider.getInstance();

                        ISP.create_transaction(currentCustomer, payment);
                    }
                    case 2 -> {
                        MobileService_provider MSP = MobileService_provider.getInstance();
                        MSP.printService_providers();
                        int sp= sc.nextInt();
                        MSP.create_transaction(currentCustomer, payment);
                    }
                    case 3 -> {
                        DonationService_provider DSP =  DonationService_provider.getInstance();
                        DSP.create_transaction(currentCustomer, payment);
                    }
                    case 4 -> {
                        LandlineService_provider LSP =  LandlineService_provider.getInstance();
                        LSP.create_transaction(currentCustomer, payment);
                    }

                }


            }
            case 7 -> {
                break;
            }
        }


    }
    public void requestRefund(int id)
    {
        if(refundC.requestRefund(id) && currentCustomer.getCustomerName()==refundC.getTransactionByID(id).getCustomer().getCustomerName())
            System.out.println("Refund request done successfully");
        else
            System.out.println("Wrong Transaction ID");
    }
}






