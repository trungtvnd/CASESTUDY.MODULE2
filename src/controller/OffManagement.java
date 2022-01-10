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
        Off off1 = new Off(id,human, employee, dayOff);
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
            System.out.println(off);
        }
    }

    public void approveOff(){
        Off offApprove;
        boolean flag = false;
        System.out.println("Input id you want to approve: "); int id = sc.nextInt();
        for (Off off:offs) {
            if(id == off.getEmployee().getId()){
                flag = true;
                offApprove = off;
                offApprove.setStatus(true);
                writeOffToFile(OFF_PATH);
            }
            else {
                flag = false;
            }
        }if(flag){
            System.out.println("Approve Success");
        }else {
            System.out.println("Do not allowed");
        }
    }


}
