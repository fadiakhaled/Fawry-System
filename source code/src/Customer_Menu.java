import java.util.ArrayList;

public class Customer_Menu {
    String name;
    Services internetPayment = new Internet_service();
    Services mobileRecharge = new Mobile_recharge();
    Services donations = new Donations();
    Services landline = new Landline();

    ArrayList<String> arraylist_1 = new ArrayList<String>();

    Customer_Menu()
    {
        arraylist_1.add("Mobile Recharge Services");
        arraylist_1.add("Internet Payment Services");
        arraylist_1.add("Landline Services");
        arraylist_1.add("Donations");

    }


    String Search(String s)
    {
        char c=s.charAt(0);
        if(c=='m' )
        {
            name=arraylist_1 .get(0);
        }
        else if(c=='i')
        {
            name=arraylist_1 .get(1);
        }
        else if(c=='l' )
        {
            name=arraylist_1 .get(2);
        }
        else if(c=='d')
        {
            name=arraylist_1 .get(3);
        }
        else
        {
            name="No result for "+s;
        }
        return name;
    }
    void checkDiscounts() {
        System.out.println("Discount Applied on Internet Payment Services: " + internetPayment.getDiscount() * 100 + "%" );
        System.out.println("Discount Applied on Mobile Recharge Services: " + mobileRecharge.getDiscount()*100 + "%");
        System.out.println("Discount Applied on Donations Services: " + donations.getDiscount()*100 + "%");
        System.out.println("Discount Applied on Landline Services: " + landline.getDiscount()*100 + "%");
    }

}
