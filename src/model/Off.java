package model;

import java.io.Serializable;

public class Off implements Serializable {
    private int id;
    private final Human human;
    private Employee employee;
    private final int dayOff;
    private boolean status = false;

    public Off(int id,Human human, Employee employee, int dayOff) {
        this.id = id;
        this.human = human;
        this.employee = employee;
        this.dayOff = dayOff;
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
    public int getDayOff() {
        return dayOff;
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
        return (String.format("%-5d%-20Sd%-10s%-20s\n", getId(), getHuman().getName(), getDayOff(), isStatus()));
    }


}
