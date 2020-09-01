package utill;

import java.util.Scanner;

/**
 *
 * @author Buu Huynh
 */

public class Utill {
    Scanner sc = new Scanner(System.in);
    
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
    
    public String checkQuestion(String msg, String ans1, String ans2, String err1){
        System.out.println(msg);
        String result;
        while(true){
            try {
                result = sc.nextLine();
                if(result.compareToIgnoreCase(ans1) == 0 || result.compareToIgnoreCase(ans2) == 0){
                    return result;
                }
                else{
                    System.out.println(err1);
                }
            } catch (Exception e) {
                
            }
        }
    }
}
