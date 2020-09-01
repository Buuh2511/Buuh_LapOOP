/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002;

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
          ArrayList<Integer> arr = new ArrayList();
          Random rd = new Random();
          size = Utill.getInt("Enter number of array: ","NULL", "Please input integer!",  "Input an integer more than 0");
          for(int i =0; i < size;i++){
              arr.add(rd.nextInt(size));
          }
            System.out.println("Unsorted array: " +arr);
            SelectionSort.sortInteger(arr);
            System.out.println("Sorted array: "+arr);
            answer = Utill.getString("Do you wan continues?", "Y", "N", "Please choice \"Y\" or \"N\" !");
        } while(answer.compareToIgnoreCase("Y") == 0);
       
    }
    
}
    

