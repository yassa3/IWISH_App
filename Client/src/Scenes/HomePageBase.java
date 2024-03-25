package Scenes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class HomePageBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Button ProfileHP;
    protected final Button FriendHomeButt;
    protected final Button FriendWLHP;
    protected final Button WalletHP;
    protected final Button AboutHP;
    protected final Button LogoutHP;
    protected final Line line;
    protected final Line line0;
    protected final TableView tableView;
    protected final TableColumn barcodeColumnHomeRemove;
    protected final TableColumn ItemColumnHomeRemove;
    protected final TableColumn DescribeColumnHomeRemove;
    protected final TableColumn CategoryColumnHomeRemove;
    protected final TableColumn priceColumnHomeRemove;
    protected final Button RemoveBHP;
    protected final TextField textField;
    protected final Button AddBHP;
    protected final Label balance_label_HP;
    protected final Label SearchHP1;
    protected final Label SearchHP11;
    protected final Button SearchBHP1;
    protected final TableView tableView0;
    protected final TableColumn barcode_searchHP1;
    protected final TableColumn ItemName_searchHP1;
    protected final TableColumn Describe_searchHP1;
    protected final TableColumn Category_searchHP1;
    protected final TableColumn price_searchHP1;
    protected final Text textHP__;
    protected final Text textHP1;
    protected final ImageView imageView0;
    protected final Button WishListButton;

    public HomePageBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        ProfileHP = new Button();
        FriendHomeButt = new Button();
        FriendWLHP = new Button();
        WalletHP = new Button();
        AboutHP = new Button();
        LogoutHP = new Button();
        line = new Line();
        line0 = new Line();
        tableView = new TableView();
        barcodeColumnHomeRemove = new TableColumn();
        ItemColumnHomeRemove = new TableColumn();
        DescribeColumnHomeRemove = new TableColumn();
        CategoryColumnHomeRemove = new TableColumn();
        priceColumnHomeRemove = new TableColumn();
        RemoveBHP = new Button();
        textField = new TextField();
        AddBHP = new Button();
        balance_label_HP = new Label();
        SearchHP1 = new Label();
        SearchHP11 = new Label();
        SearchBHP1 = new Button();
        tableView0 = new TableView();
        barcode_searchHP1 = new TableColumn();
        ItemName_searchHP1 = new TableColumn();
        Describe_searchHP1 = new TableColumn();
        Category_searchHP1 = new TableColumn();
        price_searchHP1 = new TableColumn();
        textHP__ = new Text();
        textHP1 = new Text();
        imageView0 = new ImageView();
        WishListButton = new Button();

        setId("AnchorPane");
        setPrefHeight(904.0);
        setPrefWidth(1117.0);

        imageView.setFitHeight(904.0);
        imageView.setFitWidth(1117.0);
        imageView.setImage(new Image(getClass().getResource("Images/Home.jpg").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#c9c9c9"));
        rectangle.setHeight(711.0);
        rectangle.setLayoutX(58.0);
        rectangle.setLayoutY(97.0);
        rectangle.setOpacity(0.3);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#aeaeae"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(995.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.WHITE);
        rectangle0.setHeight(104.0);
        rectangle0.setLayoutX(689.0);
        rectangle0.setLayoutY(246.0);
        rectangle0.setOpacity(0.15);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(354.0);

        ProfileHP.setLayoutX(257.0);
        ProfileHP.setLayoutY(111.0);
        ProfileHP.setMnemonicParsing(false);
        ProfileHP.setPrefHeight(52.0);
        ProfileHP.setPrefWidth(110.0);
        ProfileHP.setText("Profile");
        ProfileHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        ProfileHP.setFont(new Font("Arial Bold", 22.0));

        FriendHomeButt.setLayoutX(388.0);
        FriendHomeButt.setLayoutY(111.0);
        FriendHomeButt.setMnemonicParsing(false);
        FriendHomeButt.setPrefHeight(52.0);
        FriendHomeButt.setPrefWidth(110.0);
        FriendHomeButt.setText("Friend");
        FriendHomeButt.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        FriendHomeButt.setFont(new Font("Arial Bold", 22.0));

        FriendWLHP.setLayoutX(516.0);
        FriendWLHP.setLayoutY(111.0);
        FriendWLHP.setMnemonicParsing(false);
        FriendWLHP.setPrefHeight(52.0);
        FriendWLHP.setPrefWidth(134.0);
        FriendWLHP.setText("FriendWL");
        FriendWLHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        FriendWLHP.setFont(new Font("Arial Bold", 22.0));

        WalletHP.setLayoutX(669.0);
        WalletHP.setLayoutY(111.0);
        WalletHP.setMnemonicParsing(false);
        WalletHP.setPrefHeight(52.0);
        WalletHP.setPrefWidth(110.0);
        WalletHP.setText("Wallet");
        WalletHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        WalletHP.setFont(new Font("System Bold", 22.0));

        AboutHP.setLayoutX(799.0);
        AboutHP.setLayoutY(111.0);
        AboutHP.setMnemonicParsing(false);
        AboutHP.setPrefHeight(52.0);
        AboutHP.setPrefWidth(110.0);
        AboutHP.setText("About");
        AboutHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        AboutHP.setFont(new Font("Arial Bold", 22.0));

        LogoutHP.setLayoutX(932.0);
        LogoutHP.setLayoutY(111.0);
        LogoutHP.setMnemonicParsing(false);
        LogoutHP.setPrefHeight(52.0);
        LogoutHP.setPrefWidth(110.0);
        LogoutHP.setText("Logout");
        LogoutHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        LogoutHP.setFont(new Font("Arial Bold", 22.0));

        line.setEndX(820.0);
        line.setEndY(-27.0);
        line.setLayoutX(233.0);
        line.setLayoutY(213.0);
        line.setStartX(-175.0);
        line.setStartY(-33.0);
        line.setStroke(javafx.scene.paint.Color.WHITE);

        line0.setEndX(34.0);
        line0.setEndY(-196.0);
        line0.setFill(javafx.scene.paint.Color.BLACK);
        line0.setLayoutX(180.0);
        line0.setLayoutY(293.0);
        line0.setStartX(34.0);
        line0.setStartY(-112.0);
        line0.setStroke(javafx.scene.paint.Color.WHITE);

        tableView.setLayoutX(66.0);
        tableView.setLayoutY(354.0);
        tableView.setPrefHeight(373.0);
        tableView.setPrefWidth(517.0);

        barcodeColumnHomeRemove.setPrefWidth(90.0);
        barcodeColumnHomeRemove.setText("barcode");

        ItemColumnHomeRemove.setPrefWidth(106.0);
        ItemColumnHomeRemove.setText("Item Name");

        DescribeColumnHomeRemove.setPrefWidth(116.0);
        DescribeColumnHomeRemove.setText("Describe");

        CategoryColumnHomeRemove.setPrefWidth(101.0);
        CategoryColumnHomeRemove.setText("Category");

        priceColumnHomeRemove.setPrefWidth(113.0);
        priceColumnHomeRemove.setText("price");

        RemoveBHP.setLayoutX(97.0);
        RemoveBHP.setLayoutY(739.0);
        RemoveBHP.setMnemonicParsing(false);
        RemoveBHP.setPrefHeight(52.0);
        RemoveBHP.setPrefWidth(134.0);
        RemoveBHP.setText("Remove");
        RemoveBHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        RemoveBHP.setFont(new Font("Arial Bold", 24.0));

        textField.setLayoutX(699.0);
        textField.setLayoutY(283.0);
        textField.setPrefHeight(16.0);
        textField.setPrefWidth(201.0);

        AddBHP.setLayoutX(765.0);
        AddBHP.setLayoutY(739.0);
        AddBHP.setMnemonicParsing(false);
        AddBHP.setPrefHeight(52.0);
        AddBHP.setPrefWidth(110.0);
        AddBHP.setText("Add");
        AddBHP.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        AddBHP.setFont(new Font("Arial Bold", 24.0));

        balance_label_HP.setAlignment(javafx.geometry.Pos.CENTER);
        balance_label_HP.setLayoutX(762.0);
        balance_label_HP.setLayoutY(193.0);
        balance_label_HP.setPrefHeight(52.0);
        balance_label_HP.setPrefWidth(134.0);
        balance_label_HP.setText("balance");
        balance_label_HP.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        balance_label_HP.setFont(new Font("Arial Bold", 30.0));

        SearchHP1.setAlignment(javafx.geometry.Pos.CENTER);
        SearchHP1.setLayoutX(104.0);
        SearchHP1.setLayoutY(272.0);
        SearchHP1.setPrefHeight(52.0);
        SearchHP1.setPrefWidth(381.0);
        SearchHP1.setText("Your WishList");
        SearchHP1.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        SearchHP1.setFont(new Font("Berlin Sans FB Demi Bold", 45.0));

        SearchHP11.setAlignment(javafx.geometry.Pos.CENTER);
        SearchHP11.setLayoutX(381.0);
        SearchHP11.setLayoutY(29.0);
        SearchHP11.setPrefHeight(52.0);
        SearchHP11.setPrefWidth(381.0);
        SearchHP11.setText("Home");
        SearchHP11.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        SearchHP11.setFont(new Font("Berlin Sans FB Demi Bold", 50.0));

        SearchBHP1.setLayoutX(916.0);
        SearchBHP1.setLayoutY(272.0);
        SearchBHP1.setMnemonicParsing(false);
        SearchBHP1.setPrefHeight(52.0);
        SearchBHP1.setPrefWidth(121.0);
        SearchBHP1.setText("Search");
        SearchBHP1.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        SearchBHP1.setFont(new Font("Arial Bold", 20.0));

        tableView0.setLayoutX(598.0);
        tableView0.setLayoutY(353.0);
        tableView0.setPrefHeight(373.0);
        tableView0.setPrefWidth(444.0);

        barcode_searchHP1.setPrefWidth(78.0);
        barcode_searchHP1.setText("barcode");

        ItemName_searchHP1.setPrefWidth(89.0);
        ItemName_searchHP1.setText("Item Name");

        Describe_searchHP1.setPrefWidth(102.0);
        Describe_searchHP1.setText("Describe");

        Category_searchHP1.setPrefWidth(93.0);
        Category_searchHP1.setText("Category");

        price_searchHP1.setPrefWidth(81.0);
        price_searchHP1.setText("price");

        textHP__.setFill(javafx.scene.paint.Color.WHITE);
        textHP__.setLayoutX(896.0);
        textHP__.setLayoutY(229.0);
        textHP__.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textHP__.setStrokeWidth(0.0);
        textHP__.setText("0");
        textHP__.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textHP__.setWrappingWidth(144.6708984375);
        textHP__.setFont(new Font("Arial Bold", 30.0));

        textHP1.setFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        textHP1.setLayoutX(131.0);
        textHP1.setLayoutY(230.0);
        textHP1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textHP1.setStrokeWidth(0.0);
        textHP1.setText("User_Name");
        textHP1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textHP1.setWrappingWidth(327.6708984375);
        textHP1.setFont(new Font("Arial Bold", 30.0));

        imageView0.setFitHeight(92.0);
        imageView0.setFitWidth(121.0);
        imageView0.setLayoutX(66.0);
        imageView0.setLayoutY(91.0);
        imageView0.setImage(new Image(getClass().getResource("Images/png-image.png").toExternalForm()));

        WishListButton.setLayoutX(374.0);
        WishListButton.setLayoutY(744.0);
        WishListButton.setMnemonicParsing(false);
        WishListButton.setText("My Wish List");
        WishListButton.setTextFill(javafx.scene.paint.Color.valueOf("#620097"));
        WishListButton.setFont(new Font("Arial Bold", 24.0));

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(ProfileHP);
        getChildren().add(FriendHomeButt);
        getChildren().add(FriendWLHP);
        getChildren().add(WalletHP);
        getChildren().add(AboutHP);
        getChildren().add(LogoutHP);
        getChildren().add(line);
        getChildren().add(line0);
        tableView.getColumns().add(barcodeColumnHomeRemove);
        tableView.getColumns().add(ItemColumnHomeRemove);
        tableView.getColumns().add(DescribeColumnHomeRemove);
        tableView.getColumns().add(CategoryColumnHomeRemove);
        tableView.getColumns().add(priceColumnHomeRemove);
        getChildren().add(tableView);
        getChildren().add(RemoveBHP);
        getChildren().add(textField);
        getChildren().add(AddBHP);
        getChildren().add(balance_label_HP);
        getChildren().add(SearchHP1);
        getChildren().add(SearchHP11);
        getChildren().add(SearchBHP1);
        tableView0.getColumns().add(barcode_searchHP1);
        tableView0.getColumns().add(ItemName_searchHP1);
        tableView0.getColumns().add(Describe_searchHP1);
        tableView0.getColumns().add(Category_searchHP1);
        tableView0.getColumns().add(price_searchHP1);
        getChildren().add(tableView0);
        getChildren().add(textHP__);
        getChildren().add(textHP1);
        getChildren().add(imageView0);
        getChildren().add(WishListButton);

    }
    public String getUserName(){
        return textHP__.getText();
    }
    public String getBalance(){
        return textHP1.getText();
    }
    public String getSearchItem(){
        return textField.getText();
    }
    public void setUserName(String user){
        textHP1 .setText(user);
    }
    public void setBalance(double balance){
        textHP__.setText(Double.toString(balance));
    }
    public Button getprofilebtn(){
        return ProfileHP;
    }
    public Button getfriendhomebtn(){
        return FriendHomeButt;
    }
    public Button getfriendwlbtn(){
        return FriendWLHP;
    }
    public Button getwalletbtn(){
        return WalletHP;
    }
    public Button getaboutbtn(){
        return AboutHP;
    }
    public Button getlogoutbtn(){
        return LogoutHP;
    }
    public String getsearchshow (){
        return textField.getText();
    }
    
    public Button searchbtn(){
        return SearchBHP1;
    }
    
    public Button getaddItem(){
        return AddBHP;
    }
    public Button removebtn(){
        return RemoveBHP;
    }
    public Button getWishListButton(){
        return WishListButton;
    }
    public TableColumn getTableColumnBarCode(){
        return barcodeColumnHomeRemove;
    }
    public TableColumn getTableItemName(){
        return ItemColumnHomeRemove;
    }
    public TableColumn getTableDescribe(){
        return DescribeColumnHomeRemove;
    }
    public TableColumn getTablecategory(){
        return CategoryColumnHomeRemove;
    }
    public TableColumn getTableprice (){
        return priceColumnHomeRemove;
    }
    public TableView getTableView(){
        return tableView;
    }
    public TableColumn getTableColumnBarCodess(){
        return barcode_searchHP1;
    }
    public TableColumn getTableItemNamess(){
        return ItemName_searchHP1;
    }
    public TableColumn getTableDescribess(){
        return Describe_searchHP1;
    }
    public TableColumn getTablecategoryss(){
        return Category_searchHP1;
    }
    public TableColumn getTablepricss(){
        return price_searchHP1;
    }
    public TableView getTableViewss(){
        return tableView0;
    }
    
}
