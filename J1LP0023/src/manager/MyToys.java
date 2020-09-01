/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import data.Fruit;
import data.Order;
import java.util.ArrayList;
import java.util.Scanner;

public class MyToys {

    Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]  ");
                System.out.printf("Enter again : ");
            }
        }
    }
    
    public String getID(String inputMsg, String errorMsg, String format){
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public String checkInputString() {
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

    public int checkInputInt(String msg, String err1, String err2, String err3) {
        System.out.printf(msg);
        String result;
        int number;
        while (true) {
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(err1);
            } else {
                try {
                    number = Integer.parseInt(result);
                    if (number <= 0) {
                        System.out.println(err2);
                    } else {
                        return number;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(err3);
                }
            }
            System.out.printf("Enter again : ");
        }
    }

    //check user input yes/ no
    public boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");

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

    //check id exist
    public boolean checkIdExist(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }

    //check item exist or not
    public boolean checkItemExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
}
