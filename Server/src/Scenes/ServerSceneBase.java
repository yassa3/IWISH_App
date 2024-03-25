package Scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ServerSceneBase extends AnchorPane {

    protected final Button startButton;
    protected final Button stopButton;

    public ServerSceneBase() {

        startButton = new Button();
        stopButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        startButton.setLayoutX(171.0);
        startButton.setLayoutY(280.0);
        startButton.setMnemonicParsing(false);
        startButton.setText("Start");

        stopButton.setLayoutX(355.0);
        stopButton.setLayoutY(280.0);
        stopButton.setMnemonicParsing(false);
        stopButton.setText("Stop");

        getChildren().add(startButton);
        getChildren().add(stopButton);
    }

    public void setStartButtonHandler(EventHandler<ActionEvent> handler) {
        startButton.setOnAction(handler);
    }

    public void setStopButtonHandler(EventHandler<ActionEvent> handler) {
        stopButton.setOnAction(handler);
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getStopButton() {
        return stopButton;
    }
}
