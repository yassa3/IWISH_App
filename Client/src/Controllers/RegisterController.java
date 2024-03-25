/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import DB.DtoUser;
import Scenes.HomePageBase;
import Scenes.loginBase;
import Scenes.RegisterBase;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.EventType;
import org.json.JSONObject;
/**
 *
 * @author Resal
 */
public class RegisterController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public RegisterController(Stage s,RegisterBase RB){
        RB.getRegisterButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                try {     
                    Pattern pattern = Pattern.compile(emailRegex);
                    Matcher matcher = pattern.matcher(RB.getEmail().trim());
                    if (RB.getUserName().isEmpty() || RB.getFirstName().isEmpty() || RB.getLastName().isEmpty() || RB.getSecurityAns().isEmpty() || RB.getEmail().isEmpty() || RB.getPassword().isEmpty()) {
                        RB.setemailerr("");
                        RB.setusererr("");
                        RB.setpasserr("");
                        RB.setcomerr("Please Enter your data");
                    }
                    else if (!matcher.matches()){
                        RB.setcomerr("");
                        RB.setusererr("");
                        RB.setpasserr("");
                        RB.setemailerr("Email is invalid");
                    }
                    else if (!RB.getPassword().trim().equals(RB.getConfirmPassword().trim())) {
                        RB.setcomerr("");
                        RB.setusererr("");
                        RB.setemailerr("");
                        RB.setpasserr("Password doesn't match");
                    }
                    else{
                    DtoUser user = new DtoUser(RB.getUserName(),RB.getFirstName(),RB.getLastName(),RB.getSecurityAns(),RB.getEmail() ,RB.getPassword());
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream());
                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "R");
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
                                    try {
                                        sceneController.switchtoscenelogin();
                                    } catch (IOException ex) {
                                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if ("UserInvalid".equals(data))
                                {
                                    RB.setcomerr("");
                                    RB.setemailerr("");
                                    RB.setpasserr("");
                                    RB.setusererr("Username already exists");
                                }
                                else if ("EmailInvalid".equals(data))
                                {
                                    RB.setcomerr("");
                                    RB.setusererr("");
                                    RB.setpasserr("");
                                    RB.setemailerr("Email already exists");
                                }
                                else
                                    System.out.println("0");
                                
                            });
                            } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        } 
                        }
        }.start();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                
            }
        
        });
        
        RB.getLoginButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //System.out.println("test");
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
