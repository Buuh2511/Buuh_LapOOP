/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Buu Huynh
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]  ");
                System.out.printf("Enter again : ");
            }
        }
    }

    public String checkString() {
        while (true) {
            String result = sc.nextLine().trim().toUpperCase();
            if (result.isEmpty()) {
                System.out.println("String not be empty!");
                System.out.println("Please input again");
            } else {
                return result;
            }
        }
    }

    public String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public boolean checkID(ArrayList<Student> studentlist, String ID) {
        for (Student st : studentlist) {
            if (ID.equalsIgnoreCase(st.getID())) {
                return true;
            }
        }
        return false;
    }

    public String checkYesNo() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("String not be empty!");
                System.out.println("Please input again");
            } else if (!result.equalsIgnoreCase("Y") && !result.equalsIgnoreCase("N")) {
                System.out.println("Please input Y(yes) or N(no)");
            } else {
                return result;
            }
        }
    }

    public String checkUpdateDelete() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("String not be empty!");
                System.out.println("Please input again");
            } else if (!result.equalsIgnoreCase("U") && !result.equalsIgnoreCase("D")) {
                System.out.println("Please input U(Update) or D(Delete)");
            } else {
                return result;
            }
        }
    }

    public String checkCourse() {
        while (true) {
            String course = sc.nextLine().trim();
            if (course.isEmpty()) {
                System.out.println("Course not be empyy");
            } else if (!course.equalsIgnoreCase("Java") && !course.equalsIgnoreCase(".Net") && !course.equalsIgnoreCase("C/C++")) {
                System.out.println("Cousre must be (Java,.Net,C/C++)");
            } else {

                return course;
            }
        }
    }

    public boolean checkStudent1(ArrayList<Student> studentlist, String ID, String Name, int Semeter, String course) {
        for (Student st : studentlist) {
            if (ID.equalsIgnoreCase(st.getID()) && Name.equalsIgnoreCase(st.getName()) && Semeter == st.getSemester() && course.equalsIgnoreCase(st.getCourse())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkReport(ArrayList<Report> reportlist, String ID, String name, String course) {
        for (Report report : reportlist) {
            if (ID.equalsIgnoreCase(report.getID()) && name.equalsIgnoreCase(report.getName()) && course.equalsIgnoreCase(report.getCourse())) {
                return false;
            }
        }
        return true;
    }
}
