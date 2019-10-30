package main.java.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import jdk.nashorn.internal.runtime.Version;
import main.java.models.*;
import main.java.models.Rate;
import main.java.models.Vehicle;
import main.java.observers.ManagementTabObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ManagementTabController {
    Company ComModel = new Company();
    Project ProModel = new Project();
    Rate RateModel = new Rate();

    String jsonPath = "main\\res\\JSON\\Cars.json";

    private String jsonfile;



    @FXML private Tab managementTab;

    Gson gson = new Gson();



//    public void addToCarToGson(String carName, String licensePlate){
//        Vehicle vehiclejson = new Vehicle(carName, licensePlate);
//
//        String json = gson.toJson(vehiclejson);
//        System.out.println("dit is de JSON: "+ json);
//
//        Writer fileName = new Writer() {
//            @Override
//            public void write(char[] cbuf, int off, int len) throws IOException {
//
//            }
//
//            @Override
//            public void flush() throws IOException {
//
//            }
//
//            @Override
//            public void close() throws IOException {
//
//            }
//        };
//        try(JsonWriter file = new JsonWriter(fileName)){
//
//
//        } catch (Exception e){
//            System.out.println("gevangen");
//        }
//
//    }

    public void saveJourney(){

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
