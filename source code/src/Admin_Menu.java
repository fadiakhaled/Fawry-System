import java.util.HashMap;

public class Admin_Menu {
    private final Discount_Controller discountController = new Discount_Controller();
    private final RefundController refundC = new RefundController();

    public void createOverallDiscount(double discAmount) {
        discountController.createOverallDiscount(discAmount);
    }

    public void createSpecificDiscount (double discAmount, String servName) {
        discountController.createSpecificDiscount(discAmount, servName);
    }

    public void removeAllDiscount(){
        discountController.removeAllDiscount();
    }
    public void removeSpecificDiscount(String name){
        discountController.removeSpecificDiscount(name);
    }
    public void getRefunds() {
        HashMap<Integer,Transaction> refunds = refundC.getRefunds();
        for (Integer key: refunds.keySet()){
            System.out.print(key+" ");
            System.out.print(refunds.get(key).getCustomer().getCustomerName()+" ");
            System.out.print(refunds.get(key).getPay_amount());
            System.out.println();
        }
    }
    public void acceptRefund(int id) {
        refundC.acceptRequest(id);
    }
    public void refuseRefund(int id) {
        refundC.refuseRequest(id);
    }

}