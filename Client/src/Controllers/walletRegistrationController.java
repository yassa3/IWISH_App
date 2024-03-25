/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import DB.dtoWallet;
import Scenes.loginBase;
import Scenes.walletRegistrationBase;
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
 * @author Resal
 */
public class walletRegistrationController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    public walletRegistrationController(Stage s,walletRegistrationBase WR){
        WR.getAddtowallet().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        dtoWallet add = new dtoWallet(WR.getCnoRegistration(),Integer.parseInt(WR.getCvvRegistration()),WR.getNameRegistration(),WR.getDateregistration(),LoginController.user_name);
                        server = new Socket(IP, 5000);
                        mouth = new PrintStream(server.getOutputStream());
                        ear = new DataInputStream(server.getInputStream());
                        Gson gson = new Gson();
                        String json = gson.toJson(add);
                        JsonObject J_obj = new JsonObject();
                        J_obj.addProperty("key", "AddCredit");
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
                                                SceneController sceneController = new SceneController(s);
                                                sceneController.switchToWalletInformation();
                                            }
                                            else
                                                WR.setErrorText("This Credit Card already exists");
                                            
                                        });
                                    } catch (IOException ex) {
                                        Logger.getLogger(walletRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }.start();  } catch (IOException ex) {
                        Logger.getLogger(walletRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        });
        WR.getRechagerWallet().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                    sceneController.switchToWalletInformation();
                
                }
            });
        WR.getHomeWallet().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
