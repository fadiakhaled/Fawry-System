public class Transaction {
    Services service;
    Customer customer;
    double  pay_amount;
    boolean refund=false;
    int trans_ID;
    public Transaction (Services s, Customer c,  double a,int id)
    {
        this.service=s;
        this.customer=c;
        this.pay_amount=a;
        this.trans_ID=id;
    }
    public void setRefund(boolean r)
    {
        this.refund=r;
    }
    public Services getService()
    {
        return this.service;
    }
    public Customer getCustomer()
    {
        return this.customer;
    }
    public double getPay_amount()
    {
        return this.pay_amount;
    }
    public boolean getRefund()
    {
        return this.refund;
    }
}
