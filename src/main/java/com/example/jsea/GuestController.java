package com.example.jsea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class GuestController implements Initializable {

    private static passenger p; //every cycle there are a new passenger
    private static ArrayList<Tickets> allTickets = new ArrayList<>(); //tickets for the admin
    private static ArrayList<passenger> allPa = new ArrayList<>();
    private static String Fleet;
    private static Trip tp;

    public static ArrayList<Tickets> getAllTickets() {
        return allTickets;
    }

    @FXML
    Button btnTicket;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void toPerson(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("perInfo.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /////////////////////////////////////////////////////////////
    @FXML
    private ImageView whoImage;

    //who are we?

    public void toUs(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whoUs.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //Home page

    public void toHome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //////////////////////////////////////////////////////////////
    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private Button btnNextPI;

    @FXML
    private TextField nameID,ageID,phNo,nation,ID;

    @FXML
    private Label warning,warningTrip;

    public ArrayList<TextField> allTx = new ArrayList<>();


////////////////////////////////////////////////
    @FXML
    private ImageView iv;

    @FXML
    private ChoiceBox<String> BoatCheck;
    @FXML
    private Label warningBoat;


    public void toTrip(ActionEvent e) throws IOException {
        try {
            if(BoatCheck.getValue().length() > 2) {
                Fleet = BoatCheck.getValue();
                root = FXMLLoader.load(getClass().getResource("tripDe.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }catch (Exception exp)
        {
            warningBoat.setVisible(true);
        }

    }

    public void fleetImage(ActionEvent e)
    {
        String loc = "C:\\Users\\Mostafa\\Desktop\\6Th Term\\JSEA\\Yacht\\"+BoatCheck.getValue()+".jpg";
        Image cuurentBoat = new Image(loc);
        iv.setImage(cuurentBoat);
    }


////////////////////////////////////////////////


    @FXML
    private ChoiceBox<String> RouteCheck;

    @FXML
    private TextField countID;

    @FXML
    private DatePicker tripDate;


////////////////////////////////////////////////

    private  String[] fleet = {"C echo II","Golden Dolphin 1","Golden Dolphin 2","Sea EXO","Blue"};
    private String[] routes = {"RedSea North","St.John","Deadalus","Satayh","Abu Fandera"};
    private String[] Gender = {"Male","Female","Engineer"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            myChoiceBox.getItems().addAll(Gender); //for personal information scene
        }catch (Exception e){}

        try { //for trip details scene
            BoatCheck.getItems().addAll(fleet);
            BoatCheck.setOnAction(this::fleetImage);

        }catch (Exception e){}

        try {
            RouteCheck.getItems().addAll(routes);
        }catch (Exception e){}
    }

    public void nextEvent(ActionEvent e) //personal info actions
    {
        if(!checkValid()) {
            warning.setText("Please fill the given fields correctly !!!!");
            warning.setStyle("");
        }
        else {
            try {
                p = new passenger(nameID.getText(), phNo.getText(),
                        myChoiceBox.getValue(), Integer.parseInt(ageID.getText()), nation.getText(), Integer.parseInt(ID.getText()));

                if(checkUnique(p)) //check using ID for discount
                {
                    allPa.add(p);
                }
                else
                {
                    p.increaseCount(HowMany(Integer.parseInt(ID.getText())));
                    allPa.add(p);
                }
                warning.setVisible(false);
                toBoatAc(e);
                //System.out.println(p);
            }catch (NumberFormatException exp)
            {
                warning.setText("Error! please Enter numbers only in age & ID sections");
                warning.setVisible(true);
            }
            catch (Exception exp){}

        }

    }

    public void confirmRes(ActionEvent e) throws IOException {
        try {
            tp = new Trip(RouteCheck.getValue(), tripDate.getValue(), Fleet);
            Tickets newTicket = new Tickets(p,tp);
            allTickets.add(newTicket);
            Tickets.printTheTicket(newTicket); //publishing all information
            Tickets.publishNew(newTicket); //storing all data in text file

            //switch
            root = FXMLLoader.load(getClass().getResource("finalConfirmation.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (Exception exp){ warningTrip.setVisible(true);}
    }


    public boolean checkValid() //for age text filling checking
    {
        allTx.add(nameID);
        allTx.add(ageID);
        allTx.add(phNo);
        allTx.add(nation);
        allTx.add(ID);
        try {
            for (TextField i : allTx) {
                if ((i.getText()).length() < 2) {
                    throw new RuntimeException();
                }
            }
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean checkUnique(passenger p) //for creating new passenger with unique id or increase count of old passenger
    {
        if(allPa.size() < 1)
            return true;
        for(passenger i : allPa)
        {
            if(i.getID() == p.getID())
                return false;
        }
        return true;
    }
    public int HowMany(int n) //certain value of the count of new passenger
    {
        int x=1;
        for(passenger i : allPa)
        {
            if(i.getID() == n)
                x++;
        }
        return x;
    }
    public void toBoatAc(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("boatChoose.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}