package models;

import observables.Observable;
import observers.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journey{

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
    private boolean isBilled; //Nog toevoegen in de rest van de code
    private String datetime;



    public Journey(int distance, String licensePlate, String destination, int rateId, int projectId, String description, double parkingCost, double otherCost, Boolean isBilled, String datetime) {
        this.distance = distance;
        this.vehicleLicensePlate = licensePlate;
        this.destination = destination;
        this.rateId = rateId;
        this.projectId = projectId;
        this.description = description;
        this.parkingCost = parkingCost;
        this.otherCost = otherCost;
        this.isBilled = isBilled;
        this.datetime = datetime;

        //observer pattern
        //this.observers = new ArrayList<Observer>();
    }

    //DEZE GETTERS NIET VERWIJDEREN!!!

    public int getJourneyId() {
        return journeyId;
    }

    public int getDistance() {
        return distance;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public String getDestination() {
        return destination;
    }

    public int getRateId() {
        return rateId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public double getParkingCost() {
        return parkingCost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public String getIsBilled() {
        if(isBilled){
            return "true";
        }else{
            return "false";
        }
    }

    public String getDatetime() {
        return datetime;
    }
}
