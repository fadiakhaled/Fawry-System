import java.util.HashMap;

public class RefundController {
    private static HashMap<Integer,Transaction> refunds = new HashMap<Integer,Transaction>();
    public void AddRefund(Transaction t)
    {
        refunds.put(t.getTrans_ID(),t);
    }
    public HashMap<Integer,Transaction> getRefunds()
    {
        return refunds;
    }
    public void acceptRequest(int id)
    {
        if(refunds.containsKey(id))
        {
            double amount = refunds.get(id).getPay_amount();
            refunds.get(id).getCustomer().setWallet(refunds.get(id).getCustomer().getWallet()+amount);
            refunds.get(id).setRefund(false);
            refunds.remove(id);
        }
    }
    public void refuseRequest(int id)
    {
        if(refunds.containsKey(id))
        {
            refunds.get(id).setRefund(false);
            refunds.remove(id);
        }
    }
}
