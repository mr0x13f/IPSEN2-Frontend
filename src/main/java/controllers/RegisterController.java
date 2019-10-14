package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML private TextField emailTextfieldRegister;
    @FXML private TextField passwordTextfieldRegister;
    @FXML private TextField confirmPasswordTextfieldRegsiter;
    @FXML private Button registerButton;
    @FXML private Label alreadyHaveAccount;


    @FXML
    private void registerNewUser(){


        String email = emailTextfieldRegister.getText();
        String password = passwordTextfieldRegister.getText();
        String confirmPassword = confirmPasswordTextfieldRegsiter.getText();

        System.out.println("email:  " + email);
        System.out.println("password 1 :  " + password);
        System.out.println("password 2 :  " + confirmPassword);


        if(password == confirmPassword){
            System.out.println("Wachtwoorden zijn niet gelijk");
        }else{
            System.out.println("Wachtwoorden zijn gelijk");
        }

    }

    @FXML
    private void goToLoginView() throws IOException {
        Stage stage = (Stage) alreadyHaveAccount.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/loginView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }
}
