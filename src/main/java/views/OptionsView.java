package views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class OptionsView implements Initializable{

    @FXML
    private ImageView optionsImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        File file = new File("../../res/images/gear.png");
        Image image = new Image(file.toURI().toString());
        optionsImageView.setImage(image);
    }
}
