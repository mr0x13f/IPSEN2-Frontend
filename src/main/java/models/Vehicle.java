package main.java.models;

import main.java.observables.VehicleObservable;
import main.java.observers.ManagementTabObserver;

import java.util.ArrayList;
import java.util.List;

public class VehicleModel implements VehicleObservable {

    private List<ManagementTabObserver> observers = new ArrayList<>();

    private String licensePlate;
    private String type;

    public void setType(String type) {this.type = type;}

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public void register(ManagementTabObserver mto) {
        observers.add(mto);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(ManagementTabObserver mto : observers){
            mto.update(this);
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }



    public void yourLicensePlate(String licenseCar) {
        licensePlate = licenseCar;
        System.out.println("LicensePlate: "+ licensePlate);
    }

    public void yourCarName(String carName) {
        type = carName;
        System.out.println("Car type: "+ type);
        notifyObservers();

    }



}

