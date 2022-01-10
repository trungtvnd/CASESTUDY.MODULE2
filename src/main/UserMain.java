package main;

import controller.UserManagement;

import java.util.Scanner;

public class UserMain {
    private static final Scanner sc = new Scanner(System.in);
    public void userMain() {
        UserManagement userManagement = new UserManagement();


        runUser(userManagement);
    }

    private void runUser(UserManagement userManagement) {
        int choice = 0;
        do {
            System.out.println("-------------------\n");
            System.out.println("============MENU============");
            System.out.println("" +
                    "1. Add User\n" +
                    "2. Edit User\n" +
                    "3. Change Status\n" +
                    "4. Search User\n" +
                    "5. Display user\n" +
                    "0. Exit\n" +
                    "");
            System.out.println("Input your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 5) {
                    System.out.println("you can choose from 0 to 5, please choose again");
                    runUser(userManagement);
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                runUser(userManagement);
            }
            switch (choice) {
                case 1:
                    userManagement.displayUserNeedToCreate();
                    userManagement.create();
                    break;
                case 2:
                    userManagement.edit();
                    break;
                case 3:
                    userManagement.changeStatus();
                    break;
                case 4:
                    userManagement.search();
                    break;
                case 5:
                    userManagement.display();
                    break;
                case 0:
                    System.out.println("Logged out");
                    break;
            }
        } while (choice != 0);
    }
}

