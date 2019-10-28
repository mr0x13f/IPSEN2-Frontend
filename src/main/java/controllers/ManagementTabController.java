package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import main.java.models.Company;
import main.java.models.Project;
import main.java.models.RateModel;
import main.java.models.VehicleModel;
import main.java.observers.ManagementTabObserver;

public class ManagementTabController {
    Company ComModel = new Company();
    Project ProModel = new Project();
    RateModel RateModel = new RateModel();
    VehicleModel CarModel = new VehicleModel();

    @FXML private Tab managementTab;

    public void saveJourney(){}


    public void CombineDetails(String Company, String Project, float Rate) {
        ComModel.yourCompany(Company);
        ProModel.yourProject(Project);
        RateModel.yourRate(Rate);
    }

    public void CombineCarDetails(String carName, String licenseCar) {
        CarModel.yourLicensePlate(licenseCar);
        CarModel.yourCarName(carName);
    }

    public void CombineSecondCarDetails(String secondCarName, String secondLicenseCar) {

    }

    public void register(ManagementTabObserver mto) {
        CarModel.register(mto);
    }


}
