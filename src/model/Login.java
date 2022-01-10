package model;

import controller.UserAdminManagement;
import controller.UserManagement;

public class Login {
    public static int ID_ACCOUNT;
    public static int ID_EMP_MNG = 0;

    public Login() {
    }
    public boolean adminLoginSystem(String acc, String psw) {
        UserAdminManagement userAdminManagement = new UserAdminManagement();
        for (int i = 0; i < userAdminManagement.getUserAdminArrayList().size(); i++) {
            if ((userAdminManagement.getUserAdminArrayList().get(i).getAccount().trim().equals(acc)) && (userAdminManagement.getUserAdminArrayList().get(i).getPassword().trim().equals(psw))
                    && (userAdminManagement.getUserAdminArrayList().get(i).isStatus())) {
                System.out.println("Login successfully, Hello admin: " + userAdminManagement.getUserAdminArrayList().get(i).getAccount());
                return true;
            }
        }
        return false;
    }

    public boolean managerLoginSystem(String acc, String psw) {
        UserManagement userManagement = new UserManagement();
        for (int i = 0; i < userManagement.getUserArrayList().size(); i++) {
            if ((userManagement.getUserArrayList().get(i).getAccount().trim().equals(acc)) && (userManagement.getUserArrayList().get(i).getPassword().trim().equals(psw))
                    && (userManagement.getUserArrayList().get(i).getRole() == 2) && (userManagement.getUserArrayList().get(i).isStatus())) {
                System.out.println("Login successfully, Hello Manager: " + userManagement.getUserArrayList().get(i).getAccount());
                ID_EMP_MNG = findID(acc);
                return true;
            }
        }
        return false;
    }

    public boolean staffLoginSystem(String acc, String psw) {
        UserManagement userManagement = new UserManagement();
        for (int i = 0; i < userManagement.getUserArrayList().size(); i++) {
            if ((userManagement.getUserArrayList().get(i).getAccount().trim().equals(acc)) && (userManagement.getUserArrayList().get(i).getPassword().trim().equals(psw))
                    && (userManagement.getUserArrayList().get(i).getRole() == 1) && (userManagement.getUserArrayList().get(i).isStatus())) {
                System.out.println("Login successfully, Hello Staff: " + userManagement.getUserArrayList().get(i).getAccount());
                ID_ACCOUNT = userManagement.getUserArrayList().get(i).getId();
                return true;
            }
        }
        return false;
    }
    public int findID(String acc){
        int id = 0;
        UserManagement userManagement = new UserManagement();
        for (User user:userManagement.getUserArrayList()) {
            if(user.getAccount().trim().equalsIgnoreCase(acc)){
                id =  user.getId();
            }
        }return id;
    }


}
