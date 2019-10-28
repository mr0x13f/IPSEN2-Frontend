package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.models.Password;
import main.java.models.User;
import main.java.Overig.PasswordHasher;

import java.io.IOException;


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
            }



            System.out.println("User Created!");
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
    private void goToLoginView() throws IOException {
        Stage stage = (Stage) alreadyHaveAccount.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/loginView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }
}
