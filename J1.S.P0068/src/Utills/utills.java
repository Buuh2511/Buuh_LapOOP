/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utills;

import java.util.Scanner;

/**
 *
 * @author Buu Huynh
 */
public class utills {

    Scanner sc = new Scanner(System.in);

    public String getString(String msg, String warning) {
        String result = "";
        do {
            System.out.println(msg);
            result = sc.nextLine();
            if (result.trim().isEmpty()) {
                System.out.println(warning);
            }
        } while (result.trim().isEmpty());
        return result;
    }

    public String getString(String msg, String ans1, String ans2, String err) {
        System.out.println(msg);
        String result = "";
        while (true) {

            try {
                result = sc.nextLine();
                if (result.compareToIgnoreCase(ans1) == 0 || result.compareToIgnoreCase(ans2) == 0) {
                    return result;

                } else {
                    System.out.println(err);
                }
            } catch (NumberFormatException e) {

            }
        }
    }
    
    public float getFloat(String msg, String warning, String errol) {
        float result;
        while (true) {
            try {
                System.out.println(msg);
                result = Float.parseFloat(sc.nextLine());
                if (result < 0) {
                    System.out.println(warning);
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.out.println(errol);
            }

        }
    }
}
