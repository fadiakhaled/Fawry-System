import java.util.Vector;

public abstract class Discount {
    Vector<Services> services = new Vector <Services>();
    public void registerService(Services service) {
        services.add(service);
    }
    public abstract void setDiscount(double amount);
    public abstract void removeDiscount();
}
