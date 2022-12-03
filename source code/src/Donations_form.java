import java.util.Scanner;

public class Donations_form implements Forms{
    private double pay_amount;
    private int mobile_num;
    private String donation_location;
    public double create_form()
    {
        System.out.println("Please Enter your mobile number:");
        Scanner sc = new Scanner(System.in);
        setMobile_num(sc.nextInt());
        System.out.println("Please Enter the amount you would like to pay for the service:");
        setPay_amount(sc.nextDouble());
        while(getPay_amount() <1)
        {
            System.out.println("Please enter a number greater than one:");
            setPay_amount(sc.nextDouble());
        }
        System.out.println("Please Enter the name of the institute that would receive the donation:");
        setDonation_location(sc.nextLine());
        return getPay_amount();
    }

    public double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public int getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(int mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getDonation_location() {
        return donation_location;
    }

    public void setDonation_location(String donation_location) {
        this.donation_location = donation_location;
    }
}