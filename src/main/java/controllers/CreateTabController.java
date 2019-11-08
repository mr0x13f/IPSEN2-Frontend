package controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import models.Journey;
import services.GsonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * Controller for the creation tab where new journeys can be created
 * @author Stan, TimvHal
 * @version 06-11-2019
 */
public class CreateTabController {

    private static HttpURLConnection apiConnection;

    private Journey newJourney;
    private JourneyController journeyController = new JourneyController();

    /**
     * Takes input from textfields and turns it into a Journey model.
     * Uses the 'checkAllValues' method to guarantee the integrity of the input values.
     * @author Stan
     */
    public void saveJourney(int kilometers, String destination, String description, String date, String licensePlate, boolean isBilled, double parkingCost, double otherCost, double rate, String projectId){
        if(checkAllValues(kilometers, parkingCost, otherCost, rate)) {
            newJourney = new Journey(kilometers, destination, description, date, licensePlate, isBilled, parkingCost, otherCost, rate, projectId);

            pushJourneyToApi(LoginController.username + ":" + LoginController.password, newJourney);
            journeyController.getJourneyList().notifyObservers();
            System.out.println("Post succesvol");
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
    public void pushJourneyToApi(String userCredentials, Journey journey) {  //username:password

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL apiUrl = new URL("http://localhost:8080/journey");
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            //request setup
            apiConnection.setRequestMethod("POST");
            apiConnection.setConnectTimeout(5000); //Timeout timer
            apiConnection.setReadTimeout(5000);

            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            apiConnection.setRequestProperty ("Authorization", basicAuth);
            apiConnection.setRequestProperty("Accept", "application/json");
            apiConnection.setRequestProperty("Content-Type", "application/json");
            apiConnection.setDoOutput(true);
            String jsonBody = GsonService.toJson(journey);
            System.out.println("Dit is de output: " + jsonBody);
            apiConnection.getOutputStream().write(jsonBody.getBytes("UTF8"));


            int status = apiConnection.getResponseCode();
            System.out.println(status);

            reader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
            while((line = reader.readLine()) != null ) {
                responseContent.append(line);
            }
            reader.close();
            System.out.println(responseContent.toString());
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        //closes the connection
        finally {
            apiConnection.disconnect();
        }
    }

    /**
     * Checks if the values entered by the user are within the set boundaries.
     * Uses the 'checkIntValue' and 'checkDoubleValue' methods respectively.
     * @author Stan
     * @param kilometers
     * @param parkingCost
     * @param otherCost
     * @param rate
     * @return
     */
    private boolean checkAllValues(int kilometers, double parkingCost, double otherCost, double rate) {
        boolean accepted = true;
        boolean k = checkIntValue(kilometers, 0, 1000, "afstand");
        boolean pc = checkDoubleValue(parkingCost, -0.00001, 999.99, "parkeerkosten");
        boolean oc = checkDoubleValue(otherCost, -0.00001, 999.99, "overige kosten");
        boolean r = checkDoubleValue(rate, -0.00001, 999.99, "rate");

        if(!(k && r && pc && oc && r)) {
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
