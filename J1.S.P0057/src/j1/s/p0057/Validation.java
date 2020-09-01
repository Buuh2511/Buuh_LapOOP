package j1.s.p0057;

import entity.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    public static final String USERNAME_VALID = "^\\S{5}\\S*$";
    public static final String PASSWORD_VALID = "^\\S{6}\\S*$";

//    public static final String USERNAME_VALID = "^[a-zA-Z]{5}$";
//    public static final String PASSWORD_VALID = "^[0-9]{6}$";

    public static Scanner sc = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputUsername() {
        while (true) {
            try {
                String user = Validation.checkInputString().trim();
                if (!user.matches(USERNAME_VALID)) {
                    throw new Exception();
                }
                return user;
            } catch (Exception e) {
                System.err.println("You must enter at least 5 characters, and no space!");
                System.out.print("User Name: ");
            }
        }
    }

    public static String checkInputPassword() {
        while (true) {
            try {
                String passNum = Validation.checkInputString().trim();
                String result = String.valueOf(passNum);
                if (!result.matches(PASSWORD_VALID)) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("You must enter at least 6 characters, and no space!");
                System.out.print("Password number: ");
            }
        }
    }

    public static boolean isUsernameExist(ArrayList<User> lu, String username) {
        if (lu.isEmpty()) {
            return false;
        }
        for (User user : lu) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
}
