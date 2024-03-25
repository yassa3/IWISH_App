package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class JumiaBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button get;
    protected final Button insert;
    protected final TableView tableView;
    protected final TableColumn name;
    protected final TableColumn description;
    protected final TableColumn category;
    protected final TableColumn price;
    protected final Text text;
    protected final Button Buttongoback_friends;
    protected final ImageInput imageInput;
    protected final Button phones;
    protected final Button labtops;
    protected final Button videogames;
    protected final Button televisions;
    protected final Button health;

    public JumiaBase() {

        imageView = new ImageView();
        get = new Button();
        insert = new Button();
        tableView = new TableView();
        name = new TableColumn();
        description = new TableColumn();
        category = new TableColumn();
        price = new TableColumn();
        text = new Text();
        Buttongoback_friends = new Button();
        imageInput = new ImageInput();
        phones = new Button();
        labtops = new Button();
        videogames = new Button();
        televisions = new Button();
        health = new Button();

        setId("AnchorPane");
        setPrefHeight(900.0);
        setPrefWidth(1300.0);

        imageView.setFitHeight(900.0);
        imageView.setFitWidth(1300.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        get.setLayoutX(685.0);
        get.setLayoutY(830.0);
        get.setMnemonicParsing(false);
        get.setPrefHeight(39.0);
        get.setPrefWidth(189.0);
        get.setText("Get");
        get.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        get.setFont(new Font(18.0));

        insert.setLayoutX(972.0);
        insert.setLayoutY(830.0);
        insert.setMnemonicParsing(false);
        insert.setPrefHeight(39.0);
        insert.setPrefWidth(189.0);
        insert.setText("Insert");
        insert.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        insert.setFont(new Font(18.0));

        tableView.setLayoutX(529.0);
        tableView.setLayoutY(75.0);
        tableView.setPrefHeight(716.0);
        tableView.setPrefWidth(755.0);

        name.setPrefWidth(158.0);
        name.setText("Name");

        description.setPrefWidth(344.0);
        description.setText("Description");

        category.setPrefWidth(149.0);
        category.setText("Category");

        price.setPrefWidth(103.0);
        price.setText("Price");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(125.0);
        text.setLayoutY(283.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Admin");
        text.setFont(new Font("System Bold", 50.0));

        Buttongoback_friends.setLayoutX(45.0);
        Buttongoback_friends.setLayoutY(47.0);
        Buttongoback_friends.setMnemonicParsing(false);
        Buttongoback_friends.setPrefHeight(57.0);
        Buttongoback_friends.setPrefWidth(58.0);
        Buttongoback_friends.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-back-50.png").toExternalForm()));
        Buttongoback_friends.setEffect(imageInput);
        Buttongoback_friends.setCursor(Cursor.HAND);

        phones.setLayoutX(529.0);
        phones.setLayoutY(24.0);
        phones.setMnemonicParsing(false);
        phones.setText("Phones");
        phones.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        phones.setFont(new Font(18.0));

        labtops.setLayoutX(669.0);
        labtops.setLayoutY(24.0);
        labtops.setMnemonicParsing(false);
        labtops.setText("Labtops");
        labtops.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        labtops.setFont(new Font(18.0));

        videogames.setLayoutX(811.0);
        videogames.setLayoutY(24.0);
        videogames.setMnemonicParsing(false);
        videogames.setText("VideoGames");
        videogames.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        videogames.setFont(new Font(18.0));

        televisions.setLayoutX(990.0);
        televisions.setLayoutY(24.0);
        televisions.setMnemonicParsing(false);
        televisions.setText("Televisions");
        televisions.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        televisions.setFont(new Font(18.0));

        health.setLayoutX(1149.0);
        health.setLayoutY(24.0);
        health.setMnemonicParsing(false);
        health.setText("Healt&Beauty");
        health.setTextFill(javafx.scene.paint.Color.valueOf("#ab1da2"));
        health.setFont(new Font(18.0));

        getChildren().add(imageView);
        getChildren().add(get);
        getChildren().add(insert);
        tableView.getColumns().add(name);
        tableView.getColumns().add(description);
        tableView.getColumns().add(category);
        tableView.getColumns().add(price);
        getChildren().add(tableView);
        getChildren().add(text);
        getChildren().add(Buttongoback_friends);
        getChildren().add(phones);
        getChildren().add(labtops);
        getChildren().add(videogames);
        getChildren().add(televisions);
        getChildren().add(health);

    }

    public Button getGet() {
        return get;
    }

    public Button getInsert() {
        return insert;
    }

    public TableView getTableView() {
        return tableView;
    }

    public TableColumn getName() {
        return name;
    }

    public TableColumn getDescription() {
        return description;
    }

    public TableColumn getCategory() {
        return category;
    }

    public TableColumn getPrice() {
        return price;
    }

    public Button getButtongoback_friends() {
        return Buttongoback_friends;
    }

    public Button getPhones() {
        return phones;
    }

    public Button getLabtops() {
        return labtops;
    }

    public Button getVideogames() {
        return videogames;
    }

    public Button getTelevisions() {
        return televisions;
    }

    public Button getHealth() {
        return health;
    }
    
}
