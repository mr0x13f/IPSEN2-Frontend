package controllers;

import models.Journey;
import models.JourneyList;

public class JourneyController {
    private JourneyList journeyList = new JourneyList();

    public JourneyController() {

    }

    public JourneyList getJourneyList() {
        return journeyList;
    }



    public void addJourneyToList(Journey journey){
        journeyList.addJourney(journey);
    }


    public void POSTJourney(){}

    public void GETJourney(){}

    public void EDITJourney(){}

    public void DELETEJourney(){}
}
