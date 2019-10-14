package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import main.java.models.Journey;

public class CreateTabController {

    @FXML private Tab createTab;

    public void saveJourney(String distance, String licensePlate, String destination, String rateId, String projectId, String description, String parkingCost, String otherCost){

        Journey newJourney = new Journey(distance, licensePlate, destination, rateId, projectId, description, parkingCost, otherCost);

        System.out.println(newJourney.getDescription());

    }


}
