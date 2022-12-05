package system.discounts;

import system.services.Services;

import java.util.Vector;

public abstract class Discount {
    protected Vector<Services> services = new Vector <Services>();
    public void registerService(Services service) {
        services.add(service);
    }
    public abstract boolean setDiscount(double amount);
    public abstract void removeDiscount();
}
