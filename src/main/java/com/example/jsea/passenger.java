package com.example.jsea;;

public class passenger extends person{

    private int count;

    public passenger(String name, String phoneNo, String gender,int a,String n,int id) {
        setID(id);
        setName(name);
        count++;
        setPhoneNo(phoneNo);
        setGender(gender);
        setAge(a);
        setNation(n);
    }




    public int getCount() {
        return count;
    }

    public void increaseCount(int n){this.count = n;}

    public boolean checkSpecial(passenger pass)
    {
        return (this.getID() == pass.getID());
    }

    @Override
    public String toString() {
        return getName()+", "+getAge()+"years, "+getNation();
    }

    public String fetchAll()
    {
        return String.format(getName()+", "+getAge()+"years, "+getNation()+"\n"+
                getID()+", "+getGender()+", "+getPhoneNo());
    }
}
