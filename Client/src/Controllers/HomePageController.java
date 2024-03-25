/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DtoUser;
import DB.dtoContribute;
import DB.dtoItem;
import Scenes.HomePageBase;
import Scenes.loginBase;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONObject;

public class HomePageController {
    final TableView<dtoItem>[] finalTableView_items = new TableView[]{new TableView<>()};
    final TableView<dtoItem>[] finalTableViewII=new TableView[]{new TableView<>()};
    final ArrayList<dtoItem>[] finalItems = new ArrayList[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnName_item = new TableColumn[]{null};
    final TableColumn<dtoItem, Integer>[] finalTableColumnBarcode_item = new TableColumn[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnDesc_item = new TableColumn[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnCat_item = new TableColumn[]{null};
    final TableColumn<dtoItem, Double>[] finalTableColumnPrice_item = new TableColumn[]{null};
    final ArrayList<dtoItem>[] finalitemsWL = new ArrayList[]{null};
    final TableColumn<dtoItem, Integer>[] finalTableColumnBarCode = new TableColumn[]{null};
    final TableColumn<dtoItem, String>[] finalTableColumnItemName=new TableColumn[]{null};
    final TableColumn<dtoItem , String >[] finalTableColumnDescribe = new TableColumn[]{null};
    final TableColumn<dtoItem ,String >[] finalTableColumnCategory=new TableColumn[] {null};
    final TableColumn<dtoItem ,Double>[] finalTableColumnPrice = new TableColumn [] {null};
    static ArrayList<dtoContribute> cont = new ArrayList<dtoContribute>();
    static ArrayList<dtoContribute> names = new ArrayList<dtoContribute>();
    public HomePageController(){
        
    }
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    public HomePageController(Stage s,HomePageBase HB){
                    try {
                        
            server = new Socket(IP, 5000);
            mouth = new PrintStream(server.getOutputStream());
            ear = new DataInputStream(server.getInputStream());
            Gson gson = new Gson();
                    JsonObject J_obj = new JsonObject();
                    J_obj.addProperty("key", "Showstatus");
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
                                    JSONObject J_obj = new JSONObject(data);
                                    if (J_obj.has("key")) {
                                        String key = J_obj.getString("key");
                                        if ("CCR".equals(key)) {
                                            int index=0;
                                            if (J_obj.has("value1") && J_obj.has("value2")) {
                                                String Response1 = J_obj.getString("value1");
                                                String Response2 = J_obj.getString("value2");

                                                Type userListType1 = new TypeToken<ArrayList<dtoContribute>>() {}.getType();
                                                Type userListType2 = new TypeToken<ArrayList<dtoContribute>>() {}.getType();
                                                ArrayList<dtoContribute> contributes = gson.fromJson(Response1, userListType1);
                                                ArrayList<dtoContribute> received = gson.fromJson(Response2, userListType2);
                                                contributes.removeAll(cont);
                                                if (contributes.size()>0){
                                                    for (dtoContribute contribute : contributes) {
                                                        for (int i=0;i<cont.size();i++){
                                                            
                                                            if(contribute.getItem_name().equals(cont.get(i).getItem_name()) && contribute.getUser_name().equals(cont.get(i).getUser_name())){
                                                                index++;
                                                            }
                                                            
                                                        }
                                                        cont.add(contribute);
                                                        if (index==0){
                                                            index=0;
                                                        Platform.runLater(() -> {
                                                            Alert infoAlert = new Alert(AlertType.INFORMATION);
                                                            infoAlert.setTitle("Good Job");
                                                            infoAlert.setHeaderText(null);
                                                            infoAlert.setContentText("Your item " + contribute.getItem_name()+ " to Friend " +
                                                                    contribute.getFriend_name() + " is Completed");
                                                            infoAlert.showAndWait();
                                                            
                                                        });
                                                        }
                                                    }
                                                }
                                                received.removeAll(names);
                                                if (received.size()>0){
                                                    for (dtoContribute gift : received) {
                                                        for (int i=0;i<names.size();i++){
                                                            if(gift.getItem_name().equals(names.get(i).getItem_name()) && gift.getFriend_name().equals(names.get(i).getFriend_name())){
                                                                index++;
                                                            }
                                                            
                                                        }
                                                        names.add(gift);
                                                        if (index==0){
                                                            index=0;
                                                            Platform.runLater(() -> {
                                                                Alert infoAlert = new Alert(AlertType.INFORMATION);
                                                                infoAlert.setTitle("Congratulations");
                                                                infoAlert.setHeaderText(null);
                                                                infoAlert.setContentText("Your Friend "+gift.getFriend_name()+" gifted you " + gift.getItem_name());
                                                                infoAlert.showAndWait();
                                                            });
                                                        }
                                                    }
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
                
        
            HB.getprofilebtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        
                HB.getfriendhomebtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                                    try {
                                        sceneController.switchtoscenefriends();
                                    } catch (IOException ex) {
                                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                
                }
            });
            
            HB.getfriendhomebtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                    try {
                        sceneController.switchtoscenefriends();
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
            HB.getfriendwlbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                    try {
                        sceneController.switchtosceneFriendWL();
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
            HB.getlogoutbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
            
            HB.getaboutbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                    try {
                        sceneController.switchtoscenesceneAbout();
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
            HB.getwalletbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(s);
                    try {
                        sceneController.switchtoscenewalletRegistration();
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
        HB.getWishListButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SceneController sceneController = new SceneController(s);
                        server =new Socket(IP,5000);
                        mouth=new PrintStream (server.getOutputStream());
                        ear =new DataInputStream (server.getInputStream());
                        DtoUser user =new DtoUser();
                        user.setUserName(LoginController.user_name);
                        Gson gson =new Gson();
                        String json =gson.toJson(user);
                        JsonObject J_obj =new JsonObject();
                        J_obj.addProperty("key","ShowWishList");
                        J_obj.addProperty("value", json);
                        mouth.println(J_obj);
                        
                        new Thread(){
                            public void run (){
                                while (true ){
                                    try{
                                        String data = ear.readLine();
                                        if (data == null ){
                                            System.out.println("server closed the connection .");
                                            break;
                                        }
                                        Platform.runLater(() ->{
                                            ArrayList<dtoItem> items =new ArrayList<>();
                                            JSONObject J_obj =new JSONObject(data);
                                            String key = J_obj.getString("key");
                                            Gson gson =new Gson();
                                            String item =J_obj.getString("value");
                                            //response from server
                                            if ("WishListResponse".equals(key)){
                                                Type itemListType = new TypeToken <ArrayList<dtoItem>> (){}.getType();
                                                items =gson.fromJson (item ,itemListType);
                                                if (items != null ){
                                                    finalTableView_items[0].getItems().clear();
                                                    finalItems[0]=items;
                                                    finalTableView_items[0]=HB.getTableView();
                                                    finalTableColumnBarcode_item[0]=HB.getTableColumnBarCode();
                                                    finalTableColumnName_item[0]=HB.getTableItemName();
                                                    finalTableColumnDesc_item[0]=HB.getTableDescribe();
                                                    finalTableColumnCat_item[0]=HB.getTablecategory();
                                                    finalTableColumnPrice_item[0]=HB.getTableprice();
                                                    finalTableColumnBarcode_item[0].setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getItembarcode()).asObject());
                                                    finalTableColumnName_item[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
                                                    finalTableColumnDesc_item[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
                                                    finalTableColumnCat_item[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
                                                    finalTableColumnPrice_item[0].setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
                                                    finalTableView_items[0].getItems().addAll(finalItems[0]);
                                                    finalTableView_items[0].getColumns().setAll(finalTableColumnBarcode_item[0], finalTableColumnName_item[0],finalTableColumnDesc_item[0],finalTableColumnCat_item[0],finalTableColumnPrice_item[0]);
                                                }else {
                                                    System.out.println("Show request Error ");
                                                }
                                            }

                                        });
                                    } catch (IOException ex) {
                                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }.start();
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        
           HB.searchbtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                      try{
                          String item =HB.getSearchItem();
                          server = new Socket(IP, 5000);
                          mouth =new PrintStream(server.getOutputStream());
                          ear=new DataInputStream(server.getInputStream());
                          Gson gson=new Gson();
                          String json = gson.toJson(item);
                          JsonObject J_obj =new JsonObject();
                          J_obj.addProperty("key","SearchHandler");
                          J_obj.addProperty("value", json);
                          mouth.println(J_obj);
                          new Thread(){
                              public void run(){
                                  while (true){
                                      try{
                                          String data =ear.readLine();
                                          if (data == null){
                                              System.out.println("Server closed the connection ");
                                              break;
                                          }
                                          Platform.runLater(()->{
                                              ArrayList <dtoItem> itemSearch = new ArrayList <>();
                                              JSONObject J_obj =new JSONObject(data);
                                              String key =J_obj.getString("key");
                                              Gson gson =new Gson();
                                              String value =J_obj.getString("value");
                                              if ("SearchResponse".equals(key)){
                                                  Type itemListType = new TypeToken<ArrayList<dtoItem>>() {}.getType();
                                                  itemSearch=gson.fromJson(value, itemListType);
                                                  if (itemSearch != null){
                                                      finalTableViewII[0].getItems().clear();
                                                      finalitemsWL[0]=itemSearch;
                                                      finalTableViewII[0]=HB.getTableViewss();
                                                      finalTableColumnBarCode[0]=HB.getTableColumnBarCodess();
                                                      finalTableColumnItemName[0]=HB.getTableItemNamess();
                                                      finalTableColumnDescribe[0]=HB.getTableDescribess();
                                                      finalTableColumnCategory[0]=HB.getTablecategoryss();
                                                      finalTableColumnPrice[0]=HB.getTablepricss();
                                                      
                                                      finalTableColumnBarCode[0].setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getItembarcode()).asObject());
                                                      finalTableColumnItemName[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
                                                      finalTableColumnDescribe[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
                                                      finalTableColumnCategory[0].setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
                                                      finalTableColumnPrice[0].setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
                                                      finalTableViewII[0].getItems().addAll(finalitemsWL[0]);
                                                      finalTableViewII[0].getColumns().clear();
                                                      finalTableViewII[0].getColumns().setAll(finalTableColumnBarCode[0], finalTableColumnItemName[0],finalTableColumnDescribe[0],finalTableColumnCategory[0],finalTableColumnPrice[0]);

                                                  }else {
                                                      System.out.println("showRequestError");
                                                  }
                                              }
                                          });
                                      } catch (IOException ex) {
                                          Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                                      }
                                  }
                              }
                          }.start();
                      } catch (IOException ex) {  
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            });
           HB.getaddItem().addEventHandler(ActionEvent.ACTION, event ->{
        
            try {
                System.out.println("add button ");
                dtoItem selectedItems =finalTableViewII[0].getSelectionModel().getSelectedItem();
                System.out.println(selectedItems.getItembarcode());
               if(selectedItems !=null){
                   System.out.println("selectedss");
                    server =new Socket(IP,5000);
                    mouth =new PrintStream(server.getOutputStream());
                    ear =new DataInputStream(server.getInputStream());
                    Gson gson =new Gson();
                    dtoItem addItem =new dtoItem(selectedItems.getItembarcode(),selectedItems.getName(),selectedItems.getDescription(),selectedItems.getCategory(),selectedItems.getPrice());
                    addItem.setuserName(LoginController.user_name);
                    String json =gson.toJson(addItem);
                    JsonObject J_obj=new JsonObject();
                    System.out.println(addItem.getPrice());
                    System.out.println(addItem.getuserName());
                    System.out.println("1");
                    J_obj.addProperty("key", "Additem");
                    J_obj.addProperty("value",json);
                    mouth.println(J_obj);
                        } 
            new Thread (){
                public void run(){
                    while (true){
                        try {
                            String data=ear.readLine();
                            if (data == null){
                                System.out.println("Server closed the connection");
                                break;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        }
                }.start();
            }catch (IOException ex) {
                Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    });
    HB.removebtn().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        dtoItem selectedItems = finalTableView_items[0].getSelectionModel().getSelectedItem();

        if (selectedItems != null) {
            try {
                server = new Socket(IP, 5000);
                mouth = new PrintStream(server.getOutputStream());
                ear = new DataInputStream(server.getInputStream());
                Gson gson = new Gson();
                dtoItem addItem =new dtoItem(selectedItems.getItembarcode(),selectedItems.getName(),selectedItems.getDescription(),selectedItems.getCategory(),selectedItems.getPrice());
                addItem.setuserName(LoginController.user_name);
                String json =gson.toJson(addItem);
                JsonObject removeItemObj = new JsonObject();
                removeItemObj.addProperty("key", "RemoveFromWishlist");
                removeItemObj.addProperty("value", json);
                mouth.println(removeItemObj);
                mouth.flush();

                new Thread(() -> {
                    while (true) {
                        try {
                            String result = ear.readLine();

                            Platform.runLater(() -> {
                                if (result.equals("1")){
                                    finalItems[0].remove(selectedItems);
                                    finalTableView_items[0].getItems().clear();
                                    finalTableView_items[0].getItems().addAll(finalItems[0]);
                                }
                            });

                        } catch (IOException ex) {
                            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();

            } catch (IOException ex) {
                Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item to remove from the wishlist.");
            alert.showAndWait();
        }
    }
    });
        
    }
    public void initData(String userName, double balance,HomePageBase homePageBase) {
        homePageBase.setUserName(userName);
        homePageBase.setBalance(balance);  
    }
}