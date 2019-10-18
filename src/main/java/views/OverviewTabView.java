package main.java.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.models.Journey;

import java.net.URL;
import java.util.ResourceBundle;


public class OverviewTabView implements Initializable {

    @FXML private TableView<Journey> overviewTable;
    @FXML private TableColumn<Journey, String> projectColumn;
    @FXML private TableColumn<Journey, String> distanceColumn;
    @FXML private TableColumn<Journey, String> dateColumn;
    @FXML private TableColumn<Journey, String> destinationColumn;
    @FXML private TableColumn<Journey, String> rateColumn;
    @FXML private TableColumn<Journey, String> isBilledColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setup for the columns in the table
        projectColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("projectId"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("distance"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("date"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("destination"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("rateId"));
        isBilledColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("isBilled"));

        //adding dummy data
        overviewTable.setItems(getJourneys());

    }

    public ObservableList<Journey> getJourneys() {
        ObservableList<Journey> journeys = FXCollections.observableArrayList();
        journeys.add(new Journey(50, "12-fx-hg", "Leiden", 18274, 77291, "Omschrijving", 2.50, 0.0, false));

        return journeys;
    }

    private void loadJourneys(){

    }

    private void sortByMonth(){

    }

    private void sortByYear(){

    }

    //misschien ook nog sortByProject ????

}
