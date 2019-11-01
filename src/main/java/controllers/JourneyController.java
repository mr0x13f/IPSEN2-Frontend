package controllers;

import models.Journey;
import models.JourneyList;

public class JourneyController {
    static JourneyController journeyController;
    public JourneyList journeyList = new JourneyList();



    public static JourneyController getInstance(){
        if (journeyController == null){
            journeyController = new JourneyController();
        }
        return journeyController;

    }



    public void addJourneyToList(Journey journey){
        journeyList.addJourney(journey);
    }


    public void POSTJourney(){}

    public void GETJourney(){}

    public void EDITJourney(){}

    public void DELETEJourney(){}
}
