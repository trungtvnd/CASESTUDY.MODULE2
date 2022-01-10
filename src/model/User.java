package model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String account;
    private String password;
    private int role;
    private boolean status = true;

    public User(int id, String account, String password, int role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
    }
    public User(String account, String password, int role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String displayUser(){
        return (String.format("%-5d%-20s%-20s%-20d%-20b", getId(), getAccount(), getPassword(), getRole(), isStatus())) ;
    }
}
