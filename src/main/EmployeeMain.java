package main;

import controller.EmployeeManagement;
import java.util.Scanner;

public class EmployeeMain {
    private static final Scanner sc = new Scanner(System.in);
    public void employeeMain() {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        runEmployee(employeeManagement);
    }

    private void runEmployee(EmployeeManagement employeeManagement) {
        int choice = 0;
        do {
            System.out.println("-------------------\n");
            System.out.println("============MENU============");
            System.out.println("" +
                    "1. Add Employee\n" +
                    "2. Edit Employee\n" +
                    "3. Delete Employee\n" +
                    "4. Search Employee by ID\n" +
                    "5. Change Status \n" +
                    "6. Sort By Salary \n" +
                    "7. Display By Gender \n" +
                    "8. Display all Employee \n" +
                    "0. Exit \n" +
                    "");
            System.out.println("In put your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice < 0 || choice > 8) {
                    System.out.println("you can choose from 0 to 8, please choose again");
                    choice = sc.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                runEmployee(employeeManagement);}

                switch (choice) {
                    case 1:
                        employeeManagement.create();
                        break;
                    case 2:
                        employeeManagement.edit();
                        break;
                    case 3:
                        employeeManagement.delete();
                        break;
                    case 4:
                        employeeManagement.search();
                        break;
                    case 5:
                        employeeManagement.changeStatus();
                        break;
                    case 6:
                        employeeManagement.sortBySalary();
                        break;
                    case 7:
                        employeeManagement.displayByGender();
                        break;
                    case 8:
                        employeeManagement.display();
                }

        } while (choice != 0);
    }
}


