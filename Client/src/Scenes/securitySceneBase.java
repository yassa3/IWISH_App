package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class securitySceneBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final TextField emailConfirmationField;
    protected final Text confirmationTxt;
    protected final Text enterEmailTxt;
    protected final Text firstQuesTxt;
    protected final TextField answerFirsQueField;
    protected final Button EnterButton_confirm;
    protected final Button login_back;
    protected final ImageInput imageInput;
    protected final Text emailanswer_err;

    public securitySceneBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        emailConfirmationField = new TextField();
        confirmationTxt = new Text();
        enterEmailTxt = new Text();
        firstQuesTxt = new Text();
        answerFirsQueField = new TextField();
        EnterButton_confirm = new Button();
        login_back = new Button();
        imageInput = new ImageInput();
        emailanswer_err = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(587.0);
        setPrefWidth(743.0);

        imageView.setFitHeight(587.0);
        imageView.setFitWidth(743.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#c7c7c729"));
        rectangle.setHeight(314.0);
        rectangle.setLayoutX(257.0);
        rectangle.setLayoutY(27.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#6b6b6b"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(471.0);

        emailConfirmationField.setLayoutX(503.0);
        emailConfirmationField.setLayoutY(81.0);
        emailConfirmationField.setPrefHeight(25.0);
        emailConfirmationField.setPrefWidth(213.0);

        confirmationTxt.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        confirmationTxt.setLayoutX(14.0);
        confirmationTxt.setLayoutY(176.0);
        confirmationTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        confirmationTxt.setStrokeWidth(0.0);
        confirmationTxt.setText("Confirmation");
        confirmationTxt.setWrappingWidth(240.48046875);
        confirmationTxt.setFont(new Font("Berlin Sans FB Demi Bold", 40.0));

        enterEmailTxt.setFill(javafx.scene.paint.Color.WHITE);
        enterEmailTxt.setLayoutX(278.0);
        enterEmailTxt.setLayoutY(101.0);
        enterEmailTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        enterEmailTxt.setStrokeWidth(0.0);
        enterEmailTxt.setText("Please Enter Your Email");
        enterEmailTxt.setFont(new Font(20.0));

        firstQuesTxt.setFill(javafx.scene.paint.Color.WHITE);
        firstQuesTxt.setLayoutX(278.0);
        firstQuesTxt.setLayoutY(159.0);
        firstQuesTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        firstQuesTxt.setStrokeWidth(0.0);
        firstQuesTxt.setText("What is your favourite sport?");
        firstQuesTxt.setWrappingWidth(318.9999945759773);
        firstQuesTxt.setFont(new Font(20.0));

        answerFirsQueField.setLayoutX(278.0);
        answerFirsQueField.setLayoutY(184.0);
        answerFirsQueField.setPrefHeight(25.0);
        answerFirsQueField.setPrefWidth(429.0);

        EnterButton_confirm.setAlignment(javafx.geometry.Pos.CENTER);
        EnterButton_confirm.setLayoutX(449.0);
        EnterButton_confirm.setLayoutY(272.0);
        EnterButton_confirm.setMnemonicParsing(false);
        EnterButton_confirm.setText("Enter");
        EnterButton_confirm.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        EnterButton_confirm.setFont(new Font(20.0));

        login_back.setLayoutX(14.0);
        login_back.setLayoutY(27.0);
        login_back.setMnemonicParsing(false);
        login_back.setPrefHeight(45.0);
        login_back.setPrefWidth(58.0);
        login_back.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-back-50.png").toExternalForm()));
        login_back.setEffect(imageInput);
        login_back.setCursor(Cursor.HAND);

        emailanswer_err.setFill(javafx.scene.paint.Color.RED);
        emailanswer_err.setLayoutX(289.0);
        emailanswer_err.setLayoutY(254.0);
        emailanswer_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailanswer_err.setStrokeWidth(0.0);
        emailanswer_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailanswer_err.setWrappingWidth(407.48047694563866);

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(emailConfirmationField);
        getChildren().add(confirmationTxt);
        getChildren().add(enterEmailTxt);
        getChildren().add(firstQuesTxt);
        getChildren().add(answerFirsQueField);
        getChildren().add(EnterButton_confirm);
        getChildren().add(login_back);
        getChildren().add(emailanswer_err);

    }
    
    public Button getEnterBtn(){
        return EnterButton_confirm;
    }
    public Button getBackBtn(){
        return login_back;
    }
    public String getemail(){
        return emailConfirmationField.getText();
    }
    public String getsecurityanswer(){
        return answerFirsQueField.getText();
    }
    public void seterr (String err){
        emailanswer_err.setText(err);
    }
}
