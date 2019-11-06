package models;

import observables.VehicleObservable;
import observers.ManagementTabObserver;

import java.util.ArrayList;
import java.util.List;


// implements VehicleObservable
public class Vehicle {

//    OBSERVER PATERN
//    private List<ManagementTabObserver> observers = new ArrayList<>();

    private String licensePlate;
    private String type;

    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//    @Override
//    public String toString() {
//        return "Vehicle [licensePlate=" + licensePlate +", type=" + type +"]";
//    }


    }



