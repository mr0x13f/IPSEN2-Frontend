package controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Password;
import models.TempUser;
import models.User;
import overig.PasswordHasher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RegisterController {

    @FXML private TextField emailTextfieldRegister;
    @FXML private TextField fullNameTextfieldRegister;
    @FXML private TextField passwordTextfieldRegister;
    @FXML private TextField confirmPasswordTextfieldRegsiter;
    @FXML private Button registerButton;
    @FXML private Label alreadyHasAccount;



    @FXML
    private void registerNewUser(){
        System.out.println("Try to create new user");


        String email = emailTextfieldRegister.getText();
        String fullName = fullNameTextfieldRegister.getText();
        String userPassword = passwordTextfieldRegister.getText();
        String confirmPassword = confirmPasswordTextfieldRegsiter.getText();


        if(confirmPassword(userPassword,confirmPassword)&&isEmailValid(email)){
            try{
                System.out.println("Created user object");
                PasswordHasher passwordHasher = new PasswordHasher();
                Password password  = passwordHasher.hashPassword(userPassword);

                String hashedPassword = password.getHash().toString();
                String salt = password.getSalt().toString();

                //todo change this to just User model
                //User user = new User(0, email, fullName, hashedPassword, salt);
                TempUser tempUser = new TempUser(fullName, userPassword, email);

                //todo also change this then
                sendUserToApi(tempUser);
                goToLoginView();

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    //todo also change here
    private void sendUserToApi(TempUser user) {
        System.out.println("try to send user to API");
        String url = "http://localhost:8080/user/register";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setDoOutput(true);


            Gson g = new Gson();
            String json = g.toJson(user);
            System.out.println(json);

            OutputStream os = connection.getOutputStream();
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);

            //console output server response

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while((responseLine = br.readLine()) != null){
                response.append(responseLine.trim());
            }
            System.out.println("server response: " + response.toString());


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
            Stage stage = (Stage) alreadyHasAccount.getScene().getWindow();
            Parent overviewScene = FXMLLoader.load(getClass().getResource("/views/loginView.fxml"));
            stage.setScene(new Scene(overviewScene, 1200, 900));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
