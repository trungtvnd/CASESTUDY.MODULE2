package model;

import java.io.Serializable;

public class Employee implements Serializable {
    public static int IDC = 0;
    private int id;
    private Human human;
    private String department;
    private String officeLevel;
    private double salary;
    private boolean status;

    public Employee(Human human, String department, String officeLevel, double salary, boolean status) {
        this.id = ++ IDC;
        this.human = human;
        this.department = department;
        this.officeLevel = officeLevel;
        this.salary = salary;
        this.status = status;
    }

    public Employee(Human human){
        this.human = human;
    }

    public int getId() {
        return id;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Human getHuman() {

        return human;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getofficeLevel() {
        return officeLevel;
    }

    public void setofficeLevel(String officeLevel) {
        this.officeLevel = officeLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String displayStatus (){
        if(isStatus()){
            return "Working";
        }return "Quit Job";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", human=" + human +
                ", department='" + department + '\'' +
                ", officeLevel='" + officeLevel + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    public String displayInformation(){
        return (String.format("%-5d%-20S%-15d%-15S%-15S%-20S%-20S%-20.2f%-20S%-25s%-10S",getId(),
                human.getName(),human.getBirth(), human.getGender(), human.getAddress(), getDepartment(),
                getofficeLevel(), getSalary(), human.getPhoneNumber(), human.getPersonalEmail(), displayStatus()));
    }

}
