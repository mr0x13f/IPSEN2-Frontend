package controllers;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class SettingsController {


    @FXML private ImageView settingsImageView;
    @FXML private AnchorPane settingsPane;
    @FXML private TabPane tabPane;
    @FXML private Label logOutLabel;


    private boolean inOptions = false;

    @FXML
    private void settingsButtonAnimation (){

        RotateTransition rt = new RotateTransition(Duration.millis(500), settingsImageView);
        rt.setByAngle(90);
        rt.play();

    }


    @FXML
    private void settingsButtonClick(){
        loadSettingsTab();
        if(inOptions){
            //ga uit de options
            inOptions = false;
            tabPane.setVisible(true);
            settingsPane.setVisible(false);

        }else{
            //ga in de options
            inOptions = true;
            tabPane.setVisible(false);
            settingsPane.setVisible(true);

        }
    }

    @FXML private void loadSettingsTab(){
        try {
            AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("../../res/views/optionsView"));
            settingsPane.getChildren().add(newLoadedPane);
        }catch (Exception e){}
    }

    @FXML
    private void logOut(){
        System.out.println("Logout");
        //todo loguit
        try {
            Stage stage = (Stage) settingsPane.getScene().getWindow();
            Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/loginView.fxml"));
            stage.setScene(new Scene(overviewScene, 1200, 900));
        }catch (Exception e){}

    }

}
