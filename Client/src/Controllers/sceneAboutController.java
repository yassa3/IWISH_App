/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import Scenes.passwordresetBase;
import Scenes.sceneAboutBase;
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
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 *
 * @author Yassa Rashad
 */
public class sceneAboutController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    public sceneAboutController(Stage s,sceneAboutBase AB){
        AB.gethomeBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {               
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream()); 
                    DtoUser user = new DtoUser();
                    user.setUserName(LoginController.user_name);
                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "ShowBalance");
                    J_obj.addProperty("value",json);
                    mouth.println(J_obj);
                    new Thread() {
                        public void run() {
                            while (true) {
                        
                                try {
                                    String data = ear.readLine();
                                    if (data == null) {
                                        System.out.println("Server closed the connection.");
                                        break;
                                    }
                                    JSONObject J_obj = new JSONObject(data);
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String Response = J_obj.getString("value");
                                        if ("HR".equals(key)) {
                                            DtoUser user = gson.fromJson(Response, DtoUser.class);  
                                            System.out.println(user.getBalance());
                                            Platform.runLater(() -> {
                                                SceneController sceneController = new SceneController(s);
                                                sceneController.switchToHomeScene(LoginController.user_name, user.getBalance());
});
                                        }
                                    } catch (IOException ex) {
                                    Logger.getLogger(FriendWLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                         }.start();
                    
                    } catch (IOException ex) {
                        Logger.getLogger(FriendWLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
    }
}
