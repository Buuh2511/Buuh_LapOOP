/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002;

import java.util.ArrayList;

/**
 *
 * @author Buu Huynh
 */
public class SelectionSort {

    public static void sortInteger(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int index = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) > arr.get(index)) {
                    index = j;
                }
            }
            
            if (index != i) {
                int tmp = arr.get(index);
                arr.set(index, arr.get(i));
                arr.set(i, tmp);
            }
        }
    }
}
 