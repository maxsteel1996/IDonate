package com.example.yusuf.idonate;

/**
 * Created by YUSUF on 11/14/2016.
 */
public class user {
    String name;
    int phone;
    String email;
    int age;
    boolean male;
    String city;
    int pin;
    String blood;
    String userType;
    public user(){};

    public user(String name,int phone,String email,int age,boolean male,String city,int pin,String blood,String userType){
                 this.name=name;
                 this.phone=phone;
                 this.email=email;
                 this.age=age;
                 this.male=male;
                 this.city=city;
                 this.pin=pin;
                 this.blood=blood;
        this.userType=userType;

            }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isMale() {
        return male;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBlood() {
        return blood;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
