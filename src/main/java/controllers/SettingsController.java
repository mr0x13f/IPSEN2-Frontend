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
import services.GsonService;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.concurrent.TimeUnit;


public class SettingsController {

    @FXML private ImageView settingsImageView;
    @FXML private AnchorPane settingsPane;
    @FXML private TabPane tabPane;

    private boolean inOptions = false;

    private static HttpURLConnection apiConnection;

    @FXML
    private void settingsButtonAnimation (){

        RotateTransition rt = new RotateTransition(Duration.millis(500), settingsImageView);
        rt.setByAngle(90);
        rt.play();

    }

    @FXML
    private void settingsButtonClick(){
        if(inOptions){
            //ga uit de options
            inOptions = false;
            tabPane.setVisible(true);
            settingsPane.setVisible(false);
        }
        else{
            //ga in de options
            inOptions = true;
            tabPane.setVisible(false);
            settingsPane.setVisible(true);
        }
    }

    @FXML
    private void logOut(){
        System.out.println("Logout");
        try {
            Stage stage = (Stage) settingsPane.getScene().getWindow();
            Parent loginScene = FXMLLoader.load(getClass().getResource("/views/loginView.fxml"));
            stage.setScene(new Scene(loginScene, 1200, 900));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAccount() {
        try {
            URL apiUrl = new URL("http://localhost:8080/journey");
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            String userCredentials = LoginController.username + ":" + LoginController.password;

            //request setup
            apiConnection.setRequestMethod("DELETE");
            apiConnection.setConnectTimeout(5000);
            apiConnection.setReadTimeout(5000);

            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            apiConnection.setRequestProperty ("Authorization", basicAuth);
            apiConnection.setRequestProperty("Accept", "application/json");
            apiConnection.setDoOutput(true);

            int status = apiConnection.getResponseCode();
            System.out.println(status);

            logOut();
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

}
