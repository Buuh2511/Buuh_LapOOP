/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Buu Huynh
 */
public class Fibonacci {

    public static int caculateFibonacci(long n) {
        if ( n == 0){
            return 0;
        }
        else if ( n == 1) {
            return 1;
        }
        else {
            return caculateFibonacci(n-1) + caculateFibonacci(n-2);
        }
    }


    public static void main(String[] args) {
        System.out.println("The 45 squence fibonacci :  ");
        for (int i = 0; i < 45; i++) {
            System.out.println(caculateFibonacci(i)+ " is number " +i); 
        }
        
    }
}
