package controller;

import IO.IOFile;
import model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class OffManagement implements Crud, Serializable {
    private static final Scanner sc = new Scanner(System.in);
    public static final String OFF_PATH = "C:\\TRUNGTV\\HOC TAP\\CODEGYM\\MODULE2\\CASE STUDY\\CASE-VER2\\src\\IO\\saveFileOff.txt";
    private static final IOFile<Off> offIOFile = new IOFile<>();
    private final EmployeeManagement employeeManagement = new EmployeeManagement();
    private final ArrayList<Off> offs;

    public OffManagement() {
        this.offs = readOffFromFile(OFF_PATH);
    }

    public ArrayList<Off> getOffs() {
        return offs;
    }

    public void writeOffToFile(String path) {
        offIOFile.writeObjectToFile(offs, path);
    }

    public ArrayList<Off> readOffFromFile(String path) {
        return offIOFile.readObjectFromFile(path);
    }

    @Override
    public void create() {
        System.out.println("Input your id: ");
        int id = sc.nextInt();
        Human human = null;
        for (Employee employee : employeeManagement.getEmployees()) {
            if (id == employee.getId()) {
                human = employee.getHuman();
            }
        }
        Employee employee = new Employee(human);
        System.out.println("Input number of Days you want to off"); int dayOff = sc.nextInt();
        boolean status = false;
        Off off1 = new Off(id,human, employee, dayOff, status);
        offs.add(off1);
        writeOffToFile(OFF_PATH);
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {
        System.out.println("Input id you want to approve: "); int id = sc.nextInt();
        Off offDelete = null;
        for (Off off:offs) {
            if(off.getEmployee().getId() == id){
                offDelete = off;
            }
        }offs.remove(offDelete);
        writeOffToFile(OFF_PATH);
    }

    @Override
    public void search() {
    }

    @Override
    public void display() {
        for (Off off:offs) {
            System.out.println(off.display());
        }
    }

    public boolean checkOff() {
        sc.nextLine();
        System.out.println("Would you like to Approve ");
        System.out.println("1. Yes\n" +
                "0. No/Quit\n" +
                "");
        System.out.println("Input your choice");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
            while (choice < 0 || choice > 1) {
                System.out.println("you can choose from 0 to 1, please choose again");
                choice = sc.nextInt();
                if (choice == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("please input number");
            checkOff();
        }
        return false;
    }
    public void approveOff(){
        Off offApprove;
        System.out.println("Input id you want to approve: "); int id = sc.nextInt();
        for (Off off:offs) {
            if(id == off.getEmployee().getId()){
                offApprove = off;
                offApprove.setStatus(false);
                writeOffToFile(OFF_PATH);
                display();
            }
        }
    }


}