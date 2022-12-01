public class Overall_Discount extends Discount {

    Overall_Discount(){
        registerService(new Mobile_recharge());
        registerService(new Internet_service());
        registerService(new Landline());
        registerService(new Donations());
    }

    @Override
    public void setDiscount(double amount) {
        for (int i = 0; i < 4; i++){
            services.get(i).updateDiscount(amount);
        }
    }
}
