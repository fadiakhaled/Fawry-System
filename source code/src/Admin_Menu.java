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

}