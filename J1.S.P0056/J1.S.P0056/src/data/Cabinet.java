/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author pc
 */
public class Cabinet {

    ArrayList<Worker> folder = new ArrayList();
    ArrayList<TrackSalary> folder1 = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public void addWorkerData() {
        String id, name, workLocation, check;
        double salary;
        int age, pos;
        System.out.println("==============================================");
        do {
            do {
                id = Utils.getID("Input ID(Wxxx) x stands for digits: ", "ID must follow the format with Wxxx, x stand for digits", "^[W|w]\\d{3}$");
                pos = findWorkerByID(id);
                if (pos >= 0) {
                    System.out.println("The id is aldready existed!! Please input another one.");
                }
            } while (pos != -1);
            name = Utils.getString("Input name: ", "It is required");
            age = Utils.getInt("Input age: ", "It is required", 18, 50, "Age must be greater than 18!", "Age must be less than 50!");
            salary = Utils.getDouble("Input salary: ", "It is required", 0, "Salary must be greater than 0");
            workLocation = Utils.getString("Input w.location: ", "It is required");
            folder.add(new Worker(id, name, salary, age, workLocation));
            System.out.println("Data is added successfully");
            check = Utils.check("Do you want to continue adding information?(Y/N)", "Please input only Y or N");
            if (check.equalsIgnoreCase("Y"))
                System.out.println("==============================================");
        } while (!check.equalsIgnoreCase("N"));
    }

    public int findWorkerByID(String id) {
        if (folder.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < folder.size(); i++) {
            if (folder.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Worker findWorkerByObject(String id) {
        if (folder.isEmpty()) {
            return null;
        }
        for (int i = 0; i < folder.size(); i++) {
            if (folder.get(i).getId().equalsIgnoreCase(id)) {
                return folder.get(i);
            }
        }
        return null;
    }

    public void upSalary() {
        double upSalary;
        Worker x;
        String id;
        System.out.println("==============================================");
        if (folder.isEmpty()) {
            System.out.println("There is no data in folder");
        }
        id = Utils.getID("Input ID(Wxxx) x stands for digits: ", "ID must follow the format with Wxxx, x stand for digits", "^[W|w]\\d{3}$");
        x = findWorkerByObject(id);
        if (x == null) {
            System.out.println("Not found!!");
        } else {
            upSalary = Utils.getDouble("Input bonus salary: ", "It is required", 0, "Bonus salary must be greater than 0");
            x.upSalary(upSalary);
            folder1.add(new TrackSalary(id, x.getName(), x.getSalary(), x.getAge(), Utils.getDate(), "UP"));
        }
    }

    public void downSalary() {
        double downSalary;
        Worker x;
        String id;
        System.out.println("==============================================");
        if (folder.isEmpty()) {
            System.out.println("There is no data in folder");
        }
        id = Utils.getID("Input ID(Wxxx) x stands for digits: ", "ID must follow the format with Wxxx, x stand for digits", "^[W|w]\\d{3}$");
        x = findWorkerByObject(id);
        if (x == null) {
            System.out.println("Not found!!");
        } else {
            do{
                downSalary = Utils.getDouble("Input down salary: ", "It is required", 0, "Down salary must be greater than 0");
            if (downSalary > x.getSalary())
                System.out.println("Can not be less than 0");
            }while (downSalary > x.getSalary());
            x.downSalary(downSalary);
            folder1.add(new TrackSalary(id, x.getName(), x.getSalary(), x.getAge(), Utils.getDate(), "DOWN"));
        }
    }

    public void printData() {
        System.out.println("==============================================");
        if (folder1.isEmpty()) {
            System.out.println("There is no data in folder");
        }
        String header = String.format("|%-15s|%-15s|%4s|%5s|%-15s|%-15s|", "ID", "NAME", "AGE", "SALARY", "SALARYSTATUS", "DATE");
        System.out.println(header);
        Collections.sort(folder);
        for (TrackSalary x : folder1) {
            x.printData();
        }
    }
}
