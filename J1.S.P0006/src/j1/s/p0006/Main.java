/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Buu Huynh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String answer;
        
        do{
            int size;
            int num;
            ArrayList<Integer> arr = new ArrayList();
            Random rd = new Random();
            size = Utill.getInt("Please input size of array: ","null","You input an integer !","Please input an integer than 0");
            for (int i =0; i < size; i++){
                arr.add(rd.nextInt(size));
        }
            num = Utill.getInt("Please input the number: ","NULL","Please input an integer","You input an integer than 0");
            BinarySearch.sortTheArray(arr);
            System.out.println("The Array: "+ arr);
            BinarySearch.searchBinary(num, arr);
            if (BinarySearch.searchBinary(num, arr) != -1){
                System.out.println("Found: " + num + " At Index: " + BinarySearch.searchBinary(num, arr));
            } else{
                System.out.println("NOT Found!");
            }
            answer = Utill.getString("Do you want continues?", "Y", "N", "Please choice Y or N");
    } while(answer.compareToIgnoreCase("Y") == 0);
    
}
}
