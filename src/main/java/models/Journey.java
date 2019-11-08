package models;

import com.google.gson.reflect.TypeToken;
import controllers.LoginController;
import observables.Observable;
import observers.Observer;
import services.GsonService;
import services.HTTPRequestService;

import java.lang.reflect.Type;
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
    private double total;
    private static String projectName;
    private static String previousProjectId;
    private static ProjectList pList = new ProjectList();


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

    //DEZE GETTERS NIET VERWIJDEREN!!!

    public String getProjectId() {
        return this.projectId;
    }

    public int getKilometers() {
        return this.kilometers;
    }

    public String getDateTime() {
        String[] splitDate = date.split(" ");
        String[] splitDay = splitDate[0].split("-");
        return splitDay[2] + " - " + splitDay[1] + " - " + splitDay[0];
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

    public String getStatus() {
        if(this.isBilled == false) {
            return "Niet gefactureerd";
        }
        return "Gefactureerd";
    }

    public String getProjectName() {
        String name = "";
        for(Project p : pList.getProjects()) {
            if(projectId.equals(p.getProjectId())) {
                name = p.getName();
            }
        }
        return name;
    }

    public double getTotalRate() {
        return (Math.round((this.kilometers * this.rate + this.parkingCost + this.otherCost)* 100.0) / 100.0);
    }


}
