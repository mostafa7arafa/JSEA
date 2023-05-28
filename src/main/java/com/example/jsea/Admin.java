package com.example.jsea;

public class Admin extends person{

    private static Admin theAdmin;

    private String password;

    public String getPassword() {
        return password;
    }

    private Admin(String name, int ID)
    {
        setName(name);
        setID(ID);
    }
    private Admin(String name, String password)
    {
        setName(name);
        this.password = password;
    }

    public synchronized static Admin getInstance(String name, int ID)
    {
        if(theAdmin == null)
            theAdmin = new Admin(name,ID);
        return theAdmin;
    }
    public synchronized static Admin getInstance(String name, String p)
    {
        if(theAdmin == null)
            theAdmin = new Admin(name,p);
        return theAdmin;
    }
    public static boolean doesMatch(String pass)
    {
        if(pass.equals(theAdmin.getPassword()))
            return true;
        return false;
    }
}
