package views;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import controllers.CreateTabController;

/**
 * View for the create tab.
 * @version 17-10-2019
 */
public class CreateTabView {

    @FXML TextField textDistance;
    @FXML TextField textLicensePlate;
    @FXML TextField textDestination;
    @FXML TextField textRateId;
    @FXML TextField textProjectId;
    @FXML TextField textDescription;
    @FXML TextField textParkingCost;
    @FXML TextField textOtherCost;

    CreateTabController createTabController = new CreateTabController();

    /**
     * Parses the input from textfields to their respective data formats and calls the 'saveJourney' method in the controller.
     * @author Stan
     */
    @FXML
    private void saveJourney(){

        int distance = 0;
        String licensePlate = textLicensePlate.getText();
        String destination = textDestination.getText();
        int rateId = 0;
        int projectId = 0;
        String description = textDescription.getText();
        double parkingCost = 0.0;
        double otherCost = 0.0;
        boolean isBilled = false;
        String date = "heyy timestamp";

        try {
            distance = Integer.parseInt(textDistance.getText());
            rateId = Integer.parseInt(textRateId.getText());
            projectId = Integer.parseInt(textProjectId.getText());
            parkingCost = Double.parseDouble(textParkingCost.getText());
            otherCost = Double.parseDouble(textOtherCost.getText());
            createTabController.saveJourney(distance, licensePlate, destination, rateId, projectId, description, parkingCost, otherCost, isBilled, date);
        }
        catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }
}
