package com.example.jsea;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Date;
import java.util.Scanner;

public  class Tickets implements Bill{
    private passenger p;
    private  Date resDate;
    private Trip tp;
    private Bill b;

    public Trip getTp() {
        return tp;
    }

    public void setTp(Trip tp) {
        this.tp = tp;
    }

    public passenger getP() {
        return p;
    }

    public void setP(passenger p) {
        this.p = p;
    }


    public Date getResDate() {
        return resDate;
    }

    public Tickets(passenger p,Trip tp) {
        this.p = p;
        resDate = new Date();
        this.tp =tp;
    }

    @Override
//    String theData = content;
//    theData+=breaker+"\n"+(newT.getP()).fetchAll();
//    theData+= "\n"+(newT.getTp()).toString()+"\n";
//    theData+= "The final Cost: "+newT.Discount()+"$\n"+breaker;
    public String toString() {
        return "Ticket{" +
                "passenger=" + p +
                ", Trip" + tp +
                ", Cost"+ Discount()+"$ "+
                '}';
    }
    @Override
    public double CaCost()
    {
        if(tp.getRoute() == "RedSea North")
            return 1700;
        else if(tp.getRoute() == "St.John")
            return 2100;
        else if(tp.getRoute() == "Deadalus")
            return 2050;
        else if(tp.getRoute() == "Satayh")
            return 1900;
        else if(tp.getRoute() == "Abu Fandera")
            return 2500;
        return 2600;
    }
    public static void printTheTicket(Tickets newT) throws IOException {
        BufferedImage image = ImageIO.read(new File("C:\\Users\\Mostafa\\Desktop\\6Th Term\\JSEA\\ticket template\\tic.jpg"));
        //get the Graphics object
        Graphics g = image.getGraphics();
        //set font
        g.setFont(new Font("Ubuntu", Font.PLAIN, 25));
        //display the text at the coordinates(x=50, y=150)
        g.drawString((newT.getP()).toString(), 50, 150);
        g.drawString((newT.getTp()).toString(), 50, 190);
        g.drawString((newT.Discount())+"", 50, 230);
        g.dispose();
        //write the image
        ImageIO.write(image, "png", new File("C:\\Users\\Mostafa\\Desktop\\6Th Term\\JSEA\\Tickets\\ticket_"+(newT.getP()).getName()+".jpg"));
    }

    public static String publishNew(Tickets newT) throws IOException
    {
        File neededData = new File("C:\\Users\\Mostafa\\Desktop\\6Th Term\\JSEA\\current Data\\passangers.txt");
        String breaker = "------------------------------------------------------------------------------";

        String content="";
        Scanner scan = new Scanner(neededData);
        while(scan.hasNextLine())
        {
            content+= scan.nextLine();
            content+="\n";
        }
        scan.close();
        String theData = content;
        theData+=breaker+"\n"+(newT.getP()).fetchAll();
        theData+= "\n"+(newT.getTp()).toString()+"\n";
        theData+= "The final Cost: "+newT.Discount()+"$\n"+breaker;


        PrintWriter print = new PrintWriter(neededData);

        print.print(theData);

        print.close();
        return theData;
    }
    @Override
    public double Discount()
    {
        if(p.getCount() > 15)
            return CaCost() - 300;
        else if(p.getCount() > 10)
            return CaCost() - 200;
        else if(p.getCount() > 2)
            return CaCost() - 30;
        else
            return CaCost();
    }
}
