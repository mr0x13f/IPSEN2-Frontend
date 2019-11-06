package views;

import controllers.JourneyController;
import controllers.OverviewTabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Journey;
import models.JourneyList;
import observables.Observable;
import observers.Observer;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class OverviewTabView implements Initializable, Observer {

    @FXML private TableView<Journey> overviewTable;
    @FXML private TableColumn<Journey, String> projectColumn;
    @FXML private TableColumn<Journey, String> distanceColumn;
    @FXML private TableColumn<Journey, String> dateColumn;
    @FXML private TableColumn<Journey, String> destinationColumn;
    @FXML private TableColumn<Journey, String> rateColumn;
    @FXML private TableColumn<Journey, String> isBilledColumn;
    public JourneyController journeyController;
    public OverviewTabController overviewTabController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setup for the columns in the table
        projectColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectId"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("kilometers"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("Rate"));
        isBilledColumn.setCellValueFactory(new PropertyValueFactory<>("IsBilled"));

        overviewTabController = new OverviewTabController();
        overviewTabController.getJourneyList().attachObserver(this);
        overviewTable.setItems(overviewTabController.getJourneyList().getJourneys());

    }

    public void addData(){
        journeyController.addJourneyToList(new Journey(10, "Omschrijving", "Leiden", "06-11-2019", "23-GJK-6", false, 12.50, 1.30, 0.19, "91afb2be-fc88-11e9-a888-b827eb4b9e47"));
    }

 /*   public ObservableList<Journey> loadJourneys(Observable observable) {
        ObservableList<Journey> journeys = FXCollections.observableArrayList();
        journeys.add(new Journey(10, "Omschrijving", "Leiden", "06-11-2019", "23-GJK-6", false, 12.50, 1.30, 0.19,"91afb2be-fc88-11e9-a888-b827eb4b9e47"));
        overviewTable.setItems(journeyController.getJourneyList().getJourneys());

        return journeys;
    }*/


    private void sortByMonth(){

    }

    private void sortByYear(){

    }


    @Override
    public void update(Observable observable) {
        //loadJourneys(observable);
        overviewTabController.getJourneyList().getJourneysFromDataBase();
        overviewTable.setItems(overviewTabController.getJourneyList().getJourneys());
    }

    //misschien ook nog sortByProject ????

}
