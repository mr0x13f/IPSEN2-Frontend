package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Password;
import models.User;
import overig.PasswordHasher;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RegisterController {

    @FXML private TextField emailTextfieldRegister;
    @FXML private TextField fullNameTextfieldRegister;
    @FXML private TextField passwordTextfieldRegister;
    @FXML private TextField confirmPasswordTextfieldRegsiter;
    @FXML private Button registerButton;
    @FXML private Label alreadyHaveAccount;



    @FXML
    private void registerNewUser(){


        String email = emailTextfieldRegister.getText();
        String fullName = fullNameTextfieldRegister.getText();
        String userPassword = passwordTextfieldRegister.getText();
        String confirmPassword = confirmPasswordTextfieldRegsiter.getText();


        if(confirmPassword(userPassword,confirmPassword)&&isEmailValid(email)){
            try{
                PasswordHasher passwordHasher = new PasswordHasher();
                Password password  = passwordHasher.hashPassword(userPassword);

                String hashedPassword = password.getHash().toString();
                String salt = password.getSalt().toString();


                User user = new User(0, email, fullName, hashedPassword, salt);


                System.out.println(user.getUserId());
                System.out.println(user.getEmail());
                System.out.println(user.getName());
                System.out.println(user.getPassword().toCharArray());
                System.out.println(user.getSalt());

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        sendUserToApi();
        goToLoginView();
    }

    private void sendUserToApi() {
        String url = "http://localhost:8080/user/register";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("Con");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public boolean confirmPassword(String password, String confirmPassword){
        if(password.equals(confirmPassword)&& password.length()>5){
            return true;
        }else{

            return false;
        }
    }



    private boolean isEmailValid(String email){
        if(email.contains("@")){
            return true;
        }else{
            return false;
        }
    }

    @FXML
    private void goToLoginView(){
        try{
            Stage stage = (Stage) alreadyHaveAccount.getScene().getWindow();
            Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/loginView.fxml"));
            stage.setScene(new Scene(overviewScene, 1200, 900));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
