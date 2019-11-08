package controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import jdk.nashorn.internal.parser.JSONParser;
import models.Company;
import models.Project;
import models.Rate;
import models.Vehicle;
import observers.ManagementTabObserver;

import java.io.*;

public class ManagementTabController {

    @FXML private Tab managementTab;

    Gson gson = new Gson();

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

    public void createRate(Rate r) {
        try {
            String jsonString = gson.toJson(r);

            FileWriter writer = new FileWriter("savedRates.json");
            writer.append(jsonString); //Can also be: writer.write(jsonString)
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readVehicleFile() {
        try {
            FileReader reader = new FileReader("savedVehicles.json");
            Vehicle newVehicle = gson.fromJson(reader, Vehicle.class);
            System.out.println("Naam van voertuig: " + newVehicle.getType() + "\n" + "Kenteken van voertuig: " + newVehicle.getLicensePlate());
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
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
