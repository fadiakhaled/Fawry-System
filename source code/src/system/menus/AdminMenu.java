package system.menus;

import system.discounts.DiscountController;
import system.users.Admin;
import system.users.SignInBoundry;

import java.util.HashMap;
import java.util.Scanner;
import system.transaction.*;

public class AdminMenu {
    private final DiscountController discountController = new DiscountController();
    private final RefundController refundC = new RefundController();
    Scanner sc = new Scanner(System.in);
    public static String Email;
    public static String Password;
    boolean flag=true;

    static Admin currentAdmin = new Admin("maimostafa", "maimostafa@gmail.com", "321");


    public void ShowAdminMenu() {

        while (flag) {
                System.out.println("[1]Add service\n[2]Add Discount\n[3]Remove Discounts\n[4]Show Refunds\n[5]Sign out");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("lesa");
                    case 2 -> {
                        System.out.println("[1]Add Overall Discount\n[2]Add a Specific Discount");
                        int ch2 = sc.nextInt();
                        System.out.print("Add discount amount [0..1]: ");
                        double amount = sc.nextDouble();
                        switch (ch2) {
                            case 1 -> createOverallDiscount(amount);
                            case 2 -> createSpecificDiscount(amount);
                        }
                    }
                    case 3 -> {
                        System.out.println("[1]Remove all discounts\n[2]Remove a Specific Discount");
                        int ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1 -> removeAllDiscount();
                            case 2 -> removeSpecificDiscount();
                        }
                    }
                    // accept or reject refunds
                    case 4 -> {
                        //printing all refunds
                        getRefunds();
                        System.out.println("[1]Search by Transaction ID\n[2]Exit");
                        int ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1 ->{
                                System.out.print("Enter Transaction ID: ");
                                int id = sc.nextInt();
                                System.out.println("[1]Accept Refund\n[2]Refuse Refund");
                                int acceptance = sc.nextInt();
                                switch (acceptance) {
                                    case 1 -> {
                                        // accept refund request
                                        acceptRefund(id);
                                    }
                                    case 2 -> {
                                        // reject refund request
                                        refuseRefund(id);
                                    }
                                }
                            }
                        }
                    }
                    case 5 ->
                            {
                                flag=false;
                                break;
                            }

                }

        }
    }

    // getting and printing all refunds
    public void getRefunds() {
        HashMap<Integer, Transaction> refunds = refundC.getRefunds();
        for (Integer key: refunds.keySet()){
            System.out.print(key+" ");
            System.out.print(refunds.get(key).getCustomer().getCustomerName()+" ");
            System.out.print(refunds.get(key).getPay_amount()+" ");
            System.out.print(refunds.get(key).getProvider()+" ");
            System.out.print(refunds.get(key).getService_name());
            System.out.println();
        }
    }
    // accept refund request
    public void acceptRefund(int id) {
        // if transaction id is found in refund list then accept the request else the entered ID id wrong
        if(refundC.acceptRequest(id))
            System.out.println("Refund Accepted.");
        else
            System.out.println("Wrong Transaction ID");
    }
    // reject refund request
    public void refuseRefund(int id) {
        // if transaction id is found in refund list then reject the request else the entered ID id wrong
        if(refundC.refuseRequest(id))
            System.out.println("Refund Accepted.");
        else
            System.out.println("Wrong Transaction ID");
    }
    void createOverallDiscount(double amount) {
        if (!discountController.createOverallDiscount(amount)) {
            System.out.println("You cannot apply this discount, some services may reach 100% discount");
        }else System.out.println("Discount is added Successfully");

    }
    void createSpecificDiscount(double amount) {
        System.out.print("Add service name: ");
        sc.nextLine();
        String sname = sc.nextLine();
        if (!discountController.createSpecificDiscount(amount, sname))
            System.out.println("You cannot apply more discounts to this service");
        else
            System.out.println("Discount is added Successfully");
    }
    void removeAllDiscount(){
        discountController.removeAllDiscount();
    }
    void removeSpecificDiscount() {
        sc.nextLine();
        System.out.print("Add service name: ");
        String sname = sc.nextLine();
        discountController.removeSpecificDiscount(sname);
    }
}