package com.example.a8you;

import java.util.ArrayList;

public class User {

    public String fullname, email, weight, height, age, bmi;
    public ArrayList<String> userDataArray;
    public User(){
    }

    public enum genderEnum {
        MALE, FEMALE, Other;
    }
    public User(String fullname, String email){
        this.fullname = fullname;
        this.email = email;
    }

    public User( String height , String weight, String age){
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public double setBmi(){
        double bmiD = Double.valueOf(weight) / Math.pow(Double.valueOf(height), 2);
//        bmi = String.valueOf(bmiD);
        return bmiD;
    }

    public void readDatabase() {

    }
//    public String gender(String gender) {
//        if (gender.equalsIgnoreCase("male")){
//            gender = "male";
//        } else
//        return gender
//    }
}
