package views;

import controllers.JourneyController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Journey;
import observables.Observable;
import observers.Observer;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setup for the columns in the table
        projectColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("projectId"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("distance"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("datetime"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("destination"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("rateId"));
        isBilledColumn.setCellValueFactory(new PropertyValueFactory<Journey, String>("isBilled"));

 
        journeyController = JourneyController.getInstance();
        journeyController.journeyList.attachObserver(this);

        MenuItem mi = new MenuItem("Delete");
        mi.setOnAction((ActionEvent event) -> {
            Journey journey = overviewTable.getSelectionModel().getSelectedItem();
            deleteJourney(journey);
        });

        ContextMenu menu = new ContextMenu();
        menu.getItems().add(mi);
        overviewTable.setContextMenu(menu);


    }

    private void deleteJourney(Journey journey){
        //String journeyId = journey.getJourneyId();

    }

    public void addData(){
        System.out.println((new Random().nextInt(999999)));
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());

        journeyController.addJourneyToList(new Journey((new Random().nextInt(99)),"420-69","van de kaart",(new Random().nextInt(999999)),(new Random().nextInt(999999)),"help me",(new Random().nextInt(12)),(new Random().nextInt(2)),true, timestamp));
    }

    public ObservableList<Journey> loadJourneys(Observable observable) {
        ObservableList<Journey> journeys = FXCollections.observableArrayList();


        journeys.add(new Journey(50, "12-fx-hg", "Leiden", 18274, 77291, "Omschrijving", 2.50, 0.0, false,"datum"));
        overviewTable.setItems(journeyController.journeyList.getJourneys());

        return journeys;
    }


    private void sortByMonth(){

    }

    private void sortByYear(){

    }


    @Override
    public void update(Observable observable) {
        loadJourneys(observable);

    }

    //misschien ook nog sortByProject ????

}
