package main;

import controller.EmployeeManagement;
import controller.OffManagement;
import controller.UserManagement;
import model.Employee;
import model.Login;


import java.util.Scanner;

public class LoginMain {

    private static final Scanner sc = new Scanner(System.in);
    private static final OffManagement offManagement = new OffManagement();

    public void loginMain() {

        checkLogin();
    }

    private static void checkLogin() {
        Login login = new Login();
        System.out.println("Input Account");
        String acc = sc.nextLine();
        System.out.println("Input psw: ");
        String psw = sc.nextLine();
        if (login.adminLoginSystem(acc, psw)) {
            adminLoginSystemSuccess();
        } else if (login.managerLoginSystem(acc, psw)) {
            managerLoginSystemSuccess();
        } else if (login.staffLoginSystem(acc, psw)) {
            staffLoginSystemSuccess();
        } else {
            System.err.println("Account is not exist");
        }
    }
    private static void staffLoginSystemSuccess() {
        int choice = 0;
        do {
            System.out.println("1. Management User");
            System.out.println("2. Management information");
            System.out.println("3. Display information");
            System.out.println("0. Exit");
            System.out.println("Input your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice < 0 || choice > 3 ){
                    System.out.println("you can choose from 0 to 3, please choose again");
                    choice = sc.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                staffLoginSystemSuccess();
            }
            switch (choice) {
                case 1:
                    System.out.println("You do not allowed here ");
                    break;
                case 2:
                    System.out.println("You do not allowed here");
                    break;
                case 3:
                    System.out.println("Your information: ");
                    EmployeeManagement employeeManagement = new EmployeeManagement();
                    for (Employee employee : employeeManagement.getEmployees()) {
                        if (Login.ID_ACCOUNT == employee.getId()) {
                            System.out.printf("%-5S%-20S%-15S%-15S%-15S%-20S%-20S%-20S%-20S%-25S%-10S\n", "ID", "Name", "Birth",
                                    "Gender", "Address", "Department", "Office-Level", "Salary", "Phone.No", "Email", "Status\n");
                            System.out.println(employee.displayInformation());
                        }
                    }
                    break;
            }
        } while (choice != 0);
    }

    private static void managerLoginSystemSuccess() {
        int choice = 0;
        do {
            System.out.println("1. Management User ");
            System.out.println("2. Management information ");
            System.out.println("3. Approved off");
            System.out.println("0. Exit");
            System.out.println("Input your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice < 0 || choice > 3) {
                    System.out.println("you can choose from 0 to 3, please choose again");
                    choice = sc.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                managerLoginSystemSuccess();
            }
            switch (choice) {
                case 1:
                    System.out.println("This is a Function of Admin");
                    break;
                case 2:
                    EmployeeMainByMNG employeeMainByMNG = new EmployeeMainByMNG();
                    employeeMainByMNG.employeeMainByMNG();
                    break;
            }
        } while (choice != 0);
    }

    private static void adminLoginSystemSuccess() {
        int choice = 0;
        do {
            System.out.println("1. Management User ");
            System.out.println("2. Management information ");
            System.out.println("0. Exit");
            System.out.println("Input your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice < 0 || choice > 3) {
                    System.out.println("you can choose from 0 to 2, please choose again");
                    choice = sc.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                adminLoginSystemSuccess();
            }

            switch (choice) {
                case 1:
                    UserMain userMain = new UserMain();
                    userMain.userMain();
                    break;
                case 2:
                    EmployeeMain employeeMain = new EmployeeMain();
                    employeeMain.employeeMain();
                    break;
            }
        } while (choice != 0);
    }

    public static void checkInput(String acc, String psw){
        UserManagement userManagement = new UserManagement();
        while (!userManagement.checkValidateUser(acc) || !userManagement.checkValidatePass(psw)){
            System.out.println("Input Account");
            acc = sc.nextLine();
            System.out.println("Input psw: ");
            psw = sc.nextLine();
        }
    }
}
