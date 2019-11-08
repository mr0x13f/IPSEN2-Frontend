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

    @FXML private Label noAccountLabel;
    @FXML private TextField emailTextfieldLogin;
    @FXML private TextField passwordTextfieldLogin;
    @FXML private Button autoLoginButton;

    public static String username;
    public static String password;


    @FXML void autoLogin() {
        loginContinue("nigerfagoot@gmail.com", "wachtwoord");
    }

    /**
     *Takes information from the input fields and tries to log in using the Login method.
     */
    @FXML void login() {
        loginContinue(emailTextfieldLogin.getText(), passwordTextfieldLogin.getText());
    }

    /**
     * Connects to the API to log in and continues to the home screen
     * @author Stan, Jochem, Tim.v.H
     * @version 8-11-19
     */
    private void loginContinue(String username, String password) {

        this.username = username;
        this.password = password;

        if (authenticate(username, password)) {
            // Login successful; show masterview
            try {
                Stage stage = (Stage) noAccountLabel.getScene().getWindow();
                Parent overviewScene = FXMLLoader.load(getClass().getResource("/views/masterView.fxml"));
                stage.setScene(new Scene(overviewScene, 1200, 900));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        else {
            // TODO: Iets laten zien dat het verkeerd is ofzo
            System.out.println("LoginController: LOGIN ERROR" );
        }
    }

    /**
     * Authenticates the login information of the user
     * @author Stan
     * @version 8-11-2019
     * @param username
     * @param password
     * @return
     */
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
        Parent overviewScene = FXMLLoader.load(getClass().getResource("/views/registerView.fxml"));
        stage.setScene(new Scene(overviewScene, 1200, 900));
    }

}
