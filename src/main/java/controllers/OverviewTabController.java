package controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import models.Journey;
import models.JourneyList;
import views.OverviewTabView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class OverviewTabController {

    @FXML
    private Tab overviewTab;
    private JourneyList jList;
    private JourneyController journeyController;
    private static OverviewTabController overviewTabController;
    private String userCredentials;

    public static synchronized OverviewTabController getInstance(){
        if(overviewTabController == null){
            overviewTabController = new OverviewTabController();
        }
        return overviewTabController;
    }



    public OverviewTabController() {
        journeyController = new JourneyController();
    }

    public JourneyList getJourneyList() {
        return journeyController.getJourneyList();
    }

    public void addJourneyToList(Journey j) {
        journeyController.addJourneyToList(j);
    }

    public void deleteJourneyFromDB(String journeyId){
        journeyController.DELETEJourney(journeyId, getUserCredentials());
    }

    public void setUserCredentials(String userCredentials) {
        this.userCredentials = userCredentials;
    }

    public String getUserCredentials(){
        return userCredentials;
    }
}


