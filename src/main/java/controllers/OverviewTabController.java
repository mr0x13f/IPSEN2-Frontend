package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import models.Journey;
import models.JourneyList;

public class OverviewTabController {

    @FXML
    private Tab overviewTab;
    private JourneyList jList;
    private JourneyController journeyController;

    public OverviewTabController() {
        journeyController = new JourneyController();
    }

    public JourneyList getJourneyList() {
        return journeyController.getJourneyList();
    }

    public void addJourneyToList(Journey j) {
        journeyController.addJourneyToList(j);
    }
}
