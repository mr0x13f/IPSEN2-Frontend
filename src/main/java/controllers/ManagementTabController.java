package main.java.controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import main.java.models.Company;
import main.java.models.Project;
import main.java.models.Rate;
import main.java.models.Rate;
import main.java.models.Vehicle;
import main.java.models.Vehicle;
import main.java.observers.ManagementTabObserver;

import java.io.FileWriter;
import java.io.IOException;

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
            String jasonString = gson.toJson(v);

            FileWriter writer = new FileWriter("%appdata%/kilometerregistratie/savedVehicles.json");
            writer.write(jasonString);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void CombineDetails(String Company, String Project, float Rate) {
        ComModel.yourCompany(Company);
        ProModel.yourProject(Project);
        RateModel.yourRate(Rate);
    }


    //mag waarschijnlijk verwijderd worden
    public void CombineCarDetails(String carName, String licenseCar) {
        CarModel.yourLicensePlate(licenseCar);
        CarModel.yourCarName(carName);
    }

    public void register(ManagementTabObserver mto) {
        CarModel.register(mto);
    }


}
