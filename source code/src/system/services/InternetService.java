package system.services;

public class InternetService extends Services {
    public static double discount = 0.0;
   String name="Internet Payment services";
    private String mobile_num;

    public void updateDiscount(double amount) {
        discount = discount + amount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }
}
