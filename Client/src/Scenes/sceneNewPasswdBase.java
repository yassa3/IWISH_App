package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class sceneNewPasswdBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final Text newPasswdField;
    protected final PasswordField newPassdField;
    protected final Text confirmPasswdTxt;
    protected final PasswordField confrimPasswdField;
    protected final Button saveNewPasswdButt;
    protected final Text text;
    protected final Button button;
    protected final ImageInput imageInput;
    protected final Text passworddoesnotmatch_err;

    public sceneNewPasswdBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        newPasswdField = new Text();
        newPassdField = new PasswordField();
        confirmPasswdTxt = new Text();
        confrimPasswdField = new PasswordField();
        saveNewPasswdButt = new Button();
        text = new Text();
        button = new Button();
        imageInput = new ImageInput();
        passworddoesnotmatch_err = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(587.0);
        setPrefWidth(729.0);

        imageView.setFitHeight(587.0);
        imageView.setFitWidth(729.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#c7c7c729"));
        rectangle.setHeight(356.0);
        rectangle.setLayoutX(256.0);
        rectangle.setLayoutY(28.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#949393"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(472.0);

        newPasswdField.setFill(javafx.scene.paint.Color.WHITE);
        newPasswdField.setLayoutX(281.0);
        newPasswdField.setLayoutY(159.0);
        newPasswdField.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        newPasswdField.setStrokeWidth(0.0);
        newPasswdField.setText("Enter your new password");
        newPasswdField.setFont(new Font(20.0));

        newPassdField.setLayoutX(548.0);
        newPassdField.setLayoutY(136.0);
        newPassdField.setPrefHeight(25.0);
        newPassdField.setPrefWidth(167.0);

        confirmPasswdTxt.setFill(javafx.scene.paint.Color.valueOf("#f8f6f6"));
        confirmPasswdTxt.setLayoutX(281.0);
        confirmPasswdTxt.setLayoutY(234.0);
        confirmPasswdTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        confirmPasswdTxt.setStrokeWidth(0.0);
        confirmPasswdTxt.setText("Confirm your password ");
        confirmPasswdTxt.setWrappingWidth(283.2128891944885);
        confirmPasswdTxt.setFont(new Font(20.0));

        confrimPasswdField.setLayoutX(548.0);
        confrimPasswdField.setLayoutY(214.0);
        confrimPasswdField.setPrefHeight(25.0);
        confrimPasswdField.setPrefWidth(167.0);

        saveNewPasswdButt.setLayoutX(444.0);
        saveNewPasswdButt.setLayoutY(312.0);
        saveNewPasswdButt.setMnemonicParsing(false);
        saveNewPasswdButt.setText("Save");
        saveNewPasswdButt.setFont(new Font(20.0));

        text.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        text.setLayoutX(14.0);
        text.setLayoutY(201.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Reset password");
        text.setFont(new Font("Berlin Sans FB Demi Bold", 35.0));

        button.setLayoutX(14.0);
        button.setLayoutY(28.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(45.0);
        button.setPrefWidth(58.0);
        button.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-back-50.png").toExternalForm()));
        button.setEffect(imageInput);
        button.setCursor(Cursor.HAND);

        passworddoesnotmatch_err.setFill(javafx.scene.paint.Color.RED);
        passworddoesnotmatch_err.setLayoutX(333.0);
        passworddoesnotmatch_err.setLayoutY(282.0);
        passworddoesnotmatch_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        passworddoesnotmatch_err.setStrokeWidth(0.0);
        passworddoesnotmatch_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        passworddoesnotmatch_err.setWrappingWidth(319.0);

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(newPasswdField);
        getChildren().add(newPassdField);
        getChildren().add(confirmPasswdTxt);
        getChildren().add(confrimPasswdField);
        getChildren().add(saveNewPasswdButt);
        getChildren().add(text);
        getChildren().add(button);
        getChildren().add(passworddoesnotmatch_err);

    }
    
    public Button getSaveBtn(){
        return saveNewPasswdButt;
    }
    public Button getBackBtn(){
        return button;
    }
    public void seterr (String err){
        passworddoesnotmatch_err.setText(err);
    }
    public String getNewpassword (){
        return newPassdField.getText();
    }
    public String getConfPassword(){
        return confrimPasswdField.getText();
    }
}
