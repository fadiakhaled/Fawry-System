package system.services;

public class Landline extends Services {
    public static double discount = 0.0;
    private String receipt_plan;
    private String landline_num;
    private String name="Landline services";

    public void updateDiscount(double amount) {
        discount = discount + amount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getReceipt_plan() {
        return receipt_plan;
    }

    public void setReceipt_plan(String receipt_plan) {
        this.receipt_plan = receipt_plan;
    }

    public String getLandline_num() {
        return landline_num;
    }

    public void setLandline_num(String landline_num) {
        this.landline_num = landline_num;
    }

}
