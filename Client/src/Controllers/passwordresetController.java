/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import Scenes.loginBase;
import Scenes.passwordresetBase;
import Scenes.profileBase;
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

public class passwordresetController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    public passwordresetController(Stage s,passwordresetBase PassR){
        PassR.getDoneButton().addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            try {
                server = new Socket(IP, 5000);
                mouth = new PrintStream(server.getOutputStream());
                ear = new DataInputStream(server.getInputStream());
                String oldPassword = PassR.getOldPassword();
                String newPassword = PassR.getNewPassword();
                String confirmPassword = PassR.getConfirmPassword();
                
                if (!newPassword.equals(confirmPassword)) {
                    PassR.setinvalidpass_error("");
                    PassR.setpassmatch_error("New password and confirm password do not match.");
                    return;
                }
                DtoUser user = new DtoUser();
                user.setUserName(LoginController.user_name);
                user.setPasswd(newPassword);
                Gson gson = new Gson();
                String json = gson.toJson(user);
                JsonObject jsonRequest = new JsonObject();
                jsonRequest.addProperty("key", "CP");
                jsonRequest.addProperty("value", json);
                jsonRequest.addProperty("value2", oldPassword);
                mouth.println(jsonRequest);
                mouth.flush();
                new Thread(() -> {
                    try {
                            String data = ear.readLine();
                        if (data == null) {
                            System.out.println("Server closed the connection.");
                            return;
                        }
                        
                        Platform.runLater(() -> {
                            
                            
                            
                            if ("1".equals(data)) {
                                System.out.println("Password changed successfully.");
                                SceneController sceneController = new SceneController(s);
                                try {
                                    sceneController.switchtoscenelogin();
                                } catch (IOException ex) {
                                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                PassR.setpassmatch_error("");
                                PassR.setinvalidpass_error("Password change failed. Check old password or try again.");
                            }
                        });
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start();
            } catch (IOException ex) {
                Logger.getLogger(passwordresetController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       PassR.getBackButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                try {
                    DtoUser user = new DtoUser();
                    user.setUserName(LoginController.user_name);
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream());
                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "P");
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
                                if ("PR".equals(key)){
                                    user = gson.fromJson(value, DtoUser.class);
                                    if (user != null)
                                    {
                                        SceneController sceneController = new SceneController(s);
                                        sceneController.switchtosceneprofile(user);
                                    }
                                    else
                                    {
                                        System.out.println("Error");
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
        
        PassR.gethomeBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
         
        
        