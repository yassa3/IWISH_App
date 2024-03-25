package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FriendWLBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField textField;
    protected final TableView tableView;
    protected final TableColumn name_FriendWL;
    protected final TableColumn email_FriendWL;
    protected final Label FriendWLLabel;
    protected final Button B_Contribute_FriendWL;
    protected final Button Buttongoback_friends;
    protected final ImageInput imageInput;
    protected final TableView tableView0;
    protected final TableColumn barcode_FriendWL;
    protected final TableColumn ItemName_FriendWL;
    protected final TableColumn Category_FriendWL;
    protected final TableColumn Describe_FriendWL;
    protected final TableColumn price_FriendWL;
    protected final Text notenough_err;
    protected final Button showitems_btn;
    protected final Button showfriends_btn;

    public FriendWLBase() {

        imageView = new ImageView();
        textField = new TextField();
        tableView = new TableView();
        name_FriendWL = new TableColumn();
        email_FriendWL = new TableColumn();
        FriendWLLabel = new Label();
        B_Contribute_FriendWL = new Button();
        Buttongoback_friends = new Button();
        imageInput = new ImageInput();
        tableView0 = new TableView();
        barcode_FriendWL = new TableColumn();
        ItemName_FriendWL = new TableColumn();
        Category_FriendWL = new TableColumn();
        Describe_FriendWL = new TableColumn();
        price_FriendWL = new TableColumn();
        notenough_err = new Text();
        showitems_btn = new Button();
        showfriends_btn = new Button();

        setId("AnchorPane");
        setPrefHeight(898.0);
        setPrefWidth(999.0);

        imageView.setFitHeight(898.0);
        imageView.setFitWidth(999.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 5 (1).png").toExternalForm()));

        textField.setLayoutX(407.0);
        textField.setLayoutY(806.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(324.0);

        tableView.setLayoutX(14.0);
        tableView.setLayoutY(113.0);
        tableView.setPrefHeight(398.0);
        tableView.setPrefWidth(371.0);

        name_FriendWL.setPrefWidth(183.0);
        name_FriendWL.setText("Name");

        email_FriendWL.setPrefWidth(215.0);
        email_FriendWL.setText("E-mail");

        FriendWLLabel.setAlignment(javafx.geometry.Pos.CENTER);
        FriendWLLabel.setLayoutX(309.0);
        FriendWLLabel.setLayoutY(20.0);
        FriendWLLabel.setPrefHeight(52.0);
        FriendWLLabel.setPrefWidth(381.0);
        FriendWLLabel.setText("FriendWL");
        FriendWLLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5e1566"));
        FriendWLLabel.setFont(new Font("Berlin Sans FB Demi Bold", 48.0));

        B_Contribute_FriendWL.setLayoutX(745.0);
        B_Contribute_FriendWL.setLayoutY(795.0);
        B_Contribute_FriendWL.setMnemonicParsing(false);
        B_Contribute_FriendWL.setPrefHeight(52.0);
        B_Contribute_FriendWL.setPrefWidth(160.0);
        B_Contribute_FriendWL.setText("contribute");
        B_Contribute_FriendWL.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        B_Contribute_FriendWL.setFont(new Font("Arial Bold", 24.0));

        Buttongoback_friends.setLayoutX(24.0);
        Buttongoback_friends.setLayoutY(36.0);
        Buttongoback_friends.setMnemonicParsing(false);
        Buttongoback_friends.setPrefHeight(57.0);
        Buttongoback_friends.setPrefWidth(58.0);
        Buttongoback_friends.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        Buttongoback_friends.setEffect(imageInput);
        Buttongoback_friends.setCursor(Cursor.HAND);

        tableView0.setLayoutX(397.0);
        tableView0.setLayoutY(113.0);
        tableView0.setPrefHeight(662.0);
        tableView0.setPrefWidth(588.0);

        barcode_FriendWL.setPrefWidth(90.0);
        barcode_FriendWL.setText("Barcode");

        ItemName_FriendWL.setPrefWidth(106.0);
        ItemName_FriendWL.setText("Item Name");

        Category_FriendWL.setPrefWidth(92.0);
        Category_FriendWL.setText("Category");

        Describe_FriendWL.setPrefWidth(188.0);
        Describe_FriendWL.setText("Describe");

        price_FriendWL.setPrefWidth(112.0);
        price_FriendWL.setText("price");


        notenough_err.setFill(javafx.scene.paint.Color.RED);
        notenough_err.setLayoutX(407.0);
        notenough_err.setLayoutY(878.0);
        notenough_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        notenough_err.setStrokeWidth(0.0);
        notenough_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        notenough_err.setWrappingWidth(486.89453125);
        notenough_err.setFont(new Font(20.0));

        showitems_btn.setLayoutX(225.0);
        showitems_btn.setLayoutY(795.0);
        showitems_btn.setMnemonicParsing(false);
        showitems_btn.setPrefHeight(52.0);
        showitems_btn.setPrefWidth(160.0);
        showitems_btn.setText("Show Items");
        showitems_btn.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        showitems_btn.setFont(new Font("Arial Bold", 20.0));

        showfriends_btn.setLayoutX(32.0);
        showfriends_btn.setLayoutY(796.0);
        showfriends_btn.setMnemonicParsing(false);
        showfriends_btn.setPrefHeight(52.0);
        showfriends_btn.setPrefWidth(160.0);
        showfriends_btn.setText("Show Friends");
        showfriends_btn.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        showfriends_btn.setFont(new Font("Arial Bold", 20.0));

        getChildren().add(imageView);
        getChildren().add(textField);
        tableView.getColumns().add(name_FriendWL);
        tableView.getColumns().add(email_FriendWL);
        getChildren().add(tableView);
        getChildren().add(FriendWLLabel);
        getChildren().add(B_Contribute_FriendWL);
        getChildren().add(Buttongoback_friends);
        tableView0.getColumns().add(barcode_FriendWL);
        tableView0.getColumns().add(ItemName_FriendWL);
        tableView0.getColumns().add(Category_FriendWL);
        tableView0.getColumns().add(Describe_FriendWL);
        tableView0.getColumns().add(price_FriendWL);
        getChildren().add(tableView0);
        getChildren().add(notenough_err);
        getChildren().add(showitems_btn);
        getChildren().add(showfriends_btn);

    }
    public Button getContributebtn(){
        return B_Contribute_FriendWL;
    }
    public Button getHomebtn(){
        return Buttongoback_friends;
    }
    public Button getFriendsbtn(){
        return showfriends_btn;
    }
    public Button getItemsbtn(){
        return showitems_btn;
    }
    public String getsearchField()  {
        return textField.getText();
    }
    public void seterr(String err)  {
        notenough_err.setText(err); ;
    }
    public TableView getTableViewF()  {
        return tableView;
    }
    public TableColumn getTableColumnUserF()  {
        return name_FriendWL;
    }
    public TableColumn getTableColumnEmailF()  {
        return email_FriendWL;
    }
    public TableView getTableViewI()  {
        return tableView0;
    }
    public TableColumn getTableColumnBarcodeI()  {
        return barcode_FriendWL;
    }
    public TableColumn getTableColumnNameI()  {
        return ItemName_FriendWL;
    }
    public TableColumn getTableColumnDescI()  {
        return Describe_FriendWL;
    }
    public TableColumn getTableColumnCatI()  {
        return Category_FriendWL;
    }
    public TableColumn getTableColumnPriceI()  {
        return price_FriendWL;
    }
   
}
