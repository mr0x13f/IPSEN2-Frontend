package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private static LoginController lController;

    @FXML
    public  TabPane masterView;

    static {
        lController = new LoginController();
    }

    private LoginController() {

    }

    public static LoginController getInstance() {
        return lController;
    }

    @FXML
    public  void OpenMasterView() throws IOException {
        Stage stage = (Stage) masterView.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/masterView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }


    public void Authencate(){}

    public void AccesGranted(){}

    public void AccesDenied(){}
}
