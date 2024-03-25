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

public  class walletRegistrationBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label cno2_label;
    protected final Label cvv_label;
    protected final Label date_label;
    protected final TextField namewallet_textfield;
    protected final TextField cno2_textfield;
    protected final TextField cvv_textfield;
    protected final TextField datewallet_textfield;
    protected final Button add2_button;
    protected final Button button;
    protected final Label alreadyaddedone_label;
    protected final Label walletregister_title;
    protected final Button Buttongoback_home;
    protected final ImageInput imageInput;
    protected final Text alreadyexist_error;

    public walletRegistrationBase() {

        imageView = new ImageView();
        label = new Label();
        cno2_label = new Label();
        cvv_label = new Label();
        date_label = new Label();
        namewallet_textfield = new TextField();
        cno2_textfield = new TextField();
        cvv_textfield = new TextField();
        datewallet_textfield = new TextField();
        add2_button = new Button();
        button = new Button();
        alreadyaddedone_label = new Label();
        walletregister_title = new Label();
        Buttongoback_home = new Button();
        imageInput = new ImageInput();
        alreadyexist_error = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(885.0);
        setPrefWidth(1303.0);

        imageView.setFitHeight(885.0);
        imageView.setFitWidth(1303.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 5 (4).png").toExternalForm()));

        label.setLayoutX(628.0);
        label.setLayoutY(69.0);
        label.setPrefHeight(64.0);
        label.setPrefWidth(198.0);
        label.setText("Name");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        label.setFont(new Font("Berlin Sans FB", 58.0));

        cno2_label.setLayoutX(628.0);
        cno2_label.setLayoutY(208.0);
        cno2_label.setPrefHeight(29.0);
        cno2_label.setPrefWidth(131.0);
        cno2_label.setText("Cno");
        cno2_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        cno2_label.setFont(new Font("Berlin Sans FB", 58.0));

        cvv_label.setLayoutX(628.0);
        cvv_label.setLayoutY(351.0);
        cvv_label.setText("Cvv");
        cvv_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        cvv_label.setFont(new Font("Berlin Sans FB", 58.0));

        date_label.setLayoutX(628.0);
        date_label.setLayoutY(480.0);
        date_label.setText("Date");
        date_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        date_label.setFont(new Font("Berlin Sans FB", 58.0));

        namewallet_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        namewallet_textfield.setLayoutX(831.0);
        namewallet_textfield.setLayoutY(79.0);
        namewallet_textfield.setPrefHeight(31.0);
        namewallet_textfield.setPrefWidth(411.0);
        namewallet_textfield.setPromptText("Enter Your Name ");
        namewallet_textfield.setFont(new Font(20.0));

        cno2_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        cno2_textfield.setLayoutX(831.0);
        cno2_textfield.setLayoutY(218.0);
        cno2_textfield.setPrefHeight(31.0);
        cno2_textfield.setPrefWidth(411.0);
        cno2_textfield.setPromptText("Enter Your Cno");
        cno2_textfield.setFont(new Font(20.0));

        cvv_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        cvv_textfield.setLayoutX(826.0);
        cvv_textfield.setLayoutY(361.0);
        cvv_textfield.setPrefHeight(31.0);
        cvv_textfield.setPrefWidth(421.0);
        cvv_textfield.setPromptText("Enter Your Cvv");
        cvv_textfield.setFont(new Font(20.0));

        datewallet_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        datewallet_textfield.setLayoutX(817.0);
        datewallet_textfield.setLayoutY(490.0);
        datewallet_textfield.setPrefHeight(31.0);
        datewallet_textfield.setPrefWidth(430.0);
        datewallet_textfield.setPromptText("Enter The Date");
        datewallet_textfield.setFont(new Font(20.0));

        add2_button.setLayoutX(922.0);
        add2_button.setLayoutY(614.0);
        add2_button.setMnemonicParsing(false);
        add2_button.setPrefHeight(70.0);
        add2_button.setPrefWidth(231.0);
        add2_button.setText("Add");
        add2_button.setTextFill(javafx.scene.paint.Color.valueOf("#5c1d7c"));
        add2_button.setFont(new Font("Berlin Sans FB Demi Bold", 42.0));

        button.setLayoutX(921.0);
        button.setLayoutY(781.0);
        button.setMnemonicParsing(false);
        button.setText("Recharge");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#5c1d7c"));
        button.setFont(new Font("Berlin Sans FB Demi Bold", 42.0));

        alreadyaddedone_label.setLayoutX(461.0);
        alreadyaddedone_label.setLayoutY(793.0);
        alreadyaddedone_label.setPrefHeight(53.0);
        alreadyaddedone_label.setPrefWidth(453.0);
        alreadyaddedone_label.setText("Already added one ?!");
        alreadyaddedone_label.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        alreadyaddedone_label.setFont(new Font("Berlin Sans FB Bold", 39.0));

        walletregister_title.setLayoutX(14.0);
        walletregister_title.setLayoutY(152.0);
        walletregister_title.setText("Wallet Registration");
        walletregister_title.setTextFill(javafx.scene.paint.Color.valueOf("#d27eff"));
        walletregister_title.setFont(new Font("Berlin Sans FB Demi Bold", 60.0));

        Buttongoback_home.setLayoutX(33.0);
        Buttongoback_home.setLayoutY(24.0);
        Buttongoback_home.setMnemonicParsing(false);
        Buttongoback_home.setPrefHeight(57.0);
        Buttongoback_home.setPrefWidth(58.0);
        Buttongoback_home.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        Buttongoback_home.setEffect(imageInput);
        Buttongoback_home.setCursor(Cursor.HAND);

        alreadyexist_error.setFill(javafx.scene.paint.Color.RED);
        alreadyexist_error.setLayoutX(771.0);
        alreadyexist_error.setLayoutY(588.0);
        alreadyexist_error.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        alreadyexist_error.setStrokeWidth(0.0);
        alreadyexist_error.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        alreadyexist_error.setWrappingWidth(521.458984375);
        alreadyexist_error.setFont(new Font(20.0));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(cno2_label);
        getChildren().add(cvv_label);
        getChildren().add(date_label);
        getChildren().add(namewallet_textfield);
        getChildren().add(cno2_textfield);
        getChildren().add(cvv_textfield);
        getChildren().add(datewallet_textfield);
        getChildren().add(add2_button);
        getChildren().add(button);
        getChildren().add(alreadyaddedone_label);
        getChildren().add(walletregister_title);
        getChildren().add(Buttongoback_home);
        getChildren().add(alreadyexist_error);
    }   
    public Button getAddtowallet(){
        return add2_button;
    }
    public Button getRechagerWallet (){
        return button;
    }
    public Button getHomeWallet(){
     return Buttongoback_home;   
    }
    public String getNameRegistration(){
        return namewallet_textfield.getText();
    }
    public String getCnoRegistration(){
        return cno2_textfield.getText();
    }
    public String getCvvRegistration(){
            return cvv_textfield.getText();
    }
    public String getDateregistration(){
        return datewallet_textfield.getText();
    }
    public void setErrorText(String error ){
        alreadyexist_error.setText(error);
    }
}
