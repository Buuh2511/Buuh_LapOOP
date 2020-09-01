package j1.s.p0057;

import entity.User;
import java.util.ArrayList;

public class J1SP0057 {

    public static void main(String[] args) {
        int choice;
        ArrayList<User> lu = new ArrayList<>();
        do {
            choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createAccount(lu);
                    break;
                case 2:
                    Manager.logIn(lu);
                    break;
                case 3:
                    System.err.println("Goodbye!");
                    break;
            }
        } while (choice != 3);
    }
}
