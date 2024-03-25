package Controllers;

import Scenes.loginBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX application for the client.
 */
public class Client extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        loginBase root = new loginBase();
        
        Scene scene = new Scene(root);
        LoginController log_control = new LoginController(stage, root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method, the entry point of the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
