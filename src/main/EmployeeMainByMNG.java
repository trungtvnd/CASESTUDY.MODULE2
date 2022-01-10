package main;


import controller.EmployeeManagementByMNG;

import java.util.Scanner;

public class EmployeeMainByMNG {
    private static final Scanner sc = new Scanner(System.in);

    public void employeeMainByMNG() {
        EmployeeManagementByMNG employeeManagementByMNG = new EmployeeManagementByMNG();
        runEmployee(employeeManagementByMNG);
    }


    private void runEmployee(EmployeeManagementByMNG employeeManagementByMNG) {
        int choice = 0;
        do {

            System.out.println("=============MENU=============");
            System.out.println(
                    "1. Add Employee\n" +
                    "2. Edit Employee\n" +
                    "3. Delete Employee\n" +
                    "4. Search Employee by ID\n" +
                    "5. Change Status \n" +
                    "6. Sort by Salary \n" +
                    "7. Display all Employee \n" +
                    "0. Exit \n" +
                    "");
            System.out.println("Input your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice < 0 || choice > 7) {
                    System.out.println("you can choose from 0 to 7, Please choose again");
                    choice = sc.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                runEmployee(employeeManagementByMNG);}
            switch (choice) {
                case 1:
                    employeeManagementByMNG.create();
                    break;
                case 2:
                    employeeManagementByMNG.edit();
                    break;
                case 3:
                    employeeManagementByMNG.delete();
                    break;
                case 4:
                    employeeManagementByMNG.search();
                    break;
                case 5:
                    employeeManagementByMNG.changeStatus();
                    break;
                case 6:
                   employeeManagementByMNG.sortBySalary();
                    break;
                case 7:
                   employeeManagementByMNG.displayTitle();
                    employeeManagementByMNG.display();
                    break;
                case 0:
                    System.out.println("You logged Out");
                    break;
            }

        } while (choice != 0);
    }
}
