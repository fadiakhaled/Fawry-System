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
        int x;
        int ch;

        System.out.println("[1]: Admin");
        System.out.println("[2]: User");
        System.out.println("[3]: Exit");
        System.out.print("Enter your choice: ");
        x = sc.nextInt();
        ch=s.Show(x);
        if(ch==1)
        {
            adminMenu.ShowAdminMenu();
        }
        else if(ch==2)
        {
            m.ShowUserMenu();
        }
        while(x!=3) {
            while (x != 1 && x != 2) {
                System.out.print("Wrong Choice, Enter again: ");
                x = sc.nextInt();
            }

            if (x == 1) {
                adminMenu.ShowAdminMenu();
            } else if (x == 2) {
                m.ShowUserMenu();
            }

        }
    }
}
