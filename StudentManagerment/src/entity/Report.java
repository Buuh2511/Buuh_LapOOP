/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Report {
    String ID;
    String Name;
    String course;
    int totalCourse;

    public Report(String ID, String Name, String course, int totalCourse) {
        this.ID = ID;
        this.Name = Name;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCourse() {
        return course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
}
