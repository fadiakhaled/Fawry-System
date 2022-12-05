package system;
import java.util.Scanner;
import system.menus.*;
import system.users.SignInBoundry;

public class Main {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        SignInBoundry s=new SignInBoundry();
        CustomerMenu m = new CustomerMenu();
        AdminMenu adminMenu = new AdminMenu();
        s.Show();
    }
}
