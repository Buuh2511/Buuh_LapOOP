/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Student implements Comparable<Student>{

    String ID;
    String Name;
    int Semester;
    String course;

    public Student(String ID, String Name, int Semester, String course) {
        this.ID = ID;
        this.Name = Name;
        this.Semester = Semester;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getSemester() {
        return Semester;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return ID +"\t|" + Name +"\t|" + course +"\t|"+ Semester; 
    }

    @Override
    public int compareTo(Student st) {
       return this.Name.compareTo(st.getName());
    }
   
}
