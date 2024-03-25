/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import Scenes.sceneNewPasswdBase;
import Scenes.securitySceneBase;
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

/**
 *
 * @author Yassa Rashad
 */
public class securitySceneController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    static String email = null;
    public securitySceneController(Stage s,securitySceneBase SSB){
        SSB.getBackBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        SSB.getEnterBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                try {
                    email = SSB.getemail();
                    DtoUser user = new DtoUser();
                    user.setEmail(email);
                    user.setSecurityAns(SSB.getsecurityanswer());
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream()); // Move this line here
                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "enter");
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
                            if ("WrongAnswer".equals(data)){
                                        SSB.seterr("email or security answer is invalid");
                                    }
                                    else
                                    {
                                        Platform.runLater(() -> {
                                            SceneController sceneController = new SceneController(s);       
                                            try {
                                                sceneController.switchtoscenesecuritypasswd();
                                            } catch (IOException ex) {
                                                Logger.getLogger(securitySceneController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        });
                                        
                                    }
                                } catch (IOException ex) {
                            Logger.getLogger(securitySceneController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
}
        }.start();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            });
    }
}
