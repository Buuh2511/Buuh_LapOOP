/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0068;

import Utills.utills;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.Scanner;

/**
 *
 * @author Buu Huynh
 */
public class StudentManager {

    ArrayList<Student> listStudent = new ArrayList<Student>();
    Scanner sc = new Scanner(System.in);
    utills utl = new utills();

    public void addStudent() {
        String name;
        String classes;
        String cont;
        float mark;
        do {
            System.out.println("please input student information");
            name = utl.getString("Enter name", "Is not null");
            classes = utl.getString("Enter class", "Is not null");
            mark = utl.getFloat("Enter mark", "mark must be >0", "mark must be number");
            listStudent.add(new Student(name, mark, classes));
            System.out.println("");
            cont = utl.getString("Do u want to continues?", "Y", "N", "Only choose Y|N");
        } while (cont.compareToIgnoreCase("Y") == 0);
    }

    public void sortStudent() {
        sort(listStudent);
    }

    public void display() {
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println("-------------Student " + (i + 1) + "-------------");
            System.out.println("name : " + listStudent.get(i).getName());
            System.out.println("classes :" + listStudent.get(i).getClasses());
            System.out.println("mark : " + listStudent.get(i).getMark());
        }
    }
}
