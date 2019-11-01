package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import models.Journey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Controller for the creation tab where new journeys can be created
 * @version 31-10-2019
 */
public class CreateTabController {

    private static HttpURLConnection apiConnection;

    @FXML private Tab createTab;
    private Journey newJourney;

    /**
     * Takes input from textfields and turns it into a Journey model.
     * Uses the 'checkAllValues' method to guarantee the integrity of the input values.
     * @author Stan
     * @param distance
     * @param licensePlate
     * @param destination
     * @param rateId
     * @param projectId
     * @param description
     * @param parkingCost
     * @param otherCost
     * @param isBilled
     * @param date
     */
    public void saveJourney(int distance, String licensePlate, String destination, int rateId, int projectId, String description, double parkingCost, double otherCost, boolean isBilled, String date){
        connectToApi(); //To test if API works
        if(checkAllValues(distance, rateId, projectId, parkingCost, otherCost)) {
            newJourney = new Journey(distance, licensePlate, destination, rateId, projectId, description, parkingCost, otherCost, isBilled, date);
            System.out.println("Beschrijving: " + newJourney.getDescription());
        }
        else {
            System.out.println("Error gevonden!");
        }
    }

    /**
     * Connects to API
     * @author Stan
     * @version 31-10-2019
     */
    public void connectToApi() {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL apiUrl = new URL("https://jsonplaceholder.typicode.com/albums");
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            //request setup
            apiConnection.setRequestMethod("GET");
            apiConnection.setConnectTimeout(5000);
            apiConnection.setReadTimeout(5000);

            int status = apiConnection.getResponseCode();
            System.out.println(status);

            //no connection
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(apiConnection.getErrorStream()));
                while((line = reader.readLine()) != null ) {
                    responseContent.append(line);
                }
                reader.close();
            }
            //connection successfull
            else {
                reader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
                while((line = reader.readLine()) != null ) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //closes the connection
        finally {
            apiConnection.disconnect();
        }
    }

    /**
     * Checks if the values entered by the user are within the set boundaries.
     * Uses the 'checkIntValue' and 'checkDoubleValue' methods respectively.
     * @author Stan
     * @param distance
     * @param rateId
     * @param projectId
     * @param parkingCost
     * @param otherCost
     * @return
     */
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

    /**
     * Compares if 'variable' falls in between 'minValue' and 'maxValue'.
     * Only works for int values.
     * 'output' is used for the print statement. Enter the name of the textfield 'variable' comes from
     * @author Stan
     * @param variable
     * @param minValue
     * @param maxValue
     * @param output
     * @return
     */
    private boolean checkIntValue(int variable, int minValue, int maxValue, String output) {
        boolean accepted = true;
        if(!(minValue < variable && variable < maxValue)) {
            System.out.println("Ongeldige invoer bij " + output);
            accepted = false;
        }
        return accepted;
    }
    /**
     * Compares if 'variable' falls in between 'minValue' and 'maxValue'.
     * Only works for double values.
     * 'output' is used for the print statement. Enter the name of the textfield 'variable' comes from
     * @author Stan
     * @param variable
     * @param minValue
     * @param maxValue
     * @param output
     * @return
     */
    private boolean checkDoubleValue(double variable, double minValue, double maxValue, String output) {
        boolean accepted = true;
        if(!(minValue < variable && variable < maxValue)) {
            System.out.println("Ongeldige invoer bij " + output);
            accepted = false;
        }
        return accepted;
    }
}
