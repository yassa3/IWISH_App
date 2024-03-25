/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginController.user_name;
import DB.DtoUser;
import DB.dtoItem;
import Scenes.AdminBase;
import Scenes.loginBase;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 *
 * @author Yassa Rashad
 */
public class AdminController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    public AdminController(Stage s,AdminBase AB){
        AB.getInsert().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("1");
                    dtoItem item = new dtoItem(Integer.parseInt(AB.getBarcode()),AB.getItem_name(),AB.getDescription(),AB.getCategory(),Double.parseDouble(AB.getPrice()));
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream()); // Move this line here
                    Gson gson = new Gson();
                    String json = gson.toJson(item);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "insertitems");
                    J_obj.addProperty("value",json);
                    mouth.println(J_obj);
                    new Thread() {
            public void run() {
                    while (true) {
                        
                        try {
                            String data = ear.readLine();
                            if (data == null) {
                                // Handle the case where the server closes the connection
                                System.out.println("Server closed the connection.");
                                break;
                            }
                            Platform.runLater(() -> {
                                if ("1".equals(data)){
                                    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                                    infoAlert.setTitle("Successfully Insertion");
                                    infoAlert.setHeaderText(null);
                                    infoAlert.setContentText("The Item inserted in database successfully");
                                    infoAlert.showAndWait();
                                }
                                
                            });
                            } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        } 
                        }
        }.start();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            });
        AB.getLogin().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                                    try {
                                        sceneController.switchtoscenelogin();
                                    } catch (IOException ex) {
                                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                
                }
            });
    }
    
}

