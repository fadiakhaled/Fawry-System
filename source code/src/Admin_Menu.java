import java.util.HashMap;

public class Admin_Menu {

    public void createOverallDiscount(double discAmount) {
        Discount oDiscount = new Overall_Discount();
        oDiscount.setDiscount(discAmount);
    }

    public void createSpecificDiscount (double discAmount, String servName) {
        Specific_Discount sDiscount = new Specific_Discount();
        sDiscount.setService(servName);
        sDiscount.setDiscount(discAmount);
    }

    public void removeAllDiscount(){
        Overall_Discount remALlDiscount = new Overall_Discount();
        remALlDiscount.setDiscount(0);
    }
    public void removeSpecificDiscount(String name){
        Specific_Discount remSpecDiscount = new Specific_Discount();
        remSpecDiscount.setService(name);
        remSpecDiscount.setDiscount(0);
    }
    public void getRefunds() {
        RefundController refundC = new RefundController();
        HashMap<Integer,Transaction> refunds = refundC.getRefunds();
        for (Integer key: refunds.keySet()){
            System.out.print(key+" ");
            System.out.print(refunds.get(key).getCustomer().getCustomerName()+" ");
            System.out.print(refunds.get(key).getPay_amount());
            System.out.println();
        }
    }
    public void acceptRefund(int id) {
        RefundController refundC = new RefundController();
        refundC.acceptRequest(id);
    }
    public void refuseRefund(int id) {
        RefundController refundC = new RefundController();
        refundC.refuseRequest(id);
    }

}