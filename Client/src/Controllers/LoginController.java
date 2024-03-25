/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import Scenes.loginBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.application.Platform;
import org.json.JSONObject;

/**
 *
 * @author Yassa
 */
public class LoginController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    static String user_name;
    static double balance;
    public LoginController(Stage s,loginBase LB){
        LB.getloginBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DtoUser user = new DtoUser(LB.getUserName(), LB.getPassword());
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream()); // Move this line here
                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "L");
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
                                DtoUser user;
                                JSONObject J_obj = new JSONObject(data);
                                String key = J_obj.getString("key");
                                Gson gson = new Gson();
                                String value = J_obj.getString("value");
                                if ("R".equals(key)){
                                    user = gson.fromJson(value, DtoUser.class);
                                    if (user != null)
                                    {
                                        
                                        SceneController sceneController = new SceneController(s);
                                        user_name = user.getUserName();
                                        balance = user.getBalance();  
                                        System.out.println(user_name);
                                        if ("root".equals(user_name)){
                                            sceneController.switchToJumiaScene();
                                        }
                                        else
                                            sceneController.switchToHomeScene(user_name, balance);
                                    }
                                    else
                                    {
                                        LB.seterror("Userame or Password is invalid");
                                    }
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
            LB.getForgetBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                                    try {
                                        sceneController.switchtoscenesecurity();
                                    } catch (IOException ex) {
                                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                
                }
            });
            LB.getRegisterBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                                    try {
                                        sceneController.switchtosceneregister();
                                    } catch (IOException ex) {
                                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                
                }
            });
        };
                     
 }
