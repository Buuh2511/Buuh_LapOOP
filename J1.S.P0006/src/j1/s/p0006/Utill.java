/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;

import java.util.Scanner;

/**
 *
 * @author Buu Huynh
 */
public class Utill {
  Scanner sc = new Scanner(System.in);
    static Scanner t = new Scanner(System.in);
    public static int getInt(String msg, String err1, String err2, String err3) {
        System.out.println(msg);
        String result;
        int number;
        while (true) {
            result = t.nextLine();
            if(result.isEmpty()){
                System.out.println(err1);
            }
            else{
                try{
                    number = Integer.parseInt(result);
                    if(number < 0){
                         System.out.println(err3);
                    }
                    else {
                        return number;
                    }
                } catch (NumberFormatException e){
                    System.out.println(err2);
                }
            }
        }
    }
    public static String getString(String msg, String ans1, String ans2, String err){
        System.out.println(msg);
        String result;
        while(true){
            try {
                result= t.nextLine();
                if(result.compareToIgnoreCase(ans1) == 0 || result.compareToIgnoreCase(ans2) == 0){
                    return result;
                }
                else
                    System.out.println(err);
            } catch (Exception e){
                
            }
        }
    }
}
