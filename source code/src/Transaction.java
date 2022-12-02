public class Transaction {
    private Services service;
    private Customer customer;
    private double  pay_amount;
    private boolean refund=false;
    private int trans_ID;
    public Transaction (Services s, Customer c,  double a,int id)
    {
        this.setService(s);
        this.setCustomer(c);
        this.setPay_amount(a);
        this.setTrans_ID(id);
    }
    public void setRefund(boolean r)
    {

        this.refund=r;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public boolean isRefund() {
        return refund;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getPay_amount() {
        return pay_amount;
    }

    public Services getService() {
        return service;
    }

    public int getTrans_ID() {
        return trans_ID;
    }

    public void setTrans_ID(int trans_ID) {
        this.trans_ID = trans_ID;
    }
}
