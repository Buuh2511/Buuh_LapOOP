/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class utill {
    Scanner sc = new Scanner(System.in);
    //static Scanner st = new Scanner(System.in);
    
    public int getInt(String msg, String err1, String err2, String err3){
        System.out.println(msg);
        String result;
        int number;
        while(true){
            result = sc.nextLine();
            if(result.isEmpty()){
                System.out.println(err1);
            }
            else{
                try {
                    number = Integer.parseInt(result);
                    if(number < 0){
                        System.out.println(err3);
                    }
                    else{
                        return number;
                    }
                } catch (Exception e) {
                    System.out.println(err2);
                }
            }
        }
    }
    
    public int getInt (String msg, String errorException, String errorNull){
        String result;
        int number;
        while (true){
            System.out.println(msg);
            result= sc.nextLine();
            if (result.isEmpty()){
                System.out.println(errorNull);
            }
            else {
                try{
                    number=Integer.parseInt(result);
                        return number;
                    
                }catch (NumberFormatException e){
                    System.out.println(errorException);
                }
            }
        }
    }
    
    public int Menu (ArrayList<String> list){
        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));
        System.out.println("Input value [1->4]");
        int choice =Integer.parseInt(sc.nextLine());
        return choice;
    }
}
