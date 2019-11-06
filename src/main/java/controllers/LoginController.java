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
import overig.PasswordHasher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class LoginController {

    private static HttpURLConnection apiConnection;

    public void Authencate(){}

    public void AccesGranted(){}

    public void AccesDenied(){}

    @FXML private Label noAccountLabel;
    @FXML private TextField emailTextfieldLogin;
    @FXML private TextField passwordTextfieldLogin;

    @FXML private Button autoLoginButton;

    @FXML void autoLogin() throws IOException{
        connectToApi("nigerfagoot@gmail.com:wachtwoord");
        Stage stage = (Stage) noAccountLabel.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("/views/masterView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

    public void connectToApi(String userCredentials) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL apiUrl = new URL("http://localhost:8080/user/authenticate");
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            //request setup
            apiConnection.setRequestMethod("GET");
            apiConnection.setConnectTimeout(5000); //tIMEOUTS
            apiConnection.setReadTimeout(5000);

            //String userCredentials = "nigerfagoot@gmail.com:wachtwoord"; //username:password
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            apiConnection.setRequestProperty ("Authorization", basicAuth);

            int status = apiConnection.getResponseCode();
            System.out.println(status);

            reader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
            while((line = reader.readLine()) != null ) {
                responseContent.append(line);
            }
            reader.close();

            System.out.println(responseContent.toString());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //closes the connection
        finally {
            apiConnection.disconnect();
        }
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
        Parent overviewScene = FXMLLoader.load(getClass().getResource("/views/registerView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

}
