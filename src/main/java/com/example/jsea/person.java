package com.example.jsea;

public abstract class person {
    private String name;
    private String Gender;
    private String phoneNo;
    private int age;
    private String nation;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", ID=" + ID +
                '}';
    }
}
