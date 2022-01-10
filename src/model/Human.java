package model;

import java.io.Serializable;

public class Human implements Serializable {

    private String name;
    private int birth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String personalEmail;

    public Human() {
    }

    public Human(String name, int birth, String gender, String address, String phoneNumber, String personalEmail) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.personalEmail = personalEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public String getName() {
        return name;
    }

    public int getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Human{" +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
