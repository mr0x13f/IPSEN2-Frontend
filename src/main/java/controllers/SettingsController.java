package main.java.controllers;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;


public class SettingsController {


    @FXML private ImageView settingsImageView;

    @FXML
    private void settingsButtonAnimation (){

        RotateTransition rt = new RotateTransition(Duration.millis(500), settingsImageView);
        rt.setByAngle(90);
        rt.play();

    }

    private void animation() throws InterruptedException{

    }

    @FXML
    private void settingsButtonClick(){
        System.out.println("Click!");
    }
}
