package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.Overig.Password;
import main.java.Overig.PasswordHasher;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginController {

    public void Authencate(){}

    public void AccesGranted(){}

    public void AccesDenied(){}

    @FXML private Label noAccountLabel;
    @FXML private TextField emailTextfieldLogin;
    @FXML private TextField passwordTextfieldLogin;

    @FXML private Button autoLoginButton;

    @FXML void autoLogin() throws IOException{
        Stage stage = (Stage) noAccountLabel.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/masterView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

    @FXML void login() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String email = emailTextfieldLogin.getText();
        String userPassword = emailTextfieldLogin.getText();

        PasswordHasher passwordHasher = new PasswordHasher();
        Password password  = passwordHasher.hashPassword(userPassword);


        byte[] hash = password.getHash();

        System.out.println("Hash:");

        for(int i=0; i< hash.length ; i++) {
            System.out.print(hash[i] + " ");
        }

        byte[] salt = password.getSalt();

        System.out.println("\n Salt:");

        for(int i=0; i< salt.length ; i++) {
            System.out.print(salt[i] + " ");
        }
    }

    @FXML
    private void goToRegisterView() throws IOException {
        Stage stage = (Stage) noAccountLabel.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/registerView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

}
