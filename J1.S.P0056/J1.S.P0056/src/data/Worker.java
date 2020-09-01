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
public class Worker implements Comparable<Worker>{
    private String id;
    private String name;
    private double salary;
    private int age;
    private String workLocation;

    public Worker(String id, String name, double salary, int age, String workLocation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.workLocation = workLocation;
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
    
    public double getSalary(){
        return salary;
    }
    
    public void setSalary(){
        this.salary = salary;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    
    public void upSalary(double upSalary){
        salary = salary + upSalary;
    }
    
    public void downSalary(double downSalary){
        salary = salary - downSalary;
    }
    
    public void displayData(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println("WLocation: " + workLocation);
    }

    @Override
    public int compareTo(Worker that) {
        return this.id.compareToIgnoreCase(that.id);
    }
    
    
}
