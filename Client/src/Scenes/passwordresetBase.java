package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class passwordresetBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button profileback_btn;
    protected final ImageInput imageInput;
    protected final Label oldpass_label;
    protected final Label newpass_label;
    protected final Label confirm_label;
    protected final PasswordField oldpass_textfield;
    protected final PasswordField newpass_textfield;
    protected final PasswordField confirmpass_textfield;
    protected final Button button;
    protected final Label passrest_title;
    protected final Button Buttonhome_passwordreset;
    protected final ImageInput imageInput0;
    protected final Text wrongpass_err;
    protected final Text passmatch_err;

    public passwordresetBase() {

        imageView = new ImageView();
        profileback_btn = new Button();
        imageInput = new ImageInput();
        oldpass_label = new Label();
        newpass_label = new Label();
        confirm_label = new Label();
        oldpass_textfield = new PasswordField();
        newpass_textfield = new PasswordField();
        confirmpass_textfield = new PasswordField();
        button = new Button();
        passrest_title = new Label();
        Buttonhome_passwordreset = new Button();
        imageInput0 = new ImageInput();
        wrongpass_err = new Text();
        passmatch_err = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(904.0);
        setPrefWidth(1283.0);

        imageView.setFitHeight(904.0);
        imageView.setFitWidth(1283.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        profileback_btn.setLayoutX(104.0);
        profileback_btn.setLayoutY(35.0);
        profileback_btn.setMnemonicParsing(false);
        profileback_btn.setPrefHeight(45.0);
        profileback_btn.setPrefWidth(58.0);
        profileback_btn.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-back-50.png").toExternalForm()));
        profileback_btn.setEffect(imageInput);
        profileback_btn.setCursor(Cursor.HAND);

        oldpass_label.setLayoutX(490.0);
        oldpass_label.setLayoutY(112.0);
        oldpass_label.setPrefHeight(67.0);
        oldpass_label.setPrefWidth(366.0);
        oldpass_label.setText("Old Password");
        oldpass_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        oldpass_label.setFont(new Font("Berlin Sans FB", 60.0));

        newpass_label.setLayoutX(490.0);
        newpass_label.setLayoutY(308.0);
        newpass_label.setText("New Password");
        newpass_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        newpass_label.setFont(new Font("Berlin Sans FB", 60.0));

        confirm_label.setAlignment(javafx.geometry.Pos.CENTER);
        confirm_label.setLayoutX(513.0);
        confirm_label.setLayoutY(496.0);
        confirm_label.setPrefHeight(67.0);
        confirm_label.setPrefWidth(333.0);
        confirm_label.setText("Confirm");
        confirm_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        confirm_label.setFont(new Font("Berlin Sans FB", 60.0));

        oldpass_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        oldpass_textfield.setLayoutX(872.0);
        oldpass_textfield.setLayoutY(118.0);
        oldpass_textfield.setPrefHeight(54.0);
        oldpass_textfield.setPrefWidth(384.0);
        oldpass_textfield.setPromptText("Enter Your Old Password");
        oldpass_textfield.setFont(new Font(25.0));

        newpass_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        newpass_textfield.setLayoutX(879.0);
        newpass_textfield.setLayoutY(314.0);
        newpass_textfield.setPrefHeight(54.0);
        newpass_textfield.setPrefWidth(384.0);
        newpass_textfield.setPromptText("Enter Your New Password");
        newpass_textfield.setFont(new Font(25.0));

        confirmpass_textfield.setAlignment(javafx.geometry.Pos.CENTER);
        confirmpass_textfield.setLayoutX(872.0);
        confirmpass_textfield.setLayoutY(503.0);
        confirmpass_textfield.setPrefHeight(54.0);
        confirmpass_textfield.setPrefWidth(384.0);
        confirmpass_textfield.setPromptText("Enter Your Confirmation");
        confirmpass_textfield.setFont(new Font(25.0));

        button.setLayoutX(831.0);
        button.setLayoutY(719.0);
        button.setMnemonicParsing(false);
        button.setText("Done");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#733197"));
        button.setFont(new Font("Berlin Sans FB Demi Bold", 42.0));

        passrest_title.setLayoutX(19.0);
        passrest_title.setLayoutY(129.0);
        passrest_title.setPrefHeight(226.0);
        passrest_title.setPrefWidth(489.0);
        passrest_title.setText("Password Reset ");
        passrest_title.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        passrest_title.setFont(new Font("Berlin Sans FB Demi Bold", 65.0));

        Buttonhome_passwordreset.setLayoutX(28.0);
        Buttonhome_passwordreset.setLayoutY(34.0);
        Buttonhome_passwordreset.setMnemonicParsing(false);
        Buttonhome_passwordreset.setPrefHeight(57.0);
        Buttonhome_passwordreset.setPrefWidth(58.0);
        Buttonhome_passwordreset.setText("Button");
        imageInput0.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        Buttonhome_passwordreset.setEffect(imageInput0);
        Buttonhome_passwordreset.setCursor(Cursor.HAND);

        wrongpass_err.setFill(javafx.scene.paint.Color.RED);
        wrongpass_err.setLayoutX(872.0);
        wrongpass_err.setLayoutY(237.0);
        wrongpass_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        wrongpass_err.setStrokeWidth(0.0);
        wrongpass_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        wrongpass_err.setWrappingWidth(384.00000739097595);
        wrongpass_err.setFont(new Font(20.0));

        passmatch_err.setFill(javafx.scene.paint.Color.RED);
        passmatch_err.setLayoutX(872.0);
        passmatch_err.setLayoutY(614.0);
        passmatch_err.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        passmatch_err.setStrokeWidth(0.0);
        passmatch_err.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        passmatch_err.setWrappingWidth(384.00000739097595);
        passmatch_err.setFont(new Font(20.0));

        getChildren().add(imageView);
        getChildren().add(profileback_btn);
        getChildren().add(oldpass_label);
        getChildren().add(newpass_label);
        getChildren().add(confirm_label);
        getChildren().add(oldpass_textfield);
        getChildren().add(newpass_textfield);
        getChildren().add(confirmpass_textfield);
        getChildren().add(button);
        getChildren().add(passrest_title);
        getChildren().add(Buttonhome_passwordreset);
        getChildren().add(wrongpass_err);
        getChildren().add(passmatch_err);

    }
    public void setOldPassword(String password) {
        oldpass_textfield.setText(password);
    }    

public void setNewPassword(String password) {
        newpass_textfield.setText(password);
    }


    public void setConfirmPassword(String password) {
        confirmpass_textfield.setText(password);
    }
    public String getOldPassword() {
        return oldpass_textfield.getText();
    }    

public String getNewPassword() {
        return newpass_textfield.getText();
    }


    public String getConfirmPassword() {
        return confirmpass_textfield.getText();
    }
     
    public Button getDoneButton() {
        return button;
    }
 public Button getBackButton()  {
        return profileback_btn ;
    }
 public Button gethomeBtn()  {
        return Buttonhome_passwordreset ;
    }
   public void setinvalidpass_error(String err){
        wrongpass_err.setText(err);
    }
   public void setpassmatch_error(String err){
        passmatch_err.setText(err);
    }
}
