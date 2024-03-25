/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import DB.dtoContribute;
import DB.dtoItem;
import DB.dtoRequest;
import Scenes.FriendWLBase;
import Scenes.HomePageBase;
import Scenes.loginBase;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.json.JSONObject;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Yassa Rashad
 */
public class FriendWLController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    final ArrayList<DtoUser>[] finalContacts = new ArrayList[]{null};
    final TableView<DtoUser>[] finalTableView = new TableView[]{new TableView<>()};
    final TableColumn<DtoUser, String>[] finalTableColumnUser = new TableColumn[]{null};
    final TableColumn<DtoUser, String>[] finalTableColumnEmail = new TableColumn[]{null};
    final ArrayList<dtoItem>[] finalItems = new ArrayList[]{null};
    final TableView<dtoItem>[] finalTableView_items = new TableView[]{new TableView<>()};
    final TableColumn<dtoItem, Integer>[] finalTableColumnBarcode_item = new TableColumn[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnName_item = new TableColumn[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnDesc_item = new TableColumn[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnCat_item = new TableColumn[]{null};
    final TableColumn<dtoItem, Double>[] finalTableColumnPrice_item = new TableColumn[]{null};
    public FriendWLController(Stage s,FriendWLBase FWLB){
        
        FWLB.getHomebtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        FWLB.getFriendsbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
                    J_obj.addProperty("key", "ShowFriends");
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
                                        ArrayList<DtoUser> Friends = new ArrayList<>();
                                        JSONObject J_obj = new JSONObject(data);
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String friends = J_obj.getString("value");
                                        if ("FR".equals(key)){
                                            Type userListType = new TypeToken<ArrayList<DtoUser>>() {}.getType();
                                            Friends = gson.fromJson(friends, userListType);
                                            if (Friends != null)
                                            {
                                                finalTableView[0].getItems().clear();
                                                finalContacts[0] = Friends;
                                                finalTableView[0] = FWLB.getTableViewF();
                                                finalTableColumnUser[0] = FWLB.getTableColumnUserF();
                                                finalTableColumnEmail[0] = FWLB.getTableColumnEmailF();
                                                finalTableColumnUser[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName()));
                                                finalTableColumnEmail[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                                                finalTableView[0].getItems().addAll(finalContacts[0]);
                                                finalTableView[0].getColumns().setAll(finalTableColumnUser[0], finalTableColumnEmail[0]);
                                                
                                            }
                                            else
                                            {
                                                System.out.println("ShowFriendsError");
                                            }
                                        }

                                    });
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
        FWLB.getItemsbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {               
                        final DtoUser selectedFriend = finalTableView[0].getSelectionModel().getSelectedItem();
                        if (selectedFriend != null) {
                            server = new Socket(IP, 5000);
                            mouth = new PrintStream(server.getOutputStream());
                            ear = new DataInputStream(server.getInputStream());
                            DtoUser user = new DtoUser();
                            user.setUserName(selectedFriend.getUserName());
                            Gson gson = new Gson();
                            String json = gson.toJson(user);
                            JsonObject J_obj = new JsonObject();
                            J_obj.addProperty("key", "ShowFriendItems");
                            J_obj.addProperty("value", json);
                            mouth.println(J_obj);
                        }
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
                                        ArrayList<dtoItem> items = new ArrayList<>();
                                        JSONObject J_obj = new JSONObject(data);
                                        String key = J_obj.getString("key");
                                        Gson gson = new Gson();
                                        String item = J_obj.getString("value");
                                        if ("FIR".equals(key)) {
                                            
                                            Type itemListType = new TypeToken<ArrayList<dtoItem>>() {}.getType();
                                            items = gson.fromJson(item, itemListType);
                                            if (items != null) {
                                                finalTableView_items[0].getItems().clear();
                                                finalItems[0] = items;
                                                finalTableView_items[0] = FWLB.getTableViewI();
                                                finalTableColumnBarcode_item[0] = FWLB.getTableColumnBarcodeI();
                                                finalTableColumnName_item[0] = FWLB.getTableColumnNameI();
                                                finalTableColumnDesc_item[0] = FWLB.getTableColumnDescI();
                                                finalTableColumnCat_item[0] = FWLB.getTableColumnCatI();
                                                finalTableColumnPrice_item[0] = FWLB.getTableColumnPriceI();
                                                finalTableColumnBarcode_item[0].setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getItembarcode()).asObject());
                                                finalTableColumnName_item[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
                                                finalTableColumnDesc_item[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
                                                finalTableColumnCat_item[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
                                                finalTableColumnPrice_item[0].setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
                                                finalTableView_items[0].getItems().addAll(finalItems[0]);
                                                finalTableView_items[0].getColumns().setAll(finalTableColumnBarcode_item[0], finalTableColumnName_item[0],finalTableColumnDesc_item[0],finalTableColumnCat_item[0],finalTableColumnPrice_item[0]);
                                            } else {
                                                System.out.println("ShowRequestsError");
                                            }
                                        }

                                    });
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
        
        FWLB.getContributebtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        FWLB.seterr("");
                        final dtoItem selectedItem = finalTableView_items[0].getSelectionModel().getSelectedItem();
                        final DtoUser selectedFriend = finalTableView[0].getSelectionModel().getSelectedItem();
                        if (selectedFriend != null && selectedItem != null){
                            java.util.Date currentDate = new java.util.Date();
                            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
                            server = new Socket(IP, 5000);
                            mouth = new PrintStream(server.getOutputStream());
                            ear = new DataInputStream(server.getInputStream());
                            dtoContribute cont = new dtoContribute(selectedItem.getItembarcode(),LoginController.user_name,selectedFriend.getUserName(),Double.parseDouble(FWLB.getsearchField()),sqlDate);
                            Gson gson = new Gson();
                            String json = gson.toJson(cont);
                            JsonObject J_obj = new JsonObject();
                            J_obj.addProperty("key", "contribute");
                            J_obj.addProperty("value",json);
                            mouth.println(J_obj);
                        }
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
                                        if ("CR".equals(key)) {
                                            if ("NotEnoughMoney".equals(Response)){
                                                FWLB.seterr("Not enough money.");
                                            }                                                
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

