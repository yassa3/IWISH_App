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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class friendsBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TableView tableView;
    protected final TableColumn Name_Friends;
    protected final TableColumn Email_Friends;
    protected final Rectangle rectangle;
    protected final TextField textField;
    protected final Button AddB_Friend;
    protected final Button SearchB_Friend;
    protected final TableView name_Friendrequest;
    protected final TableColumn Name_Friendsrequest;
    protected final TableColumn email_Friendrequest;
    protected final Label friendslabel_friend;
    protected final Label Friendrequestlabel_friend;
    protected final Label SearchHP12;
    protected final Button DeclineB_Friend;
    protected final Button AcceptB_Friend;
    protected final Button RemoveB_Friend;
    protected final Button Buttongoback_friends;
    protected final ImageInput imageInput;
    protected final TableView tableView0;
    protected final TableColumn Name_Friends1_search;
    protected final TableColumn Email_Friends1_search;
    protected final Text alreadyexist_err;
    protected final Button refresh;

    public friendsBase() {

        imageView = new ImageView();
        tableView = new TableView();
        Name_Friends = new TableColumn();
        Email_Friends = new TableColumn();
        rectangle = new Rectangle();
        textField = new TextField();
        AddB_Friend = new Button();
        SearchB_Friend = new Button();
        name_Friendrequest = new TableView();
        Name_Friendsrequest = new TableColumn();
        email_Friendrequest = new TableColumn();
        friendslabel_friend = new Label();
        Friendrequestlabel_friend = new Label();
        SearchHP12 = new Label();
        DeclineB_Friend = new Button();
        AcceptB_Friend = new Button();
        RemoveB_Friend = new Button();
        Buttongoback_friends = new Button();
        imageInput = new ImageInput();
        tableView0 = new TableView();
        Name_Friends1_search = new TableColumn();
        Email_Friends1_search = new TableColumn();
        alreadyexist_err = new Text();
        refresh = new Button();

        setId("AnchorPane");
        setPrefHeight(888.0);
        setPrefWidth(826.0);

        imageView.setFitHeight(888.0);
        imageView.setFitWidth(826.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 5 (1).png").toExternalForm()));

        tableView.setLayoutX(89.0);
        tableView.setLayoutY(517.0);
        tableView.setPrefHeight(276.0);
        tableView.setPrefWidth(255.0);

        Name_Friends.setPrefWidth(130.0);
        Name_Friends.setText("Name");

        Email_Friends.setPrefWidth(124.0);
        Email_Friends.setText("E-mail");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(399.0);
        rectangle.setLayoutX(8.0);
        rectangle.setLayoutY(71.0);
        rectangle.setOpacity(0.15);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(796.0);

        textField.setLayoutX(141.0);
        textField.setLayoutY(98.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(324.0);

        AddB_Friend.setLayoutX(137.0);
        AddB_Friend.setLayoutY(404.0);
        AddB_Friend.setMnemonicParsing(false);
        AddB_Friend.setPrefHeight(52.0);
        AddB_Friend.setPrefWidth(110.0);
        AddB_Friend.setText("Add");
        AddB_Friend.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        AddB_Friend.setFont(new Font("Arial Bold", 24.0));

        SearchB_Friend.setLayoutX(500.0);
        SearchB_Friend.setLayoutY(87.0);
        SearchB_Friend.setMnemonicParsing(false);
        SearchB_Friend.setPrefHeight(52.0);
        SearchB_Friend.setPrefWidth(121.0);
        SearchB_Friend.setText("Search");
        SearchB_Friend.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        SearchB_Friend.setFont(new Font("Arial Bold", 20.0));

        name_Friendrequest.setLayoutX(453.0);
        name_Friendrequest.setLayoutY(512.0);
        name_Friendrequest.setPrefHeight(285.0);
        name_Friendrequest.setPrefWidth(276.0);

        Name_Friendsrequest.setPrefWidth(128.0);
        Name_Friendsrequest.setText("Name");

        email_Friendrequest.setPrefWidth(147.0);
        email_Friendrequest.setText("E-mail");

        friendslabel_friend.setAlignment(javafx.geometry.Pos.CENTER);
        friendslabel_friend.setLayoutX(32.0);
        friendslabel_friend.setLayoutY(460.0);
        friendslabel_friend.setPrefHeight(52.0);
        friendslabel_friend.setPrefWidth(381.0);
        friendslabel_friend.setText("Friends");
        friendslabel_friend.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        friendslabel_friend.setFont(new Font("Berlin Sans FB Demi Bold", 30.0));

        Friendrequestlabel_friend.setAlignment(javafx.geometry.Pos.CENTER);
        Friendrequestlabel_friend.setLayoutX(413.0);
        Friendrequestlabel_friend.setLayoutY(460.0);
        Friendrequestlabel_friend.setPrefHeight(52.0);
        Friendrequestlabel_friend.setPrefWidth(381.0);
        Friendrequestlabel_friend.setText("Friend request");
        Friendrequestlabel_friend.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        Friendrequestlabel_friend.setFont(new Font("Berlin Sans FB Demi Bold", 30.0));

        SearchHP12.setAlignment(javafx.geometry.Pos.CENTER);
        SearchHP12.setLayoutX(232.0);
        SearchHP12.setLayoutY(14.0);
        SearchHP12.setPrefHeight(52.0);
        SearchHP12.setPrefWidth(381.0);
        SearchHP12.setText("Friends");
        SearchHP12.setTextFill(javafx.scene.paint.Color.valueOf("#5e1566"));
        SearchHP12.setFont(new Font("Berlin Sans FB Demi Bold", 48.0));

        DeclineB_Friend.setLayoutX(591.0);
        DeclineB_Friend.setLayoutY(803.0);
        DeclineB_Friend.setMnemonicParsing(false);
        DeclineB_Friend.setPrefHeight(52.0);
        DeclineB_Friend.setPrefWidth(127.0);
        DeclineB_Friend.setText("Decline");
        DeclineB_Friend.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        DeclineB_Friend.setFont(new Font("Arial Bold", 24.0));

        AcceptB_Friend.setLayoutX(465.0);
        AcceptB_Friend.setLayoutY(803.0);
        AcceptB_Friend.setMnemonicParsing(false);
        AcceptB_Friend.setPrefHeight(52.0);
        AcceptB_Friend.setPrefWidth(121.0);
        AcceptB_Friend.setText("Accept");
        AcceptB_Friend.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        AcceptB_Friend.setFont(new Font("Arial Bold", 24.0));

        RemoveB_Friend.setLayoutX(141.0);
        RemoveB_Friend.setLayoutY(803.0);
        RemoveB_Friend.setMnemonicParsing(false);
        RemoveB_Friend.setPrefHeight(52.0);
        RemoveB_Friend.setPrefWidth(127.0);
        RemoveB_Friend.setText("Remove");
        RemoveB_Friend.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        RemoveB_Friend.setFont(new Font("Arial Bold", 24.0));

        Buttongoback_friends.setLayoutX(23.0);
        Buttongoback_friends.setLayoutY(14.0);
        Buttongoback_friends.setMnemonicParsing(false);
        Buttongoback_friends.setPrefHeight(57.0);
        Buttongoback_friends.setPrefWidth(58.0);
        Buttongoback_friends.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        Buttongoback_friends.setEffect(imageInput);
        Buttongoback_friends.setCursor(Cursor.HAND);

        tableView0.setLayoutX(137.0);
        tableView0.setLayoutY(149.0);
        tableView0.setPrefHeight(231.0);
        tableView0.setPrefWidth(486.0);

        Name_Friends1_search.setPrefWidth(243.0);
        Name_Friends1_search.setText("Name");

        Email_Friends1_search.setPrefWidth(242.0);
        Email_Friends1_search.setText("E-mail");

        alreadyexist_err.setFill(javafx.scene.paint.Color.RED);
        alreadyexist_err.setLayoutX(254.0);
        alreadyexist_err.setLayoutY(438.0);
        alreadyexist_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        alreadyexist_err.setStrokeWidth(0.0);
        alreadyexist_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        alreadyexist_err.setWrappingWidth(380.99998939037323);
        alreadyexist_err.setFont(new Font(20.0));

        refresh.setLayoutX(348.0);
        refresh.setLayoutY(474.0);
        refresh.setMnemonicParsing(false);
        refresh.setPrefHeight(43.0);
        refresh.setPrefWidth(102.0);
        refresh.setText("Refresh");
        refresh.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        refresh.setFont(new Font("Arial Bold", 18.0));

        getChildren().add(imageView);
        tableView.getColumns().add(Name_Friends);
        tableView.getColumns().add(Email_Friends);
        getChildren().add(tableView);
        getChildren().add(rectangle);
        getChildren().add(textField);
        getChildren().add(AddB_Friend);
        getChildren().add(SearchB_Friend);
        name_Friendrequest.getColumns().add(Name_Friendsrequest);
        name_Friendrequest.getColumns().add(email_Friendrequest);
        getChildren().add(name_Friendrequest);
        getChildren().add(friendslabel_friend);
        getChildren().add(Friendrequestlabel_friend);
        getChildren().add(SearchHP12);
        getChildren().add(DeclineB_Friend);
        getChildren().add(AcceptB_Friend);
        getChildren().add(RemoveB_Friend);
        getChildren().add(Buttongoback_friends);
        tableView0.getColumns().add(Name_Friends1_search);
        tableView0.getColumns().add(Email_Friends1_search);
        getChildren().add(tableView0);
        getChildren().add(alreadyexist_err);
        getChildren().add(refresh);

    }
    
public Button gethomeBtn()  {
        return Buttongoback_friends ;
    }
    public Button getsearchBtn()  {
        return SearchB_Friend ;
    }
    public Button getrefreshBtn()  {
        return refresh ;
    }
    public Button getaddBtn()  {
        return AddB_Friend ;
    }
    public Button getremoveBtn()  {
        return RemoveB_Friend ;
    }
    public Button getacceptBtn()  {
        return AcceptB_Friend ;
    }
    public Button getdeclineBtn()  {
        return DeclineB_Friend ;
    }
    public void seterr(String err)  {
        alreadyexist_err.setText(err); ;
    }
    public String getsearchField()  {
        return textField.getText();
    }
    public TableView getTableViewS()  {
        return tableView0;
    }
    public TableColumn getTableColumnUserS()  {
        return Name_Friends1_search;
    }
    public TableColumn getTableColumnEmailS()  {
        return Email_Friends1_search;
    }
    public TableView getTableViewA()  {
        return tableView;
    }
    public TableColumn getTableColumnUserA()  {
        return Name_Friends;
    }
    public TableColumn getTableColumnEmailA()  {
        return Email_Friends;
    }
    public TableView getTableViewR()  {
        return name_Friendrequest;
    }
    public TableColumn getTableColumnUserR()  {
        return Name_Friendsrequest;
    }
    public TableColumn getTableColumnEmailR()  {
        return email_Friendrequest;
    }
}
