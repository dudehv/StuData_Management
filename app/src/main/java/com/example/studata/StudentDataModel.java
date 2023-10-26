package com.example.studata;

import java.io.Serializable;

public class StudentDataModel implements Serializable {
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public StudentDataModel() {
        this.registrationNumber = registrationNumber;
        this.fullname = fullname;
        this.classname = classname;
        this.address = address;
        this.mobile = mobile;


    }

    public StudentDataModel(int image) {
        Image = image;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    String registrationNumber;
    String fullname;
    String classname;
    String address;
    String mobile;
    int Image;


}
