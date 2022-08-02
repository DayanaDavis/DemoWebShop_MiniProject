package com.demowebshop.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
    Faker faker=new Faker();
    public String firstName(){
        String fName=faker.name().firstName();
        return fName;
    }
    public String lastName(){
        String lName=faker.name().lastName();
        return lName;
    }
    public String eMail(){
        String email=faker.internet().emailAddress();
        return email;
    }
}
