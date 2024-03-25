/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.HomePageController.cont;
import DB.DtoUser;
import DB.dtoContribute;
import DB.dtoRelationShip;
import DB.dtoRequest;
import Scenes.friendsBase;
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
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Yassa Rashad
 */
public class friendsController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    final ArrayList<DtoUser>[] finalContacts = new ArrayList[]{null};
    final TableView<DtoUser>[] finalTableView = new TableView[]{new TableView<>()};
    final TableColumn<DtoUser, String>[] finalTableColumnUser = new TableColumn[]{null};
    final TableColumn<DtoUser, String>[] finalTableColumnEmail = new TableColumn[]{null};
    final ArrayList<DtoUser>[] finalContacts_req = new ArrayList[]{null};
    final TableView<DtoUser>[] finalTableView_req = new TableView[]{new TableView<>()};
    final TableColumn<DtoUser, String>[] finalTableColumnUser_req = new TableColumn[]{null};
    final TableColumn<DtoUser, String>[] finalTableColumnEmail_req = new TableColumn[]{null};
    final ArrayList<DtoUser>[] finalContacts_friends = new ArrayList[]{null};
    final TableView<DtoUser>[] finalTableView_friends = new TableView[]{new TableView<>()};
    final TableColumn<DtoUser, String>[] finalTableColumnUser_friends = new TableColumn[]{null};
    final TableColumn<DtoUser, String>[] finalTableColumnEmail_friends = new TableColumn[]{null};
    static ArrayList<DtoUser> names = new ArrayList<DtoUser>();
    public friendsController(Stage s,friendsBase FB){
                            System.out.println("1");
        try {
                        
            server = new Socket(IP, 5000);
            mouth = new PrintStream(server.getOutputStream());
            ear = new DataInputStream(server.getInputStream());
            Gson gson = new Gson();
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "showrequests");
                    System.out.println("nn");
                    DtoUser us = new DtoUser();
                    us.setUserName(LoginController.user_name);
                    String json = gson.toJson(us);
                    J_obj.addProperty("value",json);
                    mouth.println(J_obj);
            new Thread() {
                        public void run() {
                            while (true) {
                        
                                try {
                                    String data = ear.readLine();
                                    System.out.println("ww");
                                    JSONObject J_obj = new JSONObject(data);
                                    int index=0;
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String Response = J_obj.getString("value");
                                        if (key.equals("NR")){
                                            Type userListType = new TypeToken<ArrayList<DtoUser>>() {}.getType();
                                            ArrayList<DtoUser> requests = gson.fromJson(Response, userListType);
                                            requests.removeAll(names);
                                            if (requests.size()>0){
                                                    for (DtoUser req : requests) {
                                                        for (int i=0;i<names.size();i++){
                                                            
                                                            if(req.getUserName().equals(names.get(i).getUserName())){
                                                                index++;
                                                            }
                                                            
                                                        }
                                                        names.add(req);
                                                        if (index==0){
                                                            index=0;
                                                        Platform.runLater(() -> {
                                                            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                                                            infoAlert.setTitle("Friend Request");
                                                            infoAlert.setHeaderText(null);
                                                            infoAlert.setContentText(req.getUserName()+" Sent you a friend request");
                                                            infoAlert.showAndWait();
                                                            
                                                        });
                                                        }
                                                        }
                                                    }
                                                }
                                        
                                    } catch (IOException ex) {
                                    Logger.getLogger(FriendWLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                         }.start();
                    } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        FB.gethomeBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        FB.getsearchBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {               
                    String friend = FB.getsearchField();
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream()); 
                    Gson gson = new Gson();
                    String json = gson.toJson(friend);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "SF");
                    J_obj.addProperty("value",json);
                    J_obj.addProperty("value2",LoginController.user_name);
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
                                        ArrayList<DtoUser> contacts = new ArrayList<>();
                                        JSONObject J_obj = new JSONObject(data);
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String value = J_obj.getString("value");
                                        if ("SR".equals(key)){
                                            Type userListType = new TypeToken<ArrayList<DtoUser>>() {}.getType();
                                            contacts = gson.fromJson(value, userListType);
                                            if (contacts != null)
                                            {
                                                finalTableView[0].getItems().clear();
                                                finalContacts[0] = contacts;
                                                finalTableView[0] = FB.getTableViewS();
                                                finalTableColumnUser[0] = FB.getTableColumnUserS();
                                                finalTableColumnEmail[0] = FB.getTableColumnEmailS();
                                                finalTableColumnUser[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName()));
                                                finalTableColumnEmail[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                                                finalTableView[0].getItems().addAll(finalContacts[0]);
                                                finalTableView[0].getColumns().setAll(finalTableColumnUser[0], finalTableColumnEmail[0]);
                                                
                                            }
                                            else
                                            {
                                                System.out.println("SearchError");
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
        
        FB.getaddBtn().addEventHandler(ActionEvent.ACTION, event -> {
            try {
                final DtoUser selectedItems = finalTableView[0].getSelectionModel().getSelectedItem();
                if (selectedItems != null) {
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream());
                    Gson gson = new Gson();
                    dtoRequest req = new dtoRequest(LoginController.user_name, selectedItems.getUserName(), "PENDING");
                    String json = gson.toJson(req);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "AF");
                    J_obj.addProperty("value", json);
                    mouth.println(J_obj);
                }
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
                                    if (data.equals("Done"))
                                    {
                                        Platform.runLater(() -> {
                                            FB.seterr("");
                                                            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                                                            infoAlert.setHeaderText(null);
                                                            infoAlert.setContentText("Friend Request sent");
                                                            infoAlert.showAndWait();
                                                        });
                                    }
                                    else
                                    {
                                        FB.seterr("Already Friend");
                                    }
                                    } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                } 
                                }
                    }.start();
            } catch (IOException ex) {
                Logger.getLogger(friendsController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
        FB.getrefreshBtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {               
                        FB.seterr("");
                        server = new Socket(IP, 5000);
                        mouth = new PrintStream(server.getOutputStream());
                        ear = new DataInputStream(server.getInputStream()); 
                        DtoUser user = new DtoUser();
                        user.setUserName(LoginController.user_name);
                        Gson gson = new Gson();
                        String json = gson.toJson(user);
                        JsonObject J_obj = new JsonObject();
                        J_obj.addProperty("key", "ShowFriendsRequests");
                        J_obj.addProperty("value",json);
                        mouth.println(J_obj);
                    new Thread() {
                        public void run() {
                            while (true) {
                        
                                try {
                                    String data = ear.readLine();
                                    if (data == null&& data.startsWith("{")) {
                                        // Handle the case where the server closes the connection
                                        System.out.println("Server closed the connection.");
                                        break;
                                    }
                                    Platform.runLater(() -> {
                                        ArrayList<DtoUser> Friends = new ArrayList<>();
                                        ArrayList<DtoUser> Requests = new ArrayList<>();
                                        JSONObject J_obj = new JSONObject(data);
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String friends = J_obj.getString("value1");
                                        String requests = J_obj.getString("value2");
                                        if ("FRR".equals(key)){
                                            Type userListType1 = new TypeToken<ArrayList<DtoUser>>() {}.getType();
                                            Type userListType2 = new TypeToken<ArrayList<DtoUser>>() {}.getType();
                                            Friends = gson.fromJson(friends, userListType1);
                                            Requests = gson.fromJson(requests, userListType2);
                                            if (Requests != null)
                                            {
                                                finalTableView_req[0].getItems().clear();
                                                finalContacts_req[0] = Requests;
                                                finalTableView_req[0] = FB.getTableViewR();
                                                finalTableColumnUser_req[0] = FB.getTableColumnUserR();
                                                finalTableColumnEmail_req[0] = FB.getTableColumnEmailR();
                                                finalTableColumnUser_req[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName()));
                                                finalTableColumnEmail_req[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                                                finalTableView_req[0].getItems().addAll(finalContacts_req[0]);
                                                finalTableView_req[0].getColumns().setAll(finalTableColumnUser_req[0], finalTableColumnEmail_req[0]);
                                                
                                            }
                                            if (Friends != null)
                                            {
                                                finalTableView_friends[0].getItems().clear();
                                                finalContacts_friends[0] = Friends;
                                                finalTableView_friends[0] = FB.getTableViewA();
                                                finalTableColumnUser_friends[0] = FB.getTableColumnUserA();
                                                finalTableColumnEmail_friends[0] = FB.getTableColumnEmailA();
                                                finalTableColumnUser_friends[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName()));
                                                finalTableColumnEmail_friends[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                                                finalTableView_friends[0].getItems().addAll(finalContacts_friends[0]);
                                                finalTableView_friends[0].getColumns().setAll(finalTableColumnUser_friends[0], finalTableColumnEmail_friends[0]);
                                                
                                            }
                                            else
                                            {
                                                System.out.println("ShowRequestsError");
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
        FB.getacceptBtn().addEventHandler(ActionEvent.ACTION, event -> {
            DtoUser selectedRequest = finalTableView_req[0].getSelectionModel().getSelectedItem();
            if (selectedRequest != null) {
                try {
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream());
                    Gson gson = new Gson();
                    dtoRequest req = new dtoRequest(LoginController.user_name, selectedRequest.getUserName(), "ACCEPTED");
                    String json = gson.toJson(req);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "AcceptFriend");
                    J_obj.addProperty("value", json);
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
                                    Platform.runLater(() -> {
                                        JSONObject J_obj = new JSONObject(data);
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String friends = J_obj.getString("value");
                                        System.out.println(key);
                                        if (key.equals("ACCR")){
                                            finalContacts_req[0].remove(selectedRequest);
                                            finalTableView_req[0].getItems().clear();
                                            finalTableView_req[0].getItems().addAll(finalContacts_req[0]);
                                        }
                                    });
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }.start();
                } catch (IOException ex) {
                    Logger.getLogger(friendsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
        });
        FB.getdeclineBtn().addEventHandler(ActionEvent.ACTION, event -> {
            DtoUser selectedRequest = finalTableView_req[0].getSelectionModel().getSelectedItem();
            if (selectedRequest != null) {
                try {
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream());
                    Gson gson = new Gson();
                    dtoRequest req = new dtoRequest(LoginController.user_name, selectedRequest.getUserName(), "REFUSED");
                    String json = gson.toJson(req);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "DF");
                    J_obj.addProperty("value", json);
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
                                    Platform.runLater(() -> {
                                        if (data.equals("1")){
                                            finalContacts_req[0].remove(selectedRequest);
                                            finalTableView_req[0].getItems().clear();
                                            finalTableView_req[0].getItems().addAll(finalContacts_req[0]);
                                        }
                                    });
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }.start();
                } catch (IOException ex) {
                    Logger.getLogger(friendsController.class.getName()).log(Level.SEVERE, null, ex);
                }

                
            }

        });
        FB.getremoveBtn().addEventHandler(ActionEvent.ACTION, event -> {
            DtoUser RemoveFriend  = finalTableView_friends[0].getSelectionModel().getSelectedItem();
            if (RemoveFriend != null) {
                try {
                    server = new Socket(IP, 5000);
                    mouth = new PrintStream(server.getOutputStream());
                    ear = new DataInputStream(server.getInputStream());
                    Gson gson = new Gson();
                    dtoRelationShip remove = new dtoRelationShip(LoginController.user_name, RemoveFriend.getUserName());
                    String json = gson.toJson(remove);
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "RemoveFriend");
                    J_obj.addProperty("value", json);
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
                                    System.out.println(data);
                                    Platform.runLater(() -> {
                                        if (data.equals("1")){
                                            finalContacts_friends[0].remove(RemoveFriend);
                                            finalTableView_friends[0].getItems().clear();
                                            finalTableView_friends[0].getItems().addAll(finalContacts_friends[0]);
                                        }
                                    });
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        
                        
                        
                    }.start();
                } catch (IOException ex) {
                    Logger.getLogger(friendsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    });
}
}


