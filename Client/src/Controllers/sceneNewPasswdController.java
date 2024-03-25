/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import Scenes.loginBase;
import Scenes.sceneNewPasswdBase;
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
public class sceneNewPasswdController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    public sceneNewPasswdController(Stage s,sceneNewPasswdBase SPB){
        SPB.getBackBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        SPB.getSaveBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                                  
                                        if (SPB.getConfPassword().equals(SPB.getNewpassword())){
                                        DtoUser user =new DtoUser();
                                        user.setEmail(securitySceneController.email);
                                        user.setPasswd(SPB.getNewpassword());
                                            try {
                                                server =new Socket(IP,5000);
                                            } catch (IOException ex) {
                                                Logger.getLogger(sceneNewPasswdController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            try {
                                                mouth =new PrintStream(server.getOutputStream());
                                            } catch (IOException ex) {
                                                Logger.getLogger(sceneNewPasswdController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            try {
                                                ear=new DataInputStream(server.getInputStream());
                                            } catch (IOException ex) {
                                                Logger.getLogger(sceneNewPasswdController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        Gson gson =new Gson();
                                        String json = gson.toJson(user);
                                        JsonObject J_obj=new JsonObject();
                                        J_obj.addProperty("key","save");
                                        J_obj.addProperty("value", json);
                                        mouth.println(J_obj);
                                        new Thread (){
                                            public void run() {
                                                while (true){
                                                    try{
                                                        String data =ear.readLine();
                                                        if (data == null ){
                                                            System.out.println("Server closed the connection.");
                                                            break;
                                                        }
                                                                if ("Success".equals(data)){
                                                                    Platform.runLater(() -> {
                                                                        SceneController sceneController = new SceneController(s);
                                                                        try {
                                                                            sceneController.switchtoscenelogin();
                                                                        } catch (IOException ex) {
                                                                            Logger.getLogger(sceneNewPasswdController.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }
                                                                    });
                                                                }else {
                                                                    System.out.println("0");
                                                    }
                                                            
                                                        
                                                    } catch (IOException ex){
                                                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }
                                            }
                                        }.start();
                                           }
                                        else
                                            SPB.seterr("Password doesn't match");
                
                }
            });
    }
    
}

