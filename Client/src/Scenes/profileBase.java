package Scenes;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class profileBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button homeButtonProfile;
    protected final ImageInput imageInput;
    protected final Label firstname_label;
    protected final Label lastname_label;
    protected final Label username_label;
    protected final Label email_label;
    protected final Button changeprof_buttom;
    protected final Label changepass_label_profile;
    protected final Label profile_title;
    protected final Text profile_firstname_txet;
    protected final Text profile_lastname_txet;
    protected final Text profile_username_txet;
    protected final Text profile_email_txet;

    public profileBase() {

        imageView = new ImageView();
        homeButtonProfile = new Button();
        imageInput = new ImageInput();
        firstname_label = new Label();
        lastname_label = new Label();
        username_label = new Label();
        email_label = new Label();
        changeprof_buttom = new Button();
        changepass_label_profile = new Label();
        profile_title = new Label();
        profile_firstname_txet = new Text();
        profile_lastname_txet = new Text();
        profile_username_txet = new Text();
        profile_email_txet = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(875.0);
        setPrefWidth(1319.0);

        imageView.setFitHeight(875.0);
        imageView.setFitWidth(1319.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        homeButtonProfile.setLayoutX(23.0);
        homeButtonProfile.setLayoutY(23.0);
        homeButtonProfile.setMnemonicParsing(false);
        homeButtonProfile.setText("Button");
        homeButtonProfile.setOpaqueInsets(new Insets(0.0));
        homeButtonProfile.setCursor(Cursor.HAND);
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        homeButtonProfile.setEffect(imageInput);

        firstname_label.setLayoutX(494.0);
        firstname_label.setLayoutY(63.0);
        firstname_label.setText("First Name");
        firstname_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        firstname_label.setFont(new Font("Berlin Sans FB", 50.0));

        lastname_label.setLayoutX(495.0);
        lastname_label.setLayoutY(169.0);
        lastname_label.setText("Last Name");
        lastname_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        lastname_label.setFont(new Font("Berlin Sans FB", 50.0));

        username_label.setLayoutX(493.0);
        username_label.setLayoutY(288.0);
        username_label.setText("User Name");
        username_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        username_label.setFont(new Font("Berlin Sans FB", 50.0));

        email_label.setAlignment(javafx.geometry.Pos.CENTER);
        email_label.setLayoutX(493.0);
        email_label.setLayoutY(405.0);
        email_label.setText("Email");
        email_label.setTextFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        email_label.setFont(new Font("Berlin Sans FB", 50.0));

        changeprof_buttom.setLayoutX(868.0);
        changeprof_buttom.setLayoutY(742.0);
        changeprof_buttom.setMnemonicParsing(false);
        changeprof_buttom.setPrefHeight(77.0);
        changeprof_buttom.setPrefWidth(173.0);
        changeprof_buttom.setText("Change");
        changeprof_buttom.setTextFill(javafx.scene.paint.Color.valueOf("#733197"));
        changeprof_buttom.setFont(new Font("Berlin Sans FB Demi Bold", 35.0));

        changepass_label_profile.setLayoutX(735.0);
        changepass_label_profile.setLayoutY(654.0);
        changepass_label_profile.setPrefHeight(66.0);
        changepass_label_profile.setPrefWidth(460.0);
        changepass_label_profile.setText("Change Password ?!");
        changepass_label_profile.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        changepass_label_profile.setFont(new Font("Berlin Sans FB Bold", 47.0));
        changepass_label_profile.setCursor(Cursor.HAND);

        profile_title.setLayoutX(55.0);
        profile_title.setLayoutY(159.0);
        profile_title.setText("Profile");
        profile_title.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        profile_title.setFont(new Font("Berlin Sans FB Demi Bold", 96.0));

        profile_firstname_txet.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        profile_firstname_txet.setLayoutX(767.0);
        profile_firstname_txet.setLayoutY(104.0);
        profile_firstname_txet.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        profile_firstname_txet.setStrokeWidth(0.0);
        profile_firstname_txet.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        profile_firstname_txet.setWrappingWidth(375.6708984375);
        profile_firstname_txet.setFont(new Font("Arial Bold", 40.0));

        profile_lastname_txet.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        profile_lastname_txet.setLayoutX(767.0);
        profile_lastname_txet.setLayoutY(210.0);
        profile_lastname_txet.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        profile_lastname_txet.setStrokeWidth(0.0);
        profile_lastname_txet.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        profile_lastname_txet.setWrappingWidth(375.6708984375);
        profile_lastname_txet.setFont(new Font("Arial Bold", 40.0));

        profile_username_txet.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        profile_username_txet.setLayoutX(767.0);
        profile_username_txet.setLayoutY(329.0);
        profile_username_txet.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        profile_username_txet.setStrokeWidth(0.0);
        profile_username_txet.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        profile_username_txet.setWrappingWidth(375.6708984375);
        profile_username_txet.setFont(new Font("Arial Bold", 40.0));

        profile_email_txet.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        profile_email_txet.setLayoutX(767.0);
        profile_email_txet.setLayoutY(446.0);
        profile_email_txet.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        profile_email_txet.setStrokeWidth(0.0);
        profile_email_txet.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        profile_email_txet.setWrappingWidth(375.6708984375);
        profile_email_txet.setFont(new Font("Arial Bold", 40.0));

        getChildren().add(imageView);
        getChildren().add(homeButtonProfile);
        getChildren().add(firstname_label);
        getChildren().add(lastname_label);
        getChildren().add(username_label);
        getChildren().add(email_label);
        getChildren().add(changeprof_buttom);
        getChildren().add(changepass_label_profile);
        getChildren().add(profile_title);
        getChildren().add(profile_firstname_txet);
        getChildren().add(profile_lastname_txet);
        getChildren().add(profile_username_txet);
        getChildren().add(profile_email_txet);
    }

    public void setFirstName(String firstName) {
        profile_firstname_txet.setText(firstName);
    }

    public void setLastName(String lastName) {
        profile_lastname_txet.setText(lastName);
    }

    public void setUserName(String userName) {
        profile_username_txet.setText(userName);
    }

    public void setEmail(String email) {
        profile_email_txet.setText(email);
    }


    public Button getchangepassBtn() {
        return changeprof_buttom;
    }
    public Button gethomeBtn() {
        return homeButtonProfile;
    }
   
}