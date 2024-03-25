/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.dtoItem;
import Scenes.JumiaBase;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Yassa Rashad
 */
public class JumiaController {
    Socket server;
    DataInputStream ear;
    PrintStream mouth;
    String IP = "127.0.0.1";
    private final List<dtoItem> products;
    private final TableView<dtoItem> finalTableView_items;
    private final TableColumn<dtoItem, String> finalTableColumnName_item;
    private final TableColumn<dtoItem, String> finalTableColumnDesc_item;
    private final TableColumn<dtoItem, String> finalTableColumnCat_item;
    private final TableColumn<dtoItem, Double> finalTableColumnPrice_item;
    static String URL = "https://www.jumia.com.eg/android-phones/samsung/?price=3600-5000&shipped_from=country_local#catalog-listing";
    static String Category = "Phones";
    public JumiaController(Stage stage, JumiaBase jumiaBase) {
        
        products = new ArrayList<>();
        finalTableView_items = jumiaBase.getTableView();
        finalTableColumnName_item = jumiaBase.getName();
        finalTableColumnDesc_item = jumiaBase.getDescription();
        finalTableColumnCat_item = jumiaBase.getCategory();
        finalTableColumnPrice_item = jumiaBase.getPrice();
        finalTableColumnName_item.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        finalTableColumnDesc_item.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
        finalTableColumnCat_item.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
        finalTableColumnPrice_item.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        finalTableView_items.getColumns().setAll(finalTableColumnName_item, finalTableColumnDesc_item,finalTableColumnCat_item, finalTableColumnPrice_item);
        jumiaBase.getPhones().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    URL = "https://www.jumia.com.eg/android-phones/?price=3600-5000&shipped_from=country_local#catalog-listing";
                    Category = "Phones";
                }
        });
        jumiaBase.getLabtops().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    URL = "https://www.jumia.com.eg/laptops/";
                    Category = "Labtops";
                }
        });
        jumiaBase.getTelevisions().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    URL = "https://www.jumia.com.eg/televisions/";
                    Category = "Televisions";
                }
        });
        jumiaBase.getVideogames().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    URL = "https://www.jumia.com.eg/video-games/";
                    Category = "VideoGames";
                }
        });
        jumiaBase.getHealth().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    URL = "https://www.jumia.com.eg/health-beauty/";
                    Category = "Health&Beauty";
                }
        });
        jumiaBase.getGet().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    products.clear();
                    ArrayList<dtoItem> scrapedProducts = scrapeProducts();
                    products.addAll(scrapedProducts);
                    finalTableView_items.setItems(FXCollections.observableArrayList(products));
                }
        });
        jumiaBase.getInsert().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        final dtoItem selectedItem = finalTableView_items.getSelectionModel().getSelectedItem();
                        Random rand = new Random();
                        int x = rand.nextInt(100000); 
                        selectedItem.setItembarcode(x);
                        server = new Socket(IP, 5000);
                        mouth = new PrintStream(server.getOutputStream());
                        ear = new DataInputStream(server.getInputStream()); 
                        Gson gson = new Gson();
                        String json = gson.toJson(selectedItem);
                        JsonObject J_obj = new JsonObject();
                        J_obj.addProperty("key", "insertitems");
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
                                        Platform.runLater(() -> {
                                            if ("1".equals(data)){
                                                Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                                                infoAlert.setTitle("Successfully Insertion");
                                                infoAlert.setHeaderText(null);
                                                infoAlert.setContentText("The Item inserted in database successfully");
                                                infoAlert.showAndWait();
                                            }
                                            
                                        });
                                    } catch (IOException ex) {
                                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }.start();  } catch (IOException ex) {
                        Logger.getLogger(JumiaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                });
        jumiaBase.getButtongoback_friends().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SceneController sceneController = new SceneController(stage);
                                    try {
                                        sceneController.switchtoscenelogin();
                                    } catch (IOException ex) {
                                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                
                }
            });
    }

    private ArrayList<dtoItem> scrapeProducts() {
        ArrayList<dtoItem> products = new ArrayList<>();
        try {
                Document document = Jsoup.connect(URL).get();
                Elements productElements = document.select(".info");
                for (Element productElement : productElements) {
                    String productNameAndDescription = productElement.select(".name").text();
                    String[] nameAndDescriptionArray;
                    if (productNameAndDescription.contains(" - ")) {
                        nameAndDescriptionArray = productNameAndDescription.split(" - ", 2);
                    } else if (productNameAndDescription.contains(",")) {
                        nameAndDescriptionArray = productNameAndDescription.split(",", 2);
                    } else {
                        nameAndDescriptionArray = productNameAndDescription.split("\\s", 3);
                    }

                    if (nameAndDescriptionArray.length >= 2) {
                        String productName = nameAndDescriptionArray[0].trim();
                        String productDescription = nameAndDescriptionArray[1].trim();
                        String productCategory = Category;
                        String rawProductPrice = productElement.select(".prc").text();
                        String numericPrice = rawProductPrice.replaceAll("[^\\d.]+", "");
                        double productPrice = Double.parseDouble(numericPrice);

                        dtoItem product = new dtoItem(productName, productPrice, productDescription, productCategory);
                        products.add(product);
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}