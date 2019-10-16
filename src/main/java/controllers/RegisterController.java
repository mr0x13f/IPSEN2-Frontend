package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.models.UserModel;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


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
        String password = passwordTextfieldRegister.getText();
        String confirmPassword = confirmPasswordTextfieldRegsiter.getText();


        if(confirmPassword(password,confirmPassword)&&isEmailValid(email)){
            try{
                byte[] hash = hashPassword(password);
                 String hashedPassword = hash.toString();
                UserModel user = new UserModel(0, email, fullName, hashedPassword);

                System.out.println(user.getEmail());
                System.out.println(user.getName());
                System.out.println(user.getPassword());
                System.out.println(user.getUserId());

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

    private byte[] hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 91052, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = factory.generateSecret(spec).getEncoded();

        return hash;
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
