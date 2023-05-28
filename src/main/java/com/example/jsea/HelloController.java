package com.example.jsea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void Guestbtn(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("guestP1.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    ////////////////////////////////////////////////////
    private static Admin theOnly;

    @FXML
    private Label warningAdmin;

    @FXML
    private TextField nameAdmin;
    @FXML
    private TextField pass;

    @FXML
    Button Login;

    public void AdminBtn(ActionEvent e) throws IOException {
        theOnly = Admin.getInstance("Mostafa","0000");
        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loginCanYou(ActionEvent e) throws IOException
    {

        try
        {

            String name = nameAdmin.getText();
            String p = pass.getText();

            if(name.equals(theOnly.getName()) && Admin.doesMatch(p))
            {
                //login success
                root = FXMLLoader.load(getClass().getResource("adminSucc.fxml"));
                stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else
                throw new Exception();
        }catch (Exception exp)
        {
            warningAdmin.setVisible(true);
        }
    }

    /////////////////////////////////////////////////////

    @FXML
    private TextArea tx;

    public void generateBtn(ActionEvent e)
    {
        String data ="";
        for(Tickets i : GuestController.getAllTickets())
        {
            data+= i.toString();
            data+="\t";
        }
        tx.setText(data);
        tx.setEditable(false);
    }

    public void toHome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}