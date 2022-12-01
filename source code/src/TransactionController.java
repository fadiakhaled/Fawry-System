import java.util.Vector;
public class TransactionController {
    Payment payment;
    Services service;
    Customer customer;
    double  pay_amount;
    Transaction trans;
    Vector<Transaction> transactions= new Vector<>();
    static int trans_ID=0;
    public TransactionController (Services s, Customer c,Payment p, double a)
    {
        this.service=s;
        this.customer=c;
        this.payment=p;
        this.pay_amount=a;
        trans_ID++;
        this.trans=new Transaction(s,c,a,trans_ID);
        create_transaction();

    }
    public void create_transaction()
    {
        pay_amount=service.get_discount()*pay_amount;
        if(payment.pay(pay_amount)>-2) {
            transactions.add(trans);
            System.out.println("Transaction completed successfully and amount "+pay_amount+" was paid.");
        }
        else if(payment.pay(pay_amount)>-1)
        {
            customer.setWallet(payment.pay(pay_amount));
        }
        else if(payment.pay(pay_amount)==-2)
        {
            System.out.println("Transaction Payment Failed.");
        }

    }
    public  Vector<Transaction> get_transactions()
    {
        return transactions;
    }

}
