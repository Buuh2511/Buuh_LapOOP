package j1.s.p0010;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Buu Huynh
 */
public class LinearSearch {

    public void searchInteger(int num, ArrayList<Integer> arr) {
        int flag = -1;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == num){
                flag = i;
                break;
            }
        }
        if(flag != -1){
            System.out.println("Found : " +num + " At index : " + flag);
        }
        else{
            System.out.println("Not found");
        }
    }
}
