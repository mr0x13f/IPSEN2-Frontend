package views;

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
import controllers.ManagementTabController;
import models.Project;
import models.Vehicle;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagementTabView implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Toevoegen gegevens
        CompanyBox.setValue("no company");
        CompanyBox.setItems(CompanyList);

        ProjectBox.setValue("no project");
        ProjectBox.setItems(ProjectList);

        DeleteCarBox.setValue("---");
        DeleteCarBox.setItems(DeleteCarList);

    }

    @FXML
    public void combineDetails() {
        String Company = CompanyBox.getValue();
        String Project = ProjectBox.getValue();
        try {
            float Rate = Float.valueOf(textRate.getText());

            managementTabController.combineDetails(Company, Project, Rate);
        } catch (Exception e) {
            System.out.println("Het moet een getal zijn");
        }
    }

    public void combineCarDetails() {
        String carName = CarInput.getText();
        String licenseCar = LicenseInput1.getText() + "-" + LicenseInput2.getText() + "-" + LicenseInput3.getText();

        Vehicle vehicle = new Vehicle(licenseCar, carName);

        managementTabController.createVehicle(vehicle);
        managementTabController.readVehicleFile();

        //Adding the cars to the delete dropdown. so you can delete the car afterwards if you want to
        //addCarToDeleteCars();

    }

    public void addProjectToDropdown() {
        String projectName = addProjectTextField.getText();
        ProjectList.add(projectName);
        addProjectTextField.setText("");
    }

    public void addCarToDeleteCars() {
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



