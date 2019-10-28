package main.java.views;

import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import main.java.controllers.ManagementTabController;
import main.java.models.Project;
import main.java.models.Vehicle;
import main.java.observables.VehicleObservable;
import main.java.observers.ManagementTabObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagementTabView implements Initializable {

    ManagementTabController ManTCon = new ManagementTabController();

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //

        //Toevoegen gegevens
        CompanyBox.setValue("no company");
        CompanyBox.setItems(CompanyList);

        ProjectBox.setValue("no project");
        ProjectBox.setItems(ProjectList);

        DeleteCarBox.setValue("---");
        DeleteCarBox.setItems(DeleteCarList);

    }

    @FXML
    public void CombineDetails() {
        String Company = CompanyBox.getValue();

        String Project = ProjectBox.getValue();

        try {
            float Rate = Float.valueOf(textRate.getText());

            ManTCon.CombineDetails(Company, Project, Rate);
        } catch (Exception e) {
            System.out.println("Het moet een getal zijn");
        }

    }

    public void CombineCarDetails() {
        String carName = CarInput.getText();

        String licenseCar = LicenseInput1.getText() + "-" + LicenseInput2.getText() + "-" + LicenseInput3.getText();

        ManTCon.CombineCarDetails(carName, licenseCar);

        //Adding the cars to the delete dropdown. so you can delete the car afterwards if you want to
        AddCarToDeleteCars();

    }


    public void AddProjectToDropdown() {

        String projectName = addProjectTextField.getText();
        ProjectList.add(projectName);
        addProjectTextField.setText("");
    }


    public void AddCarToDeleteCars() {
        String carName = CarInput.getText();

        DeleteCarList.add(carName);
    }



    private void addVehicle() {

    }

    private void updateVehicle() {

    }

    private void deleteVehicle() {

    }

    private void addRate() {

    }

    private void updateRate() {

    }

    private void deleteRate() {

    }

    private void addCompany() {

    }

    private void updateCompany() {

    }

    private void deleteCompany() {

    }

    private void addProject() {

    }

    private void updateProject() {

    }

    private void deleteProject() {

    }

}



