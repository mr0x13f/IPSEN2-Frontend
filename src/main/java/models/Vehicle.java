package main.java.models;

import main.java.observables.VehicleObservable;
import main.java.observers.ManagementTabObserver;

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

//    @Override
//    public String toString() {
//        return "Vehicle [licensePlate=" + licensePlate +", type=" + type +"]";
//    }

    @Override
    public void register(ManagementTabObserver mto) {
        observers.add(mto);
        notifyObservers();
    }

    }


//OBSERVER PATTERN
//    @Override
//    public void register(ManagementTabObserver mto) {
//        observers.add(mto);
//        notifyObservers();
//    }
//
//    @Override
//    public void notifyObservers() {
//        for(ManagementTabObserver mto : observers){
//            mto.update(this);
//        }
//    }
//
//    @Override
//    public String getType() {
//        return type;
//    }
//
//    @Override
//    public String getLicensePlate() {
//        return licensePlate;
//    }



    public void yourLicensePlate(String licenseCar) {
        licensePlate = licenseCar;
        System.out.println("LicensePlate: "+ licensePlate);
    }

    public void yourCarName(String carName) {
        type = carName;
        System.out.println("Car type: "+ type);
//        notifyObservers();

    }



}

