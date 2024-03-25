package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AdminBase extends AnchorPane {

    protected final ImageView home;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Text text;
    protected final TextField barcode;
    protected final TextField item_name;
    protected final TextField description;
    protected final TextField category;
    protected final TextField price;
    protected final Button insert;
    protected final Button Buttongoback_friends;
    protected final ImageInput imageInput;

    public AdminBase() {

        home = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        text = new Text();
        barcode = new TextField();
        item_name = new TextField();
        description = new TextField();
        category = new TextField();
        price = new TextField();
        insert = new Button();
        Buttongoback_friends = new Button();
        imageInput = new ImageInput();

        setId("AnchorPane");
        setPrefHeight(900.0);
        setPrefWidth(1300.0);

        home.setFitHeight(900.0);
        home.setFitWidth(1300.0);
        home.setImage(new Image(getClass().getResource("Images/Home.jpg").toExternalForm()));

        label.setLayoutX(58.0);
        label.setLayoutY(135.0);
        label.setText("Barcode");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(30.0));

        label0.setLayoutX(58.0);
        label0.setLayoutY(234.0);
        label0.setText("Name");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(30.0));

        label1.setLayoutX(58.0);
        label1.setLayoutY(321.0);
        label1.setText("Description");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(30.0));

        label2.setLayoutX(58.0);
        label2.setLayoutY(412.0);
        label2.setPrefHeight(45.0);
        label2.setPrefWidth(150.0);
        label2.setText("Category");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font(30.0));

        label3.setLayoutX(58.0);
        label3.setLayoutY(514.0);
        label3.setText("Price");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font(30.0));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(565.0);
        text.setLayoutY(81.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Admin ");
        text.setFont(new Font("System Bold", 50.0));

        barcode.setLayoutX(498.0);
        barcode.setLayoutY(142.0);
        barcode.setPrefHeight(31.0);
        barcode.setPrefWidth(364.0);
        barcode.setPromptText("Enter Barcode");

        item_name.setLayoutX(498.0);
        item_name.setLayoutY(241.0);
        item_name.setPrefHeight(31.0);
        item_name.setPrefWidth(364.0);
        item_name.setPromptText("Enter Item Name");

        description.setLayoutX(498.0);
        description.setLayoutY(328.0);
        description.setPrefHeight(31.0);
        description.setPrefWidth(364.0);
        description.setPromptText("Enter Item Description");

        category.setLayoutX(498.0);
        category.setLayoutY(419.0);
        category.setPrefHeight(31.0);
        category.setPrefWidth(364.0);
        category.setPromptText("Enter Item Category");

        price.setLayoutX(498.0);
        price.setLayoutY(521.0);
        price.setPrefHeight(31.0);
        price.setPrefWidth(364.0);
        price.setPromptText("Enter Item Price");

        insert.setLayoutX(166.0);
        insert.setLayoutY(651.0);
        insert.setMnemonicParsing(false);
        insert.setPrefHeight(44.0);
        insert.setPrefWidth(316.0);
        insert.setText("Insert");
        insert.setTextFill(javafx.scene.paint.Color.valueOf("#9b00c6"));
        insert.setFont(new Font(20.0));

        Buttongoback_friends.setLayoutX(69.0);
        Buttongoback_friends.setLayoutY(32.0);
        Buttongoback_friends.setMnemonicParsing(false);
        Buttongoback_friends.setPrefHeight(57.0);
        Buttongoback_friends.setPrefWidth(58.0);
        Buttongoback_friends.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-back-50.png").toExternalForm()));
        Buttongoback_friends.setEffect(imageInput);
        Buttongoback_friends.setCursor(Cursor.HAND);

        getChildren().add(home);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(text);
        getChildren().add(barcode);
        getChildren().add(item_name);
        getChildren().add(description);
        getChildren().add(category);
        getChildren().add(price);
        getChildren().add(insert);
        getChildren().add(Buttongoback_friends);

    }
    public String getItem_name() {
        return item_name.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getBarcode() {
        return barcode.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getCategory() {
        return category.getText();
    }

    public Button getInsert() {
        return insert;
    }
    public Button getLogin() {
        return Buttongoback_friends;
    }
}
