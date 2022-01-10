package model;

import java.io.Serializable;

public class Off implements Serializable {
    private int id;
    private Human human;
    private Employee employee;
    private int dayOff;
    private boolean status;

    public Off(int id,Human human, Employee employee, int dayOff, boolean status) {
        this.id = id;
        this.human = human;
        this.employee = employee;
        this.dayOff = dayOff;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }
    public String checkStatus(){
        if(isStatus()){
            return "Approve";
        }else {
            return "Pending";
        }
    }

    @Override
    public String toString() {
        return (String.format("%-5d%-20S%-10s%-20b\n", getId(), getHuman().getName(), getDayOff(), !isStatus()));
    }

    public String display(){
        return (String.format("%-5d%-20Sd%-10s%-20s\n", getId(), getHuman().getName(), getDayOff(), checkStatus()));

    }

}
