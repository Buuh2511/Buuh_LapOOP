/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import data.Fruit;
import data.Order;
import java.util.ArrayList;
import java.util.Hashtable;


public class Manager {

    MyToys mt = new MyToys();
    
    //Show Menu
    public int menu() {
        int choice;
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = mt.checkInputIntLimit(1, 4);
        return choice;
    }

    // Allow user create fruit
    public void createFruit(ArrayList<Fruit> list) {
        while (true) {
            String fruitID = mt.getID("Input Fruit ID (FXXX): ", "Must follow format", "^[F|f]\\d{3}$");
            if (!mt.checkIdExist(list, fruitID)) {
                System.out.println("Id existed");
            } else {
                System.out.print("Enter Fruit Name: ");
                String fruitName = mt.checkInputString();
                int price = mt.checkInputInt("Enter price : ", "Not empty", "Input integer > 0", "Must be an Integer");
                int quantity = mt.checkInputInt("Enter quantity : ", "Not empty", "Input integer > 0", "Must be an Integer");
                System.out.print("Enter origin: ");
                String origin = mt.checkInputString();
                list.add(new Fruit(fruitID, fruitName, price, quantity, origin));
                if (!mt.checkInputYN()) {
                    return;
                }
            }
        }
    }

    //Allow user show order
    public void viewOrder(Hashtable<String, ArrayList<Order>> hasht) {
        if (hasht.isEmpty()) {
            System.out.println("View Order is empty " + "\n");
        } else {
            for (String name : hasht.keySet()) {
                System.out.println("Customer: " + name);
                ArrayList<Order> listOrder = hasht.get(name);
                displayListOrder(listOrder);
            }
        }
    }

    public void shoppingCart(ArrayList<Fruit> lst, Hashtable<String, ArrayList<Order>> listHash) {
        int item;
        if (lst.isEmpty()) {
            System.out.println("No have items.");
        } else {
            ArrayList<Order> lo = new ArrayList<>();
            boolean breakFlag = true;
            
            while(breakFlag){
                displayListFruit(lst);
                System.out.println("Enter item : ");
                int mua = mt.checkInputIntLimit(1, lst.size());
                
                Fruit fruit = getFruitByItem(lst, mua);
                System.out.println("Name : " +fruit.getFruitName());
                System.out.println("Enter quantity : ");
                int quantity = mt.checkInputIntLimit(1, fruit.getQuantity());
                fruit.setQuantity(fruit.getQuantity() - quantity);
                
                if(!mt.checkItemExist(lo, fruit.getFruitId())){
                    updateOrder(lo, fruit.getFruitId(), quantity);
                }else{
                    lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(), quantity, fruit.getPrice()));
                }
                if(fruit.getQuantity() < 1){
                    lst.remove(fruit);
                }
                breakFlag = !(lst.isEmpty() || !mt.checkInputYN());
            }
            displayListOrder(lo);
            System.out.print("Enter name: ");
            String name = mt.checkInputString();
            listHash.put(name, lo);
        }
    }

    public void displayListFruit(ArrayList<Fruit> list) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : list) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-1d$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
                //System.out.println(countItem++ + "\t|\t" + fruit.getFruitName() + "\t|\t" + fruit.getOrigin() + "\t|\t" +fruit.getPrice() + "\t|\t" +fruit.getQuantity());
            }
        }
    }

    //get fruit user want to buy
    public Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void displayListOrder(ArrayList<Order> lo) {
        int total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15d$%15d$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total + "$");
    }

    public void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

}
