import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/loginView.fxml"));
        primaryStage.setTitle("Kilometer Registratie");
        primaryStage.setScene(new Scene(root, 1200, 900));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args)throws IOException {
        launch(args);
    }
}
