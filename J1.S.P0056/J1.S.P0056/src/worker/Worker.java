/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import data.Cabinet;
import ui.Menu;

/**
 *
 * @author pc
 */
public class Worker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cabinet cage = new Cabinet();
        int choice;
        Menu menu = new Menu("==================WorkerData==================");
        menu.addNewOption("1-Add Worker");
        menu.addNewOption("2-Up Salary");
        menu.addNewOption("3-Down Salary");
        menu.addNewOption("4-Display information salary");
        menu.addNewOption("5-Exit");
        do {
            menu.printMenu();
            switch (choice = menu.getChoice()) {
                case 1:
                    cage.addWorkerData();
                    break;
                case 2: 
                    cage.upSalary();
                    break;
                case 3:
                    cage.downSalary();
                    break;
                case 4:
                    cage.printData();
                    break;
                case 5:
                    System.out.println("See you again!");
                    break;
            }
        } while (choice < 5);

    }

}
