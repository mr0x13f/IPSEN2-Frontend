package views;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import controllers.CreateTabController;

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
    @FXML TextField textCreatorId;
    @FXML TextField textDate;

    CreateTabController createTabController = new CreateTabController();

    /**
     * Parses the input from textfields to their respective data formats and calls the 'saveJourney' method in the controller.
     * @author Stan
     */
    @FXML
    private void saveJourney(){

        String journeyId;
        int kilometers = 0;
        String destination = textDestination.getText();
        String description = textDescription.getText();
        String date = textDate.getText();
        String licensePlate = textLicensePlate.getText();
        boolean isBilled = false;
        double parkingCost = 0.0;
        double otherCost = 0.0;
        double rate = 0.0;
        String projectId = textProjectId.getText();
        String creatorId = textCreatorId.getText();

        try {
            kilometers = Integer.parseInt(textKilometers.getText());
            rate = Double.parseDouble(textRate.getText());
            parkingCost = Double.parseDouble(textParkingCost.getText());
            otherCost = Double.parseDouble(textOtherCost.getText());
            createTabController.saveJourney(kilometers, destination, description, date, licensePlate, isBilled, parkingCost, otherCost, rate, projectId, creatorId);
        }
        catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }
}
