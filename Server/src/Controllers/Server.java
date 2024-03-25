package Controllers;

import Scenes.ServerSceneBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Server extends Application {

    private MainThread mainThread;

    @Override
    public void start(Stage stage) throws Exception {
        ServerSceneBase root = new ServerSceneBase();

        Runnable startServer = () -> {
            mainThread = new MainThread();
            mainThread.start();
        };

        root.setStartButtonHandler(event -> {
            if (mainThread == null || !mainThread.isAlive()) {
                Task<Void> startServerTask = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        startServer.run();
                        return null;
                    }
                };

                Thread thread = new Thread(startServerTask);
                thread.setDaemon(true);
                thread.start();

                Platform.runLater(() -> {
                    root.getStartButton().setDisable(true);  
                    root.getStopButton().setDisable(false); 
                });
            }
        });

        root.setStopButtonHandler(event -> {
            System.out.println("Server stopped");
            if (mainThread != null) {
                mainThread.closeServerSocket();
                mainThread.interrupt();
                mainThread = null;

                Platform.runLater(() -> {
                    root.getStartButton().setDisable(false); 
                    root.getStopButton().setDisable(true); 
                });
            }
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
