package system.discounts;
import system.services.*;

public class DiscountController {

    Services internetService = new InternetService();
    Services mobileRecharge = new MobileRecharge();
    Services donations = new Donations();
    Services landline = new Landline();

    public boolean createOverallDiscount(double discAmount) {
        Discount oDiscount = new OverallDiscount();
        return oDiscount.setDiscount(discAmount);
    }
    public boolean createSpecificDiscount (double discAmount, String servName) {
        SpecificDiscount sDiscount = new SpecificDiscount();
        sDiscount.setService(servName);
        return sDiscount.setDiscount(discAmount);
    }
    public void removeAllDiscount(){
        OverallDiscount remALlDiscount = new OverallDiscount();
        remALlDiscount.removeDiscount();
    }
    public void removeSpecificDiscount(String name){
        SpecificDiscount remSpecDiscount = new SpecificDiscount();
        remSpecDiscount.setService(name);
        remSpecDiscount.removeDiscount();
    }

    public void returnDiscounts() {
        System.out.println("Discount Applied on Internet Payment Services: " + internetService.getDiscount() * 100 + "%" );
        System.out.println("Discount Applied on Mobile Recharge Services: " + mobileRecharge.getDiscount()*100 + "%");
        System.out.println("Discount Applied on Donations Services: " + donations.getDiscount()*100 + "%");
        System.out.println("Discount Applied on Landline Services: " + landline.getDiscount()*100 + "%");
    }
}
