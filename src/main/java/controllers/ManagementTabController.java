package controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import models.Company;
import models.Project;
import models.Rate;
import models.Vehicle;
import observers.ManagementTabObserver;

import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;

public class ManagementTabController {
    Company ComModel = new Company();
    Project ProModel = new Project();
    Rate RateModel = new Rate();
    Vehicle CarModel = new Vehicle("dummy", "data");

    @FXML private Tab managementTab;

    Gson gson = new Gson();

    //Dummy data
    Vehicle vehicle = new Vehicle("68-kfj-3", "Jaguar E-type");

    public void createVehicle(Vehicle v) {

        try {
            String jsonString = gson.toJson(v);

            FileWriter writer = new FileWriter("savedVehicles.json");
            writer.append(jsonString); //Can also be: writer.write(jsonString)
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void combineDetails(String Company, String Project, float Rate) {
        ComModel.yourCompany(Company);
        ProModel.yourProject(Project);
        RateModel.yourRate(Rate);
    }

//    OBSERVER PATERN
//    public void combineCarDetails(String carName, String licenseCar) {
//        CarModel.yourLicensePlate(licenseCar);
//        CarModel.yourCarName(carName);
//    }
//
//    public void register(ManagementTabObserver mto) {
//        CarModel.register(mto);
//    }


}
