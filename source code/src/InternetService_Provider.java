import java.util.List;
import java.util.Vector;

public class InternetService_Provider extends Service_provider{
    private InternetService service=new InternetService();
    public static  Vector<String>names=new Vector<String>(List.of(new String[]{"Vodafone","Orange","Etisalat","We"}));
    static private InternetService_Provider instance;

    private InternetService_Provider(){}

    public static InternetService_Provider getInstance()
    {
        if(instance==null)
        {
            instance=new InternetService_Provider();
        }
        return instance;
    }

    public void choose_form()
    {
        form= new Mobile_form();
        Vector<String> info=form.create_form(names);
        setPay_amount(Double.parseDouble(info.get(0)));
        getService().setProvider(info.get(1));
        getService().setMobile_num(info.get(2));
    }

    public void pay_transaction() {
        setPay_amount(getPay_amount()-(getService().getDiscount() * getPay_amount()));
        if (getPayment().pay(getPay_amount()) > -2) {
            getTransactions().put(trans_ID,getTrans());
            System.out.println("Transaction completed successfully and amount " + getPay_amount() + " was paid.");
        } else if (getPayment().pay(getPay_amount()) > -1) {
            getCustomer().setWallet(getPayment().pay(getPay_amount()));
        } else if (getPayment().pay(getPay_amount()) == -2) {
            System.out.println("Transaction Payment Failed.");
        }

    }

    public  void create_Trans()
    {
        setTrans(new Transaction(getService().getName(), getCustomer(), getPay_amount(), getTrans_ID(),getService().getProvider()));
    }


    public InternetService getService() {
        return service;
    }

    public void setService(InternetService service) {
        this.service = service;
    }
    public static Vector<String> getNames() {
        return names;
    }

    public static void setNames(Vector<String> names) {
        InternetService_Provider.names = names;
    }
    public void addService_provider(String name)
    {
        names.add(name);
    }
    public void printService_providers()
    {   int i=1;
        for (String name : names) {
            System.out.println(i+" - " + name);
            i++;
        }
    }
}
