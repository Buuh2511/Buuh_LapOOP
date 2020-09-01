/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0010;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Buu Huynh
 */
public class J1SP0010 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinearSearch search = new LinearSearch();
        String answer;
        do {
            int size;
            int num;
            ArrayList<Integer> arr = new ArrayList();
            Random rd = new Random();
            size = Utill.getInt("Please input size of array: ", "null", "You input an integer !", "Please input an integer than 0");
            for (int i = 0; i < size; i++) {
                arr.add(rd.nextInt(size));
            }
            num = Utill.getInt("Please input the number: ", "NULL", "Please input an integer", "You input an integer than 0");
            System.out.println("The Array : " + arr);
            search.searchInteger(num, arr);
            answer = Utill.getString("Do you want continues", "Y", "N", "Please choice Y or N");

        } while (answer.compareToIgnoreCase("Y") == 0);

    }
}
