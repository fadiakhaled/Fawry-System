import java.util.HashMap;
import java.util.Vector;

public abstract class Service_provider {
    protected Forms form;
    protected Payment payment;
    protected double pay_amount;
    protected Transaction trans;
    protected static HashMap<Integer,Transaction> transactions = new HashMap<Integer,Transaction>();
    protected static int trans_ID = 0;
    protected Customer customer;
    public void create_transaction( Customer c, Payment p) {
        this.setCustomer(c);
        this.setPayment(p);
        setTrans_ID(getTrans_ID() + 1);
        choose_form();
        pay_transaction();
        create_Trans();
    }
    public abstract void create_Trans();

    public abstract void choose_form();

    public abstract void pay_transaction() ;

    public static int getTrans_ID() {
        return trans_ID;
    }

    public static void setTrans_ID(int trans_ID) {
        Service_provider.trans_ID = trans_ID;
    }

    public Forms getForm() {
        return form;
    }

    public void setForm(Forms form) {
        this.form = form;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public Transaction getTrans() {
        return trans;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }

    public HashMap<Integer,Transaction> getTransactions() {

        return transactions;
    }

    public void setTransactions(HashMap<Integer,Transaction> transactions) {
        this.transactions = transactions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}