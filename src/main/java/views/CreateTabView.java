package views;

import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import controllers.CreateTabController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * View for the create tab.
 * @version 17-10-2019
 */
public class CreateTabView {

    @FXML TextField textKilometers;
    @FXML TextField textLicensePlate;
    @FXML TextField textDestination;
    @FXML TextField textRate;
    @FXML TextField textProjectId;
    @FXML TextField textDescription;
    @FXML TextField textParkingCost;
    @FXML TextField textOtherCost;
    @FXML DatePicker dateChooser;

    CreateTabController createTabController = new CreateTabController();

    /**
     * Parses the input from textfields to their respective data formats and calls the 'saveJourney' method in the controller.
     * @author Stan
     */
    @FXML
    private void saveJourney(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickedDate = dateChooser.getValue();
        String userDate = (formatter.format(pickedDate) + " 00:00:00.000");

        System.out.println(userDate);

        //LocalDateTime currentTime = LocalDateTime.now();
        //String currentTimeString = formatter.format(currentTime) + ".000";

        int kilometers = 0;
        String destination = textDestination.getText();
        String description = textDescription.getText();
        String date = userDate;
        String licensePlate = textLicensePlate.getText();
        boolean isBilled = false;
        double parkingCost = 0.0;
        double otherCost = 0.0;
        double rate = 0.0;
        String projectId = textProjectId.getText();

        try {
            kilometers = Integer.parseInt(textKilometers.getText());
            rate = Double.parseDouble(textRate.getText());
            parkingCost = Double.parseDouble(textParkingCost.getText());
            otherCost = Double.parseDouble(textOtherCost.getText());
            createTabController.saveJourney(kilometers, destination, description, date, licensePlate, isBilled, parkingCost, otherCost, rate, projectId);
        }
        catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }
}
