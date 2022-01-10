package main;

import controller.UserAdminManagement;


import java.util.Scanner;

public class UserAdminMain {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UserAdminManagement userAdminManagement = new UserAdminManagement();


        runUserAdmin(userAdminManagement);
    }

    private static void runUserAdmin(UserAdminManagement userAdminManagement) {
        int choice = 0;
        do {
            System.out.println("=============MENU=============");
            System.out.println(
                    "1. Add User\n" +
                            "2. Edit User\n" +
                            "3. Change Status\n" +
                            "4. Delete User\n" +
                            "5. Display user\n" +
                            "0. Exit\n" +
                            "");
            System.out.println("Input your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice < 0 || choice > 5) {
                    System.out.println("you can choose from 0 to 5, please choose again");
                    choice = sc.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Please choose a Number");
                runUserAdmin(userAdminManagement);
            }
            switch (choice) {
                case 1:
                    userAdminManagement.create();
                    break;
                case 2:
                    userAdminManagement.edit();
                    break;
                case 3:
                    userAdminManagement.delete();
                    break;
                case 4:
                    userAdminManagement.delete();
                    break;
                case 5:
                    userAdminManagement.displayUserAdmin();
                    break;
            }

        } while (choice != 0);
    }
}


