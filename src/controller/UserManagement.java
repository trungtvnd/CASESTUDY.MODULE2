package controller;

import model.Crud;
import IO.IOFile;
import model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManagement implements Serializable, Crud {
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final String USER_REGEX = "^[a-z0-9._-]{3,15}$";
    public static final IOFile<User> ioFile_user = new IOFile<>();
    public static final String PATH_NAME_USER = "C:\\TRUNGTV\\HOC TAP\\CODEGYM\\MODULE2\\CASE STUDY\\CASE-VER2\\src\\IO\\saveUser.txt";
    private static final Scanner sc = new Scanner(System.in);
    private final EmployeeManagement employeeManagement = new EmployeeManagement();
    private final ArrayList<User> userArrayList;

    public UserManagement() {
        this.userArrayList = readUserFromFile(PATH_NAME_USER);

    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void writeUserToFile(String path) {
        ioFile_user.writeObjectToFile(userArrayList, path);
    }

    public ArrayList<User> readUserFromFile(String path) {
        return ioFile_user.readObjectFromFile(path);
    }

    @Override
    public void create() {
        System.out.println("Input ID you want to create Account: ");
        String idCheck = sc.next();
        if (checkValidateId(idCheck)) {
            int id = Integer.parseInt(idCheck);
            sc.nextLine();
            System.out.println("Input Name of Account: ");
            String acc = sc.nextLine();
            System.out.println("Input Password of Account: ");
            String psw = sc.nextLine();
            System.out.println("Input role of account (1/2/3 - Staff/Manager/Admin)");
            int role = sc.nextInt();
            if (checkIdUser(id) && checkIdEmp(id) && checkAccount(acc)) {
                User user = new User(id, acc, psw, role);
                userArrayList.add(user);
                writeUserToFile(PATH_NAME_USER);
                System.out.println("Add User success");
            } else {
                System.out.println("ID you input not exist or acc name existed, please try again");
            }
        }
    }

    @Override
    public void edit() {
        boolean flag = false;
        System.out.println("Input ID you want to edit Account: ");
        int id = sc.nextInt();
        sc.nextLine();
        User userEdit;
        for (User user : userArrayList) {
            if (id == user.getId()) {
                flag = true;
                userEdit = user;
                System.out.println("Input Password of Account: ");
                userEdit.setPassword(sc.nextLine());
                System.out.println("Input role of account (1/2/3 - Staff/Manager/Admin)");
                userEdit.setRole(sc.nextInt());
                writeUserToFile(PATH_NAME_USER);
                System.out.println("Edit User Success");
            } else {
                flag = false;
            }
        }if(flag){
            System.out.println("Edit successfully");
        }else {
            System.out.println("ID you input not exist, please try again");
        }

    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {
        System.out.println("Input ID you want to edit Account: ");
        int id = sc.nextInt();
        for (User user : userArrayList) {
            if (id == user.getId()) {
                System.out.println(user.displayUser());
            }
        }
    }

    public void changeStatus() {
        System.out.println("Input ID you want to edit Account: ");
        int id = sc.nextInt();
        boolean flag = false;
        sc.nextLine();
        User userChangeStatus;
        for (User user : userArrayList) {
            if (id == user.getId()) {
                flag = true;
                userChangeStatus = user;
                userChangeStatus.setStatus(false);
                writeUserToFile(PATH_NAME_USER);
            } else {
                flag = false;
            }
        }
        if(flag){
            System.out.println("Change status success");
        }else {
            System.out.println("ID you input not exist, please try again");
        }
    }

    public void display() {
        System.out.printf("%-5S%-20S%-20S%-20S%-20S\n", "ID", "ACCOUNT", "PASSWORD", "ROLE", "STATUS");
        for (User user : userArrayList) {
            System.out.println(user.displayUser());
        }
    }

    public void displayUserNeedToCreate() {
        System.out.println("ID DOES NOT HAVE ACCOUNT");
        if (userArrayList.size() == 0) {
            employeeManagement.display();
        } else {
            HashSet<Integer> integers = new HashSet<>();
            for (User user : userArrayList) {
                for (int i = 0; i < employeeManagement.getEmployees().size(); i++) {
                    if (user.getId() != employeeManagement.getEmployees().get(i).getId()
                            && checkIDDouble(employeeManagement.getEmployees().get(i).getId())) {
                        integers.add(i);
                    }
                }
            }
            for (Integer integer : integers) {
                System.out.println(employeeManagement.getEmployees().get(integer).displayInformation());
            }
        }
    }

    private void displayTitle() {
        System.out.printf("%-5S%-20S%-15S%-15S%-15S%-20S%-20S%-20S%-20S%-25S%-10S\n", "ID", "Name", "Birth",
                "Gender", "Address", "Department", "Office-Level", "Salary", "Phone.No", "Email", "Status\n");
    }

    public boolean checkIDDouble(int id) {
        for (User user : userArrayList) {
            if (id == user.getId()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIdUser(int id) {
        for (User user : userArrayList) {
            if (id == user.getId()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIdEmp(int id) {
        for (int i = 0; i < employeeManagement.getEmployees().size(); i++) {
            if (id == employeeManagement.getEmployees().get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAccount(String acc) {
        for (User user : userArrayList) {
            if (user.getAccount().trim().equalsIgnoreCase(acc)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkValidateId(String id) {
        String digit = "\\d";
        if (!id.matches(digit)) {
            System.out.println("Please input a Integer Number");
            return false;

        }
        return true;
    }

    public boolean checkValidatePass(String regex){
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher;

        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkValidateUser(String regex){
        Pattern pattern = Pattern.compile(USER_REGEX);
        Matcher matcher;

        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}


