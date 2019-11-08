package views;

import controllers.JourneyController;
import controllers.OverviewTabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import models.Journey;
import models.JourneyList;
import observables.Observable;
import observers.Observer;

import javax.swing.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * View shows all journeys that the current user owns.
 *
 * @author TimvHal
 * @version 06-11-2019
 */
public class OverviewTabView implements Observer, Initializable {

    @FXML private TableView<Journey> overviewTable;
    @FXML private TableColumn<Journey, String> projectColumn;
    @FXML private TableColumn<Journey, String> distanceColumn;
    @FXML private TableColumn<Journey, String> dateColumn;
    @FXML private TableColumn<Journey, String> destinationColumn;
    @FXML private TableColumn<Journey, String> rateColumn;
    @FXML private TableColumn<Journey, String> isBilledColumn;
    public JourneyController journeyController = new JourneyController();
    public OverviewTabController overviewTabController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setup for the columns in the table
        projectColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectName"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("kilometers"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("DateTime"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("TotalRate"));
        isBilledColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));

        overviewTabController = OverviewTabController.getInstance();
        overviewTabController.getJourneyList().attachObserver(this);
        overviewTable.setItems(overviewTabController.getJourneyList().getJourneys());

        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem = new MenuItem("Delete");
        menuItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                deleteJourney(event);
            }

        });
        contextMenu.getItems().add(menuItem);

        overviewTable.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.SECONDARY){
                    contextMenu.show(overviewTable, event.getScreenX(), event.getScreenY());
                }
            }
        });

    }

    private void deleteJourney(ActionEvent event){
        Journey selectedJourney = overviewTable.getSelectionModel().getSelectedItem();
        String journeyId = selectedJourney.getJourneyId();
        System.out.println(journeyId + "   " + overviewTabController.getUserCredentials());
        journeyController.DELETEJourney(journeyId, overviewTabController.getUserCredentials());

        overviewTable.getItems().removeAll(selectedJourney);

    }



    private void sortByMonth(){

    }

    private void sortByYear(){

    }

    @Override
    public void update(Observable observable) {
        overviewTabController.getJourneyList().getJourneysFromDataBase();
        overviewTable.setItems(overviewTabController.getJourneyList().getJourneys());
    }

}
