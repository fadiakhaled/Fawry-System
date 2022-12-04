import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class MobileService_provider extends Service_provider{
    private Mobile_recharge service=new Mobile_recharge();
    public static  Vector<String>names=new Vector<String>(List.of(new String[]{"Vodafone","Orange","Etisalat","We"}));

    static private MobileService_provider instance;

    private MobileService_provider(){}

    public static MobileService_provider getInstance()
    {
        if(instance==null)
        {
            instance=new MobileService_provider();
        }
        return instance;
    }

    public void choose_form()
    {
        form= new Mobile_form();
        Vector<String>info=form.create_form(names);
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


    public Mobile_recharge getService() {
        return service;
    }

    public void setService(Mobile_recharge service) {
        this.service=service;
    }

    public static Vector<String> getNames() {
        return names;
    }

    public static void setNames(Vector<String> names) {
        MobileService_provider.names = names;
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
