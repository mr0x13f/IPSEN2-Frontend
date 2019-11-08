package models;

import observables.Observable;
import observers.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journey{

    private String journeyId;
    private int kilometers;
    private String destination;
    private String description;
    private String date;
    private String licensePlate;
    private boolean isBilled;
    private double parkingCost;
    private double otherCost;
    private double rate;
    private String projectId;
    private String creatorId;

    /**
     * Constructor excluding journeyID and creatorId
     * @author Stan
     * @version 6-11-2019
     */
    public Journey(int kilometers, String destination, String description, String date, String licensePlate, boolean isBilled, double parkingCost, double otherCost, double rate, String projectId) {
        this.kilometers = kilometers;
        this.destination = destination;
        this.description = description;
        this.date = date;
        this.licensePlate = licensePlate;
        this.isBilled = isBilled;
        this.parkingCost = parkingCost;
        this.otherCost = otherCost;
        this.rate = rate;
        this.projectId = projectId;

        //observer pattern
        //this.observers = new ArrayList<Observer>();
    }

    /**
     * Constructor including journeyID as the last parameter
     * @author Stan
     * @version 6-11-2019
     */
    public Journey(int kilometers, String destination, String description, String date, String licensePlate, boolean isBilled, double parkingCost, double otherCost, double rate, String projectId, String creatorId, String journeyId) {
        this.kilometers = kilometers;
        this.destination = destination;
        this.description = description;
        this.date = date;
        this.licensePlate = licensePlate;
        this.isBilled = isBilled;
        this.parkingCost = parkingCost;
        this.otherCost = otherCost;
        this.rate = rate;
        this.projectId = projectId;
        this.creatorId = creatorId;
        this.journeyId = journeyId;

        //observer pattern
        //this.observers = new ArrayList<Observer>();
    }

    //DEZE GETTERS NIET VERWIJDEREN!!! IS VOOR DE TABEL

    public String getProjectId() {
        return this.projectId;
    }

    public int getKilometers() {
        return this.kilometers;
    }

    public String getDate() {
        return this.date;
    }

    public String getDestination() {
        return this.destination;
    }

    public double getRate() {
        return this.rate;
    }

    public boolean getIsBilled() {
        return this.isBilled;
    }

    ///

    public String getJourneyId() { return this.journeyId; }


}
