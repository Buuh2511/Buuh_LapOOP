package j1.s.p0053.pkg42loc;

import java.util.ArrayList;
import utill.utill;

/**
 *
 * @author asus
 */
public class J1SP005342loc {
    static utill utl = new utill();
    public static void inputArray(ArrayList<Integer> ar, int size) {
        for (int i = 0; i < size; i++) {
            ar.add(utl.getInt("Input element " + (i + 1) + " :",
                    "Input an integer", "null"));
        }
    }
    public static void main(String[] args) {
        int size;
        ArrayList<Integer> ar = new ArrayList();
        ArrayList<String> menu = new ArrayList();
        
        menu.add("===================Bubble sort Program=============");
        menu.add("1.Input items of the array");
        menu.add("2.Sort the array in ascending order");
        menu.add("3.Sort the array in descending order");
        menu.add("4.Exit");
        
        int choice;
        do{
            choice = utl.Menu(menu);
            switch(choice){
                case 1 : 
                  ar.clear();
                  size = utl.getInt("Input size of array", "null", "Input an integer!", "Input an integer bigger than 0");
                  inputArray(ar, size);
                  break;
                    
                case 2 :
                    Sortion.sortAccending(ar);
                    System.out.println("Sort Accending : " + ar);
                    break;
                    
                case 3 :
                    Sortion.sortDescending(ar);
                    System.out.println("Sort Descending : " + ar);
                    break;
                    
                case 4 : 
                    System.out.println("The program end");
                    break;
                    
                default:
                    System.out.println("Input [1->4]");
            }
        }while(choice != 4);
    }
    
}
