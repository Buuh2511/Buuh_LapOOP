
package j1.s.p0001.pkg40loc;

import java.util.ArrayList;
import java.util.Random;
import utill.Utill;

/**
 *
 * @author Buu Huynh
 */

public class J1SP000140loc {
    static Utill utl = new Utill();
       
    public static void main(String[] args) {
       String ans;
       do{
           int size;
           ArrayList<Integer> ar = new ArrayList();
           Random rd = new Random();
           size = utl.getInt("Input size of array : ", "null", "Input an integer!", "Input an integer biggerr than 0");
           for (int i = 0; i < size; i++) {
               ar.add(rd.nextInt(size));
           }
           System.out.println("Unsorted Array : " + ar);
           Sortion.caculateSortion(ar);
           
           System.out.println("Sorted Array : " + ar);
           ans = utl.checkQuestion("Do u want to continue?", "Y", "N", "Choose Y or N");
       }while(ans.compareToIgnoreCase("Y") == 0);
    }
    
}
