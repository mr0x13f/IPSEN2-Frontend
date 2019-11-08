package views;

import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import controllers.ManagementTabController;
import models.Project;
import models.Vehicle;
import models.Rate;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagementTabView {

    ManagementTabController managementTabController = new ManagementTabController();

    @FXML
    ObservableList<String> CompanyList = FXCollections
            .observableArrayList("EXACT", "DAAR", "DAN");
    @FXML
    ObservableList<String> ProjectList = FXCollections
            .observableArrayList("HOI", "DAAR", "DIE");
    @FXML
    ObservableList<String> DeleteCarList = FXCollections
            .observableArrayList();


    @FXML
    Button AddCar;
    @FXML
    Button AddDetails;
    @FXML
    Button DeleteCar;


    @FXML
    TextField addProjectTextField;
    @FXML
    TextField CarInput;
    @FXML
    TextField LicenseInput1;
    @FXML
    TextField LicenseInput2;
    @FXML
    TextField LicenseInput3;
    @FXML
    TextField textRate;
    @FXML
    Label Rate;


    @FXML
    private ChoiceBox<String> CompanyBox;
    @FXML
    private ChoiceBox<String> ProjectBox;
    @FXML
    private ChoiceBox<String> DeleteCarBox;

    public ManagementTabView() {

    }

    @FXML
    public void combineCarDetails() {
        String carName = CarInput.getText();
        String licenseCar = LicenseInput1.getText() + "-" + LicenseInput2.getText() + "-" + LicenseInput3.getText();

        Vehicle vehicle = new Vehicle(licenseCar, carName);

        managementTabController.createVehicle(vehicle);
        managementTabController.readVehicleFile();
    }

    @FXML
    public void saveNewRate() {
        double userRate = Double.parseDouble(textRate.getText());

        Rate rate = new Rate(userRate);

        managementTabController.createRate(rate);
    }
}



