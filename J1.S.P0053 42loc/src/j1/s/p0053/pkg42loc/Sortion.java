/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
package j1.s.p0053.pkg42loc;

import java.util.ArrayList;

public class Sortion {
    public static void sortAccending(ArrayList<Integer> ar){
       for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if(ar.get(i) > ar.get(j)){
                    int tmp;
                    tmp = ar.get(i);
                    ar.set(i, ar.get(j));
                    ar.set(j, tmp);
                }
            }
        }
    }
    
    public static void sortDescending(ArrayList<Integer> ar){
       for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if(ar.get(i) < ar.get(j)){
                    int tmp;
                    tmp = ar.get(i);
                    ar.set(i, ar.get(j));
                    ar.set(j, tmp);
                }
            }
        }
    }
}
