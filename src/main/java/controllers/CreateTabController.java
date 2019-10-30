package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import models.Journey;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateTabController {

    private static HttpURLConnection apiConnection;

    @FXML private Tab createTab;
    private Journey newJourney;

    public void saveJourney(int distance, String licensePlate, String destination, int rateId, int projectId, String description, double parkingCost, double otherCost, boolean isBilled){
        connectToApi();
        if(checkAllValues(distance, rateId, projectId, parkingCost, otherCost)) {
            newJourney = new Journey(distance, licensePlate, destination, rateId, projectId, description, parkingCost, otherCost, isBilled);
            System.out.println("Beschrijving: " + newJourney.getDescription());
        }
        else {
            System.out.println("Error gevonden!");
        }
    }

    public void connectToApi() {
        try {
            URL apiUrl = new URL("https://jsonplaceholder.typicode.com/albums");
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            //request setup
            apiConnection.setRequestMethod("GET");
            apiConnection.setConnectTimeout(5000);
            apiConnection.setReadTimeout(5000);

            int status = apiConnection.getResponseCode();
            System.out.println(status);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkAllValues(int distance, int rateId, int projectId, double parkingCost, double otherCost) {
        boolean accepted = true;
        boolean d = checkIntValue(distance, 0, 1000, "afstand");
        boolean r = checkIntValue(rateId, 10000, 99999, "rate ID");
        boolean p = checkIntValue(projectId, 10000, 99999, "project ID");
        boolean pc = checkDoubleValue(parkingCost, -0.00001, 999.99, "parkeerkosten");
        boolean oc = checkDoubleValue(otherCost, -0.00001, 999.99, "overige kosten");

        if(!(d && r && p && pc && oc)) {
            accepted = false;
        }
        return accepted;
    }

    private boolean checkIntValue(int variable, int minValue, int maxValue, String output) {
        boolean accepted = true;
        if(!(minValue < variable && variable < maxValue)) {
            System.out.println("Ongeldige invoer bij " + output);
            accepted = false;
        }
        return accepted;
    }
    private boolean checkDoubleValue(double variable, double minValue, double maxValue, String output) {
        boolean accepted = true;
        if(!(minValue < variable && variable < maxValue)) {
            System.out.println("Ongeldige invoer bij " + output);
            accepted = false;
        }
        return accepted;
    }
}
