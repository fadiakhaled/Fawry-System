import java.util.Scanner;
import java.util.Vector;

public abstract class Forms {
    protected double pay_amount;
    protected Vector<String>info;
    public Vector<String> create_form(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the amount you would like to pay for the service:");
        setPay_amount(sc.nextDouble());
        while(getPay_amount() <1)
        {
            System.out.println("Please enter a number greater than one:");
            setPay_amount(sc.nextDouble());
        }
        info.add(0,Double.toString(getPay_amount()));
        extra_info();
        return  info;
    }
    public abstract void extra_info();
    public double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
    }
}

