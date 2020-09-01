/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Report;
import entity.Student;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Buu Huynh
 */
public class Manager {

    Validation vld = new Validation();

    public void createStudent(ArrayList<Student> listStudent) {
        String ID;
        String Name;
        int Semester;
        String course;
        String check = "Y";
        while (check.equalsIgnoreCase("Y")) {
            ID = vld.getID("Enter ID(SXXX) : ", "You must follow format",
                    "^[S|s]\\d{3}$");
            if (vld.checkID(listStudent, ID)) {
                Name = GetNameOfID(listStudent, ID);
                System.out.println("Name of student ID " + ID + " is: " + Name);
            } else {
                System.out.printf("Input student name : ");
                Name = vld.checkString();
            }
            System.out.printf("Input semeter : ");
            Semester = vld.checkInt(1, 9);
            while (check.equalsIgnoreCase("Y")) {
                System.out.println("Course: ");
                System.out.println("1. Java");
                System.out.println("2. .Net");
                System.out.println("3. C/C++");
                System.out.println("Choice course ");
                int choice = vld.checkInt(1, 3);
                switch (choice) {
                    case 1:
                        course = "Java";
                        if (vld.checkStudent1(listStudent, ID, Name, Semester, course) == true) {
                            listStudent.add(new Student(ID, Name, Semester, course));
                            System.out.println("Add course sucess");
                        } else {
                            System.out.println("Add failed");
                            System.out.println("Duplicate student!");
                        }
                        break;
                    case 2:
                        course = ".Net";
                        if (vld.checkStudent1(listStudent, ID, Name, Semester, course) == true) {
                            listStudent.add(new Student(ID, Name, Semester, course));
                            System.out.println("Add course sucess");
                        } else {
                            System.out.println("Add failed");
                            System.out.println("Duplicate student!");
                        }
                        break;
                    case 3:
                        course = "C/C++";
                        if (vld.checkStudent1(listStudent, ID, Name, Semester, course) == true) {
                            listStudent.add(new Student(ID, Name, Semester, course));
                            System.out.println("Add course sucess!");
                        } else {
                            System.out.println("Add failed");
                            System.out.println("Duplicate student!");
                        }
                        break;
                }
                System.out.println("Would you like to continue adding Course ?? (Y/N)");
                check = vld.checkYesNo();
            }
            System.out.println("Would you like to continue adding Student (Y/N)? Choose Y to continue, N to return to Menu.");
            check = vld.checkYesNo();
        }
    }

    public void findAndsortStudent(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("No student in list!!");
        } else {
            ArrayList<Student> ListSortByName = new ArrayList<>();
            System.out.println("Enter character or name to search : ");
            String Name = vld.checkString();
            for (Student st : listStudent) {
                if (st.getName().contains(Name)) {
                    ListSortByName.add(st);
                }
            }
            if (ListSortByName.isEmpty()) {
                System.out.println("Student not exist !!");
            } else {
                Collections.sort(ListSortByName);

                for (Student st : ListSortByName) {
                    System.out.println(st);
                }
            }
        }
    }

    public void updateAnddeleteStudent(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("No student in list!!");
        } else {
            String check;
            ArrayList<Student> FindStudentByID = new ArrayList<>();
            String ID = vld.getID("Enter ID(SXXX) : ", "You must follow format",
                    "^[S|s]\\d{3}$");
            for (Student s : listStudent) {
                if (s.getID().equalsIgnoreCase(ID)) {
                    FindStudentByID.add(s);
                }
            }
            if (FindStudentByID.isEmpty()) {
                System.out.println("Can not find the student!");
            } else {
                System.out.println("List found student by ID");
                Collections.sort(FindStudentByID);
                for (Student st : FindStudentByID) {
                    System.out.println(st);
                }
                System.out.println("Do you want to update (U) or delete (D) student?");
                check = vld.checkUpdateDelete();
                if (check.equalsIgnoreCase("U")) {
                    System.out.printf("Chose the positon student you want to update : ");
                    int pos = vld.checkInt(1, FindStudentByID.size());
                    for (Student st : listStudent) {
                        if (st.equals(FindStudentByID.get(pos - 1))) {
//                            String newID = vld.getID("Enter ID(SXXX) : ", "You must follow format",
//                    "^[S|s]\\d{3}$");
                            String newID = st.getID();
                            System.out.println("Student ID : " + newID);
                            System.out.printf("Input student name : ");
                            String newName = vld.checkString();
                            System.out.printf("Input semeter : ");
                            int newSemester = vld.checkInt(1, 9);
                            System.out.printf("Input sourse : ");
                            String newCourse = vld.checkCourse();
                            if (vld.checkStudent1(listStudent, newID, newName, newSemester, newCourse)) {
                                st.setID(newID);
                                st.setName(newName);
                                if (vld.checkID(listStudent, newID)) {
                                    for (Student newst : listStudent) {
                                        if (newID.equals(newst.getID())) {
                                            newst.setName(newName);
                                        }
                                    }
                                }
                                st.setSemester(newSemester);
                                st.setCourse(newCourse);
                                System.out.println("Update success");
                            } else {
                                System.out.println("Duplicate student !");
                                System.out.println("Update failed");
                            }
                        }
                    }
                } else if (check.equalsIgnoreCase("D")) {
                    ArrayList<Student> remove = new ArrayList<>();
                    System.out.println("Chose the positon student you want to delete! ");
                    int pos = vld.checkInt(1, FindStudentByID.size());
                    for (Student st : listStudent) {
                        if (st.equals(FindStudentByID.get(pos - 1))) {
                            remove.add(st);
                        }
                    }
                    listStudent.removeAll(remove);
                    System.out.println("Delete successed");
                }
            }
        }
    }

    public void reportStudent(ArrayList<Student> listStudent) {
        if(listStudent.isEmpty()){
            System.out.println("No Student in List");
        }else{
            ArrayList<Report> reportList = new ArrayList<>();
            for (Student st1 : listStudent) {
                int totalCourse = 0;
                for (Student st2 : listStudent) {
                    if(st1.getID().equalsIgnoreCase(st2.getID()) && st1.getName().equalsIgnoreCase(st2.getName()) && st1.getCourse().equalsIgnoreCase(st2.getCourse())){
                        totalCourse++;
                    }
                }
                if(vld.checkReport(reportList, st1.getID(), st1.getName(), st1.getCourse())){
                    reportList.add(new Report(st1.getID(), st1.getName(), st1.getCourse(), totalCourse));
                }
            }
            for (Report report : reportList) {
                System.out.println(report.getName() + "\t|\t" + report.getCourse() + "\t|\t" + report.getTotalCourse());
            }
        }
    }

    public String GetNameOfID(ArrayList<Student> listStudent, String ID) {
        String Name = "";
        for (Student st : listStudent) {
            if (ID.equalsIgnoreCase(st.getID())) {
                Name = st.getName();
            }
        }
        return Name;
    }
}
