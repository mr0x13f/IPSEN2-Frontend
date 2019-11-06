package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    @FXML void autoLogin() {

        login("nigerfagoot@gmail.com", "wachtwoord");
    }

    @FXML void login() {

        login(emailTextfieldLogin.getText(), passwordTextfieldLogin.getText());

    }

    private void login(String username, String password) {

        if (authenticate(username, password)) {

            // Login successful; show masterview
            try {
                Stage stage = (Stage) noAccountLabel.getScene().getWindow();
                Parent overviewScene = FXMLLoader.load(getClass().getResource("/views/masterView.fxml"));
                stage.setScene(new Scene(overviewScene, 1200, 900));
            } catch (java.io.IOException e) {

            }

        } else {

            // Login error

            // TODO: Iets laten zien dat het verkeerd is ofzo
            System.out.println("LoginController: LOGIN ERROR" );

        }
    }

    public boolean authenticate(String username, String password) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        int status = 0;

        try {
            URL apiUrl = new URL("http://localhost:8080/user/authenticate");
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            //request setup
            apiConnection.setRequestMethod("GET");
            apiConnection.setConnectTimeout(5000);
            apiConnection.setReadTimeout(5000);

            String basicAuth = "Basic " + new String(Base64.getEncoder().encode((username + ":" + password).getBytes()));
            apiConnection.setRequestProperty ("Authorization", basicAuth);

            status = apiConnection.getResponseCode();

            reader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
            while((line = reader.readLine()) != null ) {
                responseContent.append(line);
            }
            reader.close();
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

        return status == 200;
    }

    @FXML
    private void goToRegisterView() throws IOException {
        Stage stage = (Stage) noAccountLabel.getScene().getWindow();
        Parent overviewScene = FXMLLoader.load(getClass().getResource("../../res/views/registerView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

}
