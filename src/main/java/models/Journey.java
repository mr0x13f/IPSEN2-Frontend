package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Journey {

    private int journeyId;
    private int distance;
    private String vehicleLicensePlate;
    private String destination;
    private int rateId;
    private int projectId;
    private String description;
    private double parkingCost;
    private double otherCost;
    private int creatorId;
    private List observers;
    private boolean isBilled; //Nog toevoegen in de rest van de code



    public Journey(int distance, String licensePlate, String destination, int rateId, int projectId, String description, double parkingCost, double otherCost, Boolean isBilled) {
        this.distance = distance;
        this.vehicleLicensePlate = licensePlate;
        this.destination = destination;
        this.rateId = rateId;
        this.projectId = projectId;
        this.description = description;
        this.parkingCost = parkingCost;
        this.otherCost = otherCost;
        this.isBilled = isBilled;

        //observer pattern
        //this.observers = new ArrayList<ViewInterface>();
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public int getKilometers() {
        return distance;
    }

    public void setKilometers(int kilometers) {
        this.distance = kilometers;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost(double parkingCost) {
        this.parkingCost = parkingCost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(double otherCost) {
        this.otherCost = otherCost;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

//    private void notifyObservers(){
//        for (int i = 0; i< observers.size(); i++){
//            observers.get(i).update(this);
//        }
//    }

}
