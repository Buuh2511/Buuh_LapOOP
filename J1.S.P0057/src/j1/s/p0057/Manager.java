package j1.s.p0057;

import entity.User;
import java.util.ArrayList;

public class Manager {

    public static int menu() {
        System.out.println("---------User Management System--------");
        System.out.println("1 - Create a new account");
        System.out.println("2 - Login");
        System.out.println("3 - Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }

    public static void createAccount(ArrayList<User> lu) {
        while (true) {
            System.out.print("Enter Username: ");
            String user = Validation.checkInputUsername();
            if (Validation.isUsernameExist(lu, user)) {
                System.out.println("This username is already existed.");
                return;
            }
            System.out.print("Enter Password: ");
            String pass = Validation.checkInputPassword();
            lu.add(new User(user, pass));
            System.out.println("Create successful");
            System.out.print("Do you want to add more account? (Y/N): ");
            if (!Validation.checkInputYN()) {
                break;
            }
        }
    }

    public static void logIn(ArrayList<User> lu) {
        if (lu.isEmpty()) {
            System.out.println("Not found account");
            return;
        }
        while (true) {
            System.out.println("------ Login ------");
            System.out.print("User Name: ");
            String name = Validation.checkInputUsername();
            System.out.print("PassWord: ");
            String pass = Validation.checkInputPassword();
            ArrayList<User> login = new ArrayList<>();
            for (User user : lu) {
                if (user.getUsername().equalsIgnoreCase(name) && user.getPassword().equals(pass)) {
                    login.add(new User(name, pass));
                }
            }
            if (login.isEmpty()) {
                System.out.println("Invalid username or password.");
                return;
            } else {
                System.err.println("Login Successfully!");
                System.out.print("Do you want to Return to Menu? (Y/N): ");
                if (Validation.checkInputYN()) {
                    break;
                }
            }
        }
    }
}
