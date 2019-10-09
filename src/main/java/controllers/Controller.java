package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML private Label overzichtLabel;
    @FXML private Label enterKilomentersLabel;

    @FXML
    private void gotoOverview() throws IOException {
        Stage stage = (Stage) overzichtLabel.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/overview.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

    @FXML
    private void gotoEnterKilometers() throws IOException {
        Stage stage = (Stage) enterKilomentersLabel.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/EnterKilometers.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }


}
