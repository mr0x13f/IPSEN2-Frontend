package main.java.views;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import main.java.controllers.LoginController;

import java.io.IOException;

public class LoginView {
    private LoginController loginController = LoginController.getInstance();

    @FXML
    private void login() throws IOException {
        loginController.OpenMasterView();
    }

    private void createUser(){

    }
}
