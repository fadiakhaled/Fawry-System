import java.util.Vector;

public class Donations extends Services{
    public static double discount = 0.0;
    private String location;
    String name="Donations services";

    public void updateDiscount(double amount) {
        discount = discount + amount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
