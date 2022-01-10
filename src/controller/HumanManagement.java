package controller;

import model.Human;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumanManagement {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONE_REGEX = "^\\([0-9]{2,4}\\)\\-\\(0[0-9]{9,10}\\)$";
    private static final Scanner sc = new Scanner(System.in);
    public Human createHuman(){
        System.out.println("Input name "); String name = sc.nextLine();
        System.out.println("Input birth"); int birth = sc.nextInt();
        String gender = chooseGender(); sc.nextLine();
        System.out.println("Input Address: "); String address = sc.nextLine();
        System.out.println("Input phone Number"); String phone = sc.nextLine();
        System.out.println("Input Email"); String email = sc.nextLine();
        while (!checkValidatePhone(phone) || !checkValidateEmail(email)){
            System.out.println("Please check validate Phone and Email");
            System.out.println("Input phone Number");  phone = sc.nextLine();
            System.out.println("Input Email");  email = sc.next();
        }
        return new Human(name, birth, gender, address, phone, email);
    }

    public String chooseGender() {
        System.out.println("1. Male\n" +
                "2. Female\n" +
                "3. Other\n");
        System.out.println("Choose Gender: ");
        String gender = null;
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Other";
                break;
        }
        return gender;
    }

    public boolean checkValidateEmail(String regex){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher;

        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean checkValidatePhone(String regex){

        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher;

        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
