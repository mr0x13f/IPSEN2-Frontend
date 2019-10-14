package main.java.views;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import main.java.controllers.CreateTabController;

public class CreateTabView {

    @FXML TextField textDistance;
    @FXML TextField textLicensePlate;
    @FXML TextField textDestination;
    @FXML TextField textRateId;
    @FXML TextField textProjectId;
    @FXML TextField textDescription;
    @FXML TextField textParkingCost;
    @FXML TextField textOtherCost;

    CreateTabController createTabController = new CreateTabController();

    @FXML
    private void saveJourney(){
        String distance = textDistance.getText();
        String licensePlate = textLicensePlate.getText();
        String destination = textDestination.getText();
        String rateId = textRateId.getText();
        String projectId = textProjectId.getText();
        String description = textDescription.getText();
        String parkingCost = textParkingCost.getText();
        String otherCost = textOtherCost.getText();

        createTabController.saveJourney(distance, licensePlate, destination, rateId, projectId, description, parkingCost, otherCost);

    }

    private void OverviewTabView(){

    }
}
