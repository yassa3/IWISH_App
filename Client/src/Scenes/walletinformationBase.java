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

public  class walletinformationBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label cno_label;
    protected final TextField cno_textfield;
    protected final Label amount_label;
    protected final TextField amount_textfield;
    protected final Button recharge_buttonWI;
    protected final Label addcredit_label;
    protected final Button Buttongoback_walletinfo;
    protected final ImageInput imageInput;
    protected final Label walletinfo_title;
    protected final Button add_button1WI;
    protected final Text notenough_err;

    public walletinformationBase() {

        imageView = new ImageView();
        cno_label = new Label();
        cno_textfield = new TextField();
        amount_label = new Label();
        amount_textfield = new TextField();
        recharge_buttonWI = new Button();
        addcredit_label = new Label();
        Buttongoback_walletinfo = new Button();
        imageInput = new ImageInput();
        walletinfo_title = new Label();
        add_button1WI = new Button();
        notenough_err = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(860.0);
        setPrefWidth(1311.0);

        imageView.setFitHeight(860.0);
        imageView.setFitWidth(1311.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 5 (4).png").toExternalForm()));

        cno_label.setAlignment(javafx.geometry.Pos.CENTER);
        cno_label.setLayoutX(552.0);
        cno_label.setLayoutY(136.0);
        cno_label.setPrefHeight(64.0);
        cno_label.setPrefWidth(207.0);
        cno_label.setText("Cno");
        cno_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        cno_label.setFont(new Font("Berlin Sans FB", 58.0));

        cno_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        cno_textfield.setLayoutX(796.0);
        cno_textfield.setLayoutY(141.0);
        cno_textfield.setPrefHeight(53.0);
        cno_textfield.setPrefWidth(481.0);
        cno_textfield.setPromptText("Enter your Cno");
        cno_textfield.setFont(new Font(25.0));

        amount_label.setAlignment(javafx.geometry.Pos.CENTER);
        amount_label.setLayoutX(552.0);
        amount_label.setLayoutY(309.0);
        amount_label.setPrefHeight(40.0);
        amount_label.setPrefWidth(207.0);
        amount_label.setText("Amount");
        amount_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        amount_label.setFont(new Font("Berlin Sans FB", 58.0));

        amount_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        amount_textfield.setLayoutX(792.0);
        amount_textfield.setLayoutY(314.0);
        amount_textfield.setPrefHeight(53.0);
        amount_textfield.setPrefWidth(490.0);
        amount_textfield.setPromptText("Enter the Amount ");
        amount_textfield.setFont(new Font(25.0));

        recharge_buttonWI.setLayoutX(933.0);
        recharge_buttonWI.setLayoutY(465.0);
        recharge_buttonWI.setMnemonicParsing(false);
        recharge_buttonWI.setPrefHeight(76.0);
        recharge_buttonWI.setPrefWidth(207.0);
        recharge_buttonWI.setText("Recharge");
        recharge_buttonWI.setTextFill(javafx.scene.paint.Color.valueOf("#5c1d7c"));
        recharge_buttonWI.setFont(new Font("Berlin Sans FB Demi Bold", 35.0));

        addcredit_label.setLayoutX(552.0);
        addcredit_label.setLayoutY(714.0);
        addcredit_label.setPrefHeight(66.0);
        addcredit_label.setPrefWidth(320.0);
        addcredit_label.setText("Add Credit ?!");
        addcredit_label.setTextFill(javafx.scene.paint.Color.valueOf("#d485ff"));
        addcredit_label.setFont(new Font("Berlin Sans FB Bold", 49.0));
        addcredit_label.setCursor(Cursor.HAND);

        Buttongoback_walletinfo.setLayoutX(60.0);
        Buttongoback_walletinfo.setLayoutY(30.0);
        Buttongoback_walletinfo.setMnemonicParsing(false);
        Buttongoback_walletinfo.setPrefHeight(57.0);
        Buttongoback_walletinfo.setPrefWidth(58.0);
        Buttongoback_walletinfo.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        Buttongoback_walletinfo.setEffect(imageInput);
        Buttongoback_walletinfo.setCursor(Cursor.HAND);

        walletinfo_title.setLayoutX(47.0);
        walletinfo_title.setLayoutY(156.0);
        walletinfo_title.setPrefHeight(65.0);
        walletinfo_title.setPrefWidth(490.0);
        walletinfo_title.setText("Wallet Information");
        walletinfo_title.setTextFill(javafx.scene.paint.Color.valueOf("#d68aff"));
        walletinfo_title.setFont(new Font("Berlin Sans FB Demi Bold", 56.0));

        add_button1WI.setLayoutX(934.0);
        add_button1WI.setLayoutY(709.0);
        add_button1WI.setMnemonicParsing(false);
        add_button1WI.setPrefHeight(76.0);
        add_button1WI.setPrefWidth(207.0);
        add_button1WI.setText("Add");
        add_button1WI.setTextFill(javafx.scene.paint.Color.valueOf("#5c1d7c"));
        add_button1WI.setFont(new Font("Berlin Sans FB Demi Bold", 35.0));

        notenough_err.setFill(javafx.scene.paint.Color.RED);
        notenough_err.setLayoutX(759.0);
        notenough_err.setLayoutY(438.0);
        notenough_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        notenough_err.setStrokeWidth(0.0);
        notenough_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        notenough_err.setWrappingWidth(521.458984375);
        notenough_err.setFont(new Font(20.0));

        getChildren().add(imageView);
        getChildren().add(cno_label);
        getChildren().add(cno_textfield);
        getChildren().add(amount_label);
        getChildren().add(amount_textfield);
        getChildren().add(recharge_buttonWI);
        getChildren().add(addcredit_label);
        getChildren().add(Buttongoback_walletinfo);
        getChildren().add(walletinfo_title);
        getChildren().add(add_button1WI);
        getChildren().add(notenough_err);

    }
    public Button getHomebtn(){
        return Buttongoback_walletinfo;
    }
    public Button getAddInfo(){
        return add_button1WI;
    }
    public Button getRechargebtn(){
        return recharge_buttonWI;
    }
    public String getCnoInfo(){
        return cno_textfield.getText();
    }
    public String getAmountInfo(){
        return amount_textfield.getText();
    }
    public void setErrorInfo(String error ){
        notenough_err.setText(error);
        }
}
