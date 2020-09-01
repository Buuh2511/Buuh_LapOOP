/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author pc
 */
public class TrackSalary {
    private String id;
    private String name;
    private double salary;
    private int age;
    private String date;
    private String salaryStatus;

    public TrackSalary(String id, String name, double salary, int age, String date, String salaryStatus) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.date = date;
        this.salaryStatus = salaryStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(){
        this.date = date;
    }
    
    public void printData(){
        System.out.printf("|%-15s|%-15s|%4d|%6.1f|%-15s|%-15s|\n", id, name, age, salary, salaryStatus, date);
    }
    
            
}
