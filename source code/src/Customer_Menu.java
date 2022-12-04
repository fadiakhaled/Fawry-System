import java.util.ArrayList;
import java.util.Scanner;

public class Customer_Menu {
    CustomerController customer=new CustomerController();
    Discount_Controller dis=new Discount_Controller();
    Scanner sc=new Scanner(System.in);
    private String service;
    private String creditcard;
    private double amount;

    private final Discount_Controller discountController = new Discount_Controller();


    public void ShowUserMenu()
    {
        System.out.println("1: Search for services");
        System.out.println("2: Check for discount");
        System.out.println("3: Add to wallet");
        System.out.println("4: Ask for refund");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Please Enter service name: ");
                service = sc.next().toLowerCase();
                System.out.println(customer.Search(service));
            }
            case 2 -> {
                dis.returnDiscounts();
            }
            case 3 ->
                    {
                        System.out.println("Please enter credit card number and the amount you'd like to add to your wallet");
                        creditcard= sc.next();
                        System.out.println("Please enter the amount you'd like to add to your wallet");
                        amount= sc.nextDouble();
                        System.out.println("Your wallet now contains "+customer.AddToWallet(creditcard,amount));
                    }
        }

    }


}
