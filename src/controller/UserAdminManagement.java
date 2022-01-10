package controller;

import model.Crud;
import IO.IOFile;
import model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class UserAdminManagement implements Serializable, Crud {
    public static final IOFile<User> ioFile_user_admin = new IOFile<>();
    public static final String PATH_NAME_USER_ADMIN = "C:\\TRUNGTV\\HOC TAP\\CODEGYM\\MODULE2\\CASE STUDY\\CASE-VER2\\src\\IO\\saveUserAdmin.txt";
    private static final Scanner sc = new Scanner(System.in);
    private final ArrayList<User> userAdminArrayList;

    public UserAdminManagement (){
        this.userAdminArrayList = readUserAdminFromFile(PATH_NAME_USER_ADMIN);
    }

    public ArrayList<User> getUserAdminArrayList() {
        return userAdminArrayList;
    }

    public void writeUserAdminToFile(String path) {
        ioFile_user_admin .writeObjectToFile(userAdminArrayList, path);
    }

    public ArrayList<User> readUserAdminFromFile(String path) {
        return ioFile_user_admin.readObjectFromFile(path);
    }

    @Override
    public void create() {
        System.out.println("Input Name of Account Admin: "); String acc = sc.nextLine();
        System.out.println("Input Password of Account: "); String psw = sc.nextLine();
        int role = 3;
        User user = new User(acc, psw, role);
        userAdminArrayList.add(user);
        writeUserAdminToFile(PATH_NAME_USER_ADMIN);
    }


    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }

    @Override
    public void display() {

    }

    public void displayUserAdmin(){
        for (User user:userAdminArrayList) {
            System.out.println(user.displayUser());
        }
    }
}
