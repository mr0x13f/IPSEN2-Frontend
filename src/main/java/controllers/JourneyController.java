package controllers;

import models.Journey;
import models.JourneyList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

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

    public void DELETEJourney(String journeyId, String userCredentials) {

        String url = "http://localhost:8080/journey/" + journeyId;
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("DELETE");
            //System.out.println(Base64.getEncoder().encode(userCredentials.getBytes()));
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            connection.connect();

            //console output server response

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Deleted!");
            System.out.println("server response: " + response.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
