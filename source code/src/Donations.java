public class Donations implements Services{
    public static double discount = 0.0;
    public void updateDiscount(double amount) {
        discount = discount + amount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
