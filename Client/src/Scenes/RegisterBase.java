package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RegisterBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Rectangle rectangle;
    protected final Label UserNameReg;
    protected final Text userNameError;
    protected final Label FNameReg;
    protected final Label passwordReg;
    protected final Label confirmpasswordReg;
    protected final Text confirmPasswdError;
    protected final Label EmailReg;
    protected final Text emailError;
    protected final Label LNameReg;
    protected final TextField TextfieldNAME;
    protected final TextField TextfieldFN;
    protected final TextField TextfieldEMail;
    protected final TextField TextfieldLN;
    protected final PasswordField Textfieldpassword;
    protected final PasswordField Textfieldconfpassword;
    protected final Label YouHaveAccountReg;
    protected final Button LoginReg;
    protected final Label securityquestionReg;
    protected final Label securityAnswerReg;
    protected final TextField TextfieldsecurityAns;
    protected final Button RegisterButton;
    protected final Label UserNameLabel6;
    protected final Text text;
    protected final Label qouteReg;
    protected final Text emailError1;

    public RegisterBase() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        rectangle = new Rectangle();
        UserNameReg = new Label();
        userNameError = new Text();
        FNameReg = new Label();
        passwordReg = new Label();
        confirmpasswordReg = new Label();
        confirmPasswdError = new Text();
        EmailReg = new Label();
        emailError = new Text();
        LNameReg = new Label();
        TextfieldNAME = new TextField();
        TextfieldFN = new TextField();
        TextfieldEMail = new TextField();
        TextfieldLN = new TextField();
        Textfieldpassword = new PasswordField();
        Textfieldconfpassword = new PasswordField();
        YouHaveAccountReg = new Label();
        LoginReg = new Button();
        securityquestionReg = new Label();
        securityAnswerReg = new Label();
        TextfieldsecurityAns = new TextField();
        RegisterButton = new Button();
        UserNameLabel6 = new Label();
        text = new Text();
        qouteReg = new Label();
        emailError1 = new Text();

        setId("AnchorPane");
        setPrefHeight(889.0);
        setPrefWidth(1024.0);

        imageView.setFitHeight(889.0);
        imageView.setFitWidth(1024.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        imageView0.setFitHeight(857.0);
        imageView0.setFitWidth(602.0);
        imageView0.setLayoutX(407.0);
        imageView0.setLayoutY(11.0);
        imageView0.setOpacity(0.5);
        imageView0.setImage(new Image(getClass().getResource("Images/257044_0f5a0.gif").toExternalForm()));

        imageView1.setFitHeight(857.0);
        imageView1.setFitWidth(602.0);
        imageView1.setLayoutX(409.0);
        imageView1.setLayoutY(10.0);
        imageView1.setOpacity(0.5);
        imageView1.setImage(new Image(getClass().getResource("Images/200w.gif").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#b5b5b5"));
        rectangle.setHeight(857.0);
        rectangle.setLayoutX(408.0);
        rectangle.setLayoutY(12.0);
        rectangle.setOpacity(0.3);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(602.0);

        UserNameReg.setAlignment(javafx.geometry.Pos.CENTER);
        UserNameReg.setLayoutX(443.0);
        UserNameReg.setLayoutY(82.0);
        UserNameReg.setPrefHeight(43.0);
        UserNameReg.setPrefWidth(186.0);
        UserNameReg.setText("User Name");
        UserNameReg.setTextFill(javafx.scene.paint.Color.WHITE);
        UserNameReg.setFont(new Font("Arial Bold", 30.0));

        userNameError.setFill(javafx.scene.paint.Color.valueOf("#fc0505"));
        userNameError.setLayoutX(739.0);
        userNameError.setLayoutY(144.0);
        userNameError.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameError.setStrokeWidth(0.0);
        userNameError.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        userNameError.setWrappingWidth(163.0);

        FNameReg.setAlignment(javafx.geometry.Pos.CENTER);
        FNameReg.setLayoutX(435.0);
        FNameReg.setLayoutY(144.0);
        FNameReg.setPrefHeight(43.0);
        FNameReg.setPrefWidth(154.0);
        FNameReg.setText("FName");
        FNameReg.setTextFill(javafx.scene.paint.Color.WHITE);
        FNameReg.setFont(new Font("Arial Bold", 30.0));

        passwordReg.setAlignment(javafx.geometry.Pos.CENTER);
        passwordReg.setLayoutX(435.0);
        passwordReg.setLayoutY(337.0);
        passwordReg.setPrefHeight(43.0);
        passwordReg.setPrefWidth(154.0);
        passwordReg.setText("Password");
        passwordReg.setTextFill(javafx.scene.paint.Color.WHITE);
        passwordReg.setFont(new Font("Arial Bold", 30.0));

        confirmpasswordReg.setAlignment(javafx.geometry.Pos.CENTER);
        confirmpasswordReg.setLayoutX(399.0);
        confirmpasswordReg.setLayoutY(402.0);
        confirmpasswordReg.setPrefHeight(43.0);
        confirmpasswordReg.setPrefWidth(271.0);
        confirmpasswordReg.setText("Confirm password");
        confirmpasswordReg.setTextFill(javafx.scene.paint.Color.WHITE);
        confirmpasswordReg.setFont(new Font("Arial Bold", 25.0));

        confirmPasswdError.setFill(javafx.scene.paint.Color.valueOf("#fc0303"));
        confirmPasswdError.setLayoutX(729.0);
        confirmPasswdError.setLayoutY(461.0);
        confirmPasswdError.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        confirmPasswdError.setStrokeWidth(0.0);
        confirmPasswdError.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        confirmPasswdError.setWrappingWidth(163.0);

        EmailReg.setAlignment(javafx.geometry.Pos.CENTER);
        EmailReg.setLayoutX(427.0);
        EmailReg.setLayoutY(276.0);
        EmailReg.setPrefHeight(43.0);
        EmailReg.setPrefWidth(154.0);
        EmailReg.setText("E-Mail");
        EmailReg.setTextFill(javafx.scene.paint.Color.WHITE);
        EmailReg.setFont(new Font("Arial Bold", 30.0));

        emailError.setFill(javafx.scene.paint.Color.valueOf("#f80505"));
        emailError.setLayoutX(708.0);
        emailError.setLayoutY(335.0);
        emailError.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailError.setStrokeWidth(0.0);
        emailError.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailError.setWrappingWidth(204.13671875);

        LNameReg.setAlignment(javafx.geometry.Pos.CENTER);
        LNameReg.setLayoutX(435.0);
        LNameReg.setLayoutY(209.0);
        LNameReg.setPrefHeight(43.0);
        LNameReg.setPrefWidth(154.0);
        LNameReg.setText("LName");
        LNameReg.setTextFill(javafx.scene.paint.Color.WHITE);
        LNameReg.setFont(new Font("Arial Bold", 30.0));

        TextfieldNAME.setLayoutX(670.0);
        TextfieldNAME.setLayoutY(88.0);
        TextfieldNAME.setPrefHeight(31.0);
        TextfieldNAME.setPrefWidth(300.0);
        TextfieldNAME.setPromptText("EnterYourNAME");

        TextfieldFN.setLayoutX(670.0);
        TextfieldFN.setLayoutY(150.0);
        TextfieldFN.setPrefHeight(31.0);
        TextfieldFN.setPrefWidth(300.0);
        TextfieldFN.setPromptText("EnterYourFirstNAME");

        TextfieldEMail.setLayoutX(670.0);
        TextfieldEMail.setLayoutY(282.0);
        TextfieldEMail.setPrefHeight(31.0);
        TextfieldEMail.setPrefWidth(300.0);
        TextfieldEMail.setPromptText("EnterYourE-Mail");

        TextfieldLN.setLayoutX(670.0);
        TextfieldLN.setLayoutY(215.0);
        TextfieldLN.setPrefHeight(31.0);
        TextfieldLN.setPrefWidth(300.0);
        TextfieldLN.setPromptText("EnterYourLastNAME");

        Textfieldpassword.setLayoutX(670.0);
        Textfieldpassword.setLayoutY(343.0);
        Textfieldpassword.setPrefHeight(31.0);
        Textfieldpassword.setPrefWidth(300.0);
        Textfieldpassword.setPromptText("EnterYourPassword");

        Textfieldconfpassword.setLayoutX(670.0);
        Textfieldconfpassword.setLayoutY(408.0);
        Textfieldconfpassword.setPrefHeight(31.0);
        Textfieldconfpassword.setPrefWidth(300.0);
        Textfieldconfpassword.setPromptText("confirmYourPassword");

        YouHaveAccountReg.setLayoutX(429.0);
        YouHaveAccountReg.setLayoutY(707.0);
        YouHaveAccountReg.setPrefHeight(43.0);
        YouHaveAccountReg.setPrefWidth(336.0);
        YouHaveAccountReg.setText("Already have account?");
        YouHaveAccountReg.setTextFill(javafx.scene.paint.Color.WHITE);
        YouHaveAccountReg.setFont(new Font("Arial Bold", 30.0));
        YouHaveAccountReg.setCursor(Cursor.HAND);

        LoginReg.setLayoutX(776.0);
        LoginReg.setLayoutY(701.0);
        LoginReg.setMnemonicParsing(false);
        LoginReg.setPrefHeight(43.0);
        LoginReg.setPrefWidth(154.0);
        LoginReg.setText("Login");
        LoginReg.setTextFill(javafx.scene.paint.Color.valueOf("#af00bb"));
        LoginReg.setFont(new Font("Arial Bold", 30.0));

        securityquestionReg.setAlignment(javafx.geometry.Pos.CENTER);
        securityquestionReg.setLayoutX(420.0);
        securityquestionReg.setLayoutY(515.0);
        securityquestionReg.setPrefHeight(43.0);
        securityquestionReg.setPrefWidth(254.0);
        securityquestionReg.setText("security question");
        securityquestionReg.setTextFill(javafx.scene.paint.Color.WHITE);
        securityquestionReg.setFont(new Font("Arial Bold", 30.0));

        securityAnswerReg.setAlignment(javafx.geometry.Pos.CENTER);
        securityAnswerReg.setLayoutX(413.0);
        securityAnswerReg.setLayoutY(568.0);
        securityAnswerReg.setPrefHeight(43.0);
        securityAnswerReg.setPrefWidth(263.0);
        securityAnswerReg.setText("security Answer");
        securityAnswerReg.setTextFill(javafx.scene.paint.Color.WHITE);
        securityAnswerReg.setFont(new Font("Arial Bold", 30.0));

        TextfieldsecurityAns.setLayoutX(677.0);
        TextfieldsecurityAns.setLayoutY(574.0);
        TextfieldsecurityAns.setPrefHeight(31.0);
        TextfieldsecurityAns.setPrefWidth(300.0);
        TextfieldsecurityAns.setPromptText("EnterYouranswer");

        RegisterButton.setLayoutX(611.0);
        RegisterButton.setLayoutY(787.0);
        RegisterButton.setMnemonicParsing(false);
        RegisterButton.setPrefHeight(43.0);
        RegisterButton.setPrefWidth(163.0);
        RegisterButton.setText("Register");
        RegisterButton.setTextFill(javafx.scene.paint.Color.valueOf("#af00bb"));
        RegisterButton.setFont(new Font("Arial Bold", 30.0));

        UserNameLabel6.setAlignment(javafx.geometry.Pos.CENTER);
        UserNameLabel6.setLayoutX(40.0);
        UserNameLabel6.setLayoutY(82.0);
        UserNameLabel6.setPrefHeight(112.0);
        UserNameLabel6.setPrefWidth(321.0);
        UserNameLabel6.setText("Registeration");
        UserNameLabel6.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        UserNameLabel6.setFont(new Font("Berlin Sans FB Demi Bold", 50.0));

        text.setFill(javafx.scene.paint.Color.valueOf("#370879"));
        text.setLayoutX(689.0);
        text.setLayoutY(543.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("what is your favourite Sport?");
        text.setWrappingWidth(321.0);
        text.setFont(new Font("Arial Bold Italic", 20.0));

        qouteReg.setAlignment(javafx.geometry.Pos.CENTER);
        qouteReg.setLayoutX(25.0);
        qouteReg.setLayoutY(307.0);
        qouteReg.setPrefHeight(73.0);
        qouteReg.setPrefWidth(329.0);
        qouteReg.setText("Being best is my biggest wish");
        qouteReg.setTextFill(javafx.scene.paint.Color.WHITE);
        qouteReg.setFont(new Font("Arial Bold Italic", 20.0));

        emailError1.setFill(javafx.scene.paint.Color.valueOf("#f80505"));
        emailError1.setLayoutX(554.0);
        emailError1.setLayoutY(657.0);
        emailError1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailError1.setStrokeWidth(0.0);
        emailError1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailError1.setWrappingWidth(312.0);
        Font existingFont = emailError1.getFont();
        double newSize = 20.0; 
        Font newFont = new Font(existingFont.getName(), newSize);
        emailError1.setFont(newFont);

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(rectangle);
        getChildren().add(UserNameReg);
        getChildren().add(userNameError);
        getChildren().add(FNameReg);
        getChildren().add(passwordReg);
        getChildren().add(confirmpasswordReg);
        getChildren().add(confirmPasswdError);
        getChildren().add(EmailReg);
        getChildren().add(emailError);
        getChildren().add(LNameReg);
        getChildren().add(TextfieldNAME);
        getChildren().add(TextfieldFN);
        getChildren().add(TextfieldEMail);
        getChildren().add(TextfieldLN);
        getChildren().add(Textfieldpassword);
        getChildren().add(Textfieldconfpassword);
        getChildren().add(YouHaveAccountReg);
        getChildren().add(LoginReg);
        getChildren().add(securityquestionReg);
        getChildren().add(securityAnswerReg);
        getChildren().add(TextfieldsecurityAns);
        getChildren().add(RegisterButton);
        getChildren().add(UserNameLabel6);
        getChildren().add(text);
        getChildren().add(qouteReg);
        getChildren().add(emailError1);

    }
    
    public String getUserName (){
       return TextfieldNAME.getText();
    }
    public String getFirstName (){
        return TextfieldFN.getText();
    }
    public String getLastName (){
        return TextfieldLN.getText();
    }
    public String getEmail(){
        return TextfieldEMail.getText();
    }
    public String getPassword(){
            return Textfieldpassword.getText();
    }
    public String getConfirmPassword(){
        return Textfieldconfpassword.getText();
    }
    public String getSecurityAns(){
        return TextfieldsecurityAns.getText();
    }
    public Button getRegisterButton(){
        return RegisterButton;
    }
    public Button getLoginButton (){
        return LoginReg;
    }
    public void setusererr(String err){
        userNameError.setText(err);
    }
    public void setemailerr(String err){
        emailError.setText(err);
    }
    public void setpasserr(String err){
        confirmPasswdError.setText(err);
    }
    public void setcomerr(String err){
        emailError1.setText(err);
    }
}
