/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author pc
 */
public class Menu {
    private String menuTitle;
    ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String Option){
        optionList.add(Option);
    }
    
    public void printMenu(){
        if (optionList.isEmpty()){
            System.out.println("There is nothing to print out");
        }
        System.out.println(menuTitle);
        for (String x: optionList) {
            System.out.println(x);
        }
    }
        
        public int getChoice(){
            int maxOption = optionList.size();
            String inputMsg = "Please input number from 1 to " + maxOption + ": ";
            String errMsg = "Please choose number between 1 and " + maxOption;
            return Utils.getInt(inputMsg, errMsg, 1, maxOption, errMsg, errMsg);
        }
    
}
