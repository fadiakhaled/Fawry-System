public class Specific_Discount extends Discount {

    public void setService(String s){
        if (s.toLowerCase().contains("internet")){
            registerService(new Internet_service());
        }
        else if (s.toLowerCase().contains("mobile")) {
            registerService(new Mobile_recharge());
        }
        else if (s.toLowerCase().contains("donation")) {
            registerService(new Donations());
        }
        else if (s.toLowerCase().contains("landline")) {
            registerService(new Landline());
        }
    }

    @Override
    public boolean setDiscount(double amount) {
        if (services.size() > 0) {
            if (services.get(0).getDiscount() + amount < 1)
                services.get(0).updateDiscount(amount);
            else
                return false;
        }
        return true;
    }

    @Override
    public void removeDiscount() {
        if (services.size() > 0)
            services.get(0).updateDiscount(-services.get(0).getDiscount());
    }
}
