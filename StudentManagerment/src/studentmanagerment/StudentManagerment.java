/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagerment;

import entity.Student;
import java.util.ArrayList;
import manager.Manager;
import manager.Validation;

/**
 *
 * @author Buu Huynh
 */
public class StudentManagerment {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Manager mng = new Manager();
        Validation vld = new Validation();
        
        boolean running = true;
        ArrayList<Student> liststudent = new ArrayList<>();
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        while (running) {
            System.out.println(" 1. Create");
            System.out.println(" 2. Find and Sort");
            System.out.println(" 3. Update/Delete");
            System.out.println(" 4. Report");
            System.out.println(" 5. Exit");
            System.out.print(" Enter your choice: ");
            int choice = vld.checkInt(1, 5);
            switch (choice) {
                case 1:
                    mng.createStudent(liststudent);
                    break;
                case 2:
                    mng.findAndsortStudent(liststudent);
                    break;
                case 3:
                    mng.updateAnddeleteStudent(liststudent);
                    break;
                case 4:
                    mng.reportStudent(liststudent);
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }

}
