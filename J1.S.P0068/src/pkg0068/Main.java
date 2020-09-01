/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0068;

/**
 *
 * @author Buu Huynh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentManager sm = new StudentManager();
        System.out.println("-----------Student Manager-----------");
        sm.addStudent();
        sm.sortStudent();
        sm.display();
    }

}
