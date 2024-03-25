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

public class loginBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Rectangle rectangle;
    protected final Label UserName_Login;
    protected final Label Password_Login;
    protected final TextField EnterYourNAME_login;
    protected final PasswordField EnterYourPassword_login;
    protected final Text errorTextField;
    protected final Button LOGIN_loginB;
    protected final Label DoNotHaveAccountLogin;
    protected final Button Register_loginB;
    protected final Button forgetpassword_loginB;
    protected final Label IWishlogin;
    protected final Label WISHWHATYOUWANTlogin;
    protected final Label IWishlogin1;
    protected final ImageView imageView2;

    public loginBase() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        rectangle = new Rectangle();
        UserName_Login = new Label();
        Password_Login = new Label();
        EnterYourNAME_login = new TextField();
        EnterYourPassword_login = new PasswordField();
        errorTextField = new Text();
        LOGIN_loginB = new Button();
        DoNotHaveAccountLogin = new Label();
        Register_loginB = new Button();
        forgetpassword_loginB = new Button();
        IWishlogin = new Label();
        WISHWHATYOUWANTlogin = new Label();
        IWishlogin1 = new Label();
        imageView2 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(896.0);
        setPrefWidth(924.0);

        imageView.setFitHeight(896.0);
        imageView.setFitWidth(924.0);
        imageView.setImage(new Image(getClass().getResource("Images/Frame 3 (1).png").toExternalForm()));

        imageView0.setFitHeight(573.0);
        imageView0.setFitWidth(527.0);
        imageView0.setLayoutX(379.0);
        imageView0.setLayoutY(14.0);
        imageView0.setImage(new Image(getClass().getResource("Images/257044_0f5a0.gif").toExternalForm()));

        imageView1.setFitHeight(573.0);
        imageView1.setFitWidth(527.0);
        imageView1.setLayoutX(378.0);
        imageView1.setLayoutY(17.0);
        imageView1.setImage(new Image(getClass().getResource("Images/200w.gif").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#b5b5b5"));
        rectangle.setHeight(573.0);
        rectangle.setLayoutX(379.0);
        rectangle.setLayoutY(17.0);
        rectangle.setOpacity(0.3);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#797979"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(527.0);

        UserName_Login.setLayoutX(385.0);
        UserName_Login.setLayoutY(135.0);
        UserName_Login.setPrefHeight(43.0);
        UserName_Login.setPrefWidth(169.0);
        UserName_Login.setText("User Name");
        UserName_Login.setTextFill(javafx.scene.paint.Color.WHITE);
        UserName_Login.setFont(new Font("Arial Bold", 30.0));

        Password_Login.setLayoutX(385.0);
        Password_Login.setLayoutY(211.0);
        Password_Login.setPrefHeight(43.0);
        Password_Login.setPrefWidth(154.0);
        Password_Login.setText("Password");
        Password_Login.setTextFill(javafx.scene.paint.Color.WHITE);
        Password_Login.setFont(new Font("Arial Bold", 30.0));

        EnterYourNAME_login.setLayoutX(560.0);
        EnterYourNAME_login.setLayoutY(141.0);
        EnterYourNAME_login.setPrefHeight(31.0);
        EnterYourNAME_login.setPrefWidth(300.0);
        EnterYourNAME_login.setPromptText("EnterYourNAME");

        EnterYourPassword_login.setLayoutX(562.0);
        EnterYourPassword_login.setLayoutY(217.0);
        EnterYourPassword_login.setPrefHeight(31.0);
        EnterYourPassword_login.setPrefWidth(300.0);
        EnterYourPassword_login.setPromptText("EnterYourPassword");

        errorTextField.setFill(javafx.scene.paint.Color.valueOf("#f50707"));
        errorTextField.setLayoutX(576.0);
        errorTextField.setLayoutY(270.0);
        errorTextField.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        errorTextField.setStrokeWidth(0.0);
        errorTextField.setWrappingWidth(268.13671875);

        LOGIN_loginB.setLayoutX(575.0);
        LOGIN_loginB.setLayoutY(396.0);
        LOGIN_loginB.setMnemonicParsing(false);
        LOGIN_loginB.setPrefHeight(56.0);
        LOGIN_loginB.setPrefWidth(135.0);
        LOGIN_loginB.setText("Login");
        LOGIN_loginB.setTextFill(javafx.scene.paint.Color.valueOf("#af00bb"));
        LOGIN_loginB.setFont(new Font("Arial Bold", 30.0));

        DoNotHaveAccountLogin.setLayoutX(409.0);
        DoNotHaveAccountLogin.setLayoutY(513.0);
        DoNotHaveAccountLogin.setPrefHeight(43.0);
        DoNotHaveAccountLogin.setPrefWidth(280.0);
        DoNotHaveAccountLogin.setText("don't have account");
        DoNotHaveAccountLogin.setTextFill(javafx.scene.paint.Color.WHITE);
        DoNotHaveAccountLogin.setFont(new Font("Arial Bold", 30.0));
        DoNotHaveAccountLogin.setCursor(Cursor.HAND);

        Register_loginB.setLayoutX(702.0);
        Register_loginB.setLayoutY(507.0);
        Register_loginB.setMnemonicParsing(false);
        Register_loginB.setPrefHeight(43.0);
        Register_loginB.setPrefWidth(161.0);
        Register_loginB.setText("Register");
        Register_loginB.setTextFill(javafx.scene.paint.Color.valueOf("#af00bb"));
        Register_loginB.setFont(new Font("Arial Bold", 30.0));

        forgetpassword_loginB.setLayoutX(713.0);
        forgetpassword_loginB.setLayoutY(271.0);
        forgetpassword_loginB.setMnemonicParsing(false);
        forgetpassword_loginB.setPrefHeight(31.0);
        forgetpassword_loginB.setPrefWidth(189.0);
        forgetpassword_loginB.setText("forget your password?");
        forgetpassword_loginB.setTextFill(javafx.scene.paint.Color.valueOf("#af00bb"));
        forgetpassword_loginB.setFont(new Font("Arial Bold", 15.0));

        IWishlogin.setLayoutX(589.0);
        IWishlogin.setLayoutY(57.0);
        IWishlogin.setPrefHeight(46.0);
        IWishlogin.setPrefWidth(135.0);
        IWishlogin.setText("I Wish");
        IWishlogin.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        IWishlogin.setFont(new Font("Berlin Sans FB Demi Bold", 50.0));

        WISHWHATYOUWANTlogin.setLayoutX(13.0);
        WISHWHATYOUWANTlogin.setLayoutY(282.0);
        WISHWHATYOUWANTlogin.setPrefHeight(43.0);
        WISHWHATYOUWANTlogin.setPrefWidth(344.0);
        WISHWHATYOUWANTlogin.setText("WISH WHAT YOU WANT");
        WISHWHATYOUWANTlogin.setTextFill(javafx.scene.paint.Color.WHITE);
        WISHWHATYOUWANTlogin.setFont(new Font("Berlin Sans FB Bold", 27.0));

        IWishlogin1.setAlignment(javafx.geometry.Pos.CENTER);
        IWishlogin1.setLayoutX(36.0);
        IWishlogin1.setLayoutY(49.0);
        IWishlogin1.setPrefHeight(184.0);
        IWishlogin1.setPrefWidth(223.0);
        IWishlogin1.setText("LOGIN");
        IWishlogin1.setTextFill(javafx.scene.paint.Color.valueOf("#d483ff"));
        IWishlogin1.setFont(new Font("Berlin Sans FB Demi Bold", 50.0));

        imageView2.setFitHeight(305.0);
        imageView2.setFitWidth(344.0);
        imageView2.setLayoutX(565.0);
        imageView2.setLayoutY(591.0);
        imageView2.setImage(new Image(getClass().getResource("Images/1546789_cb2c8.gif").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(rectangle);
        getChildren().add(UserName_Login);
        getChildren().add(Password_Login);
        getChildren().add(EnterYourNAME_login);
        getChildren().add(EnterYourPassword_login);
        getChildren().add(errorTextField);
        getChildren().add(LOGIN_loginB);
        getChildren().add(DoNotHaveAccountLogin);
        getChildren().add(Register_loginB);
        getChildren().add(forgetpassword_loginB);
        getChildren().add(IWishlogin);
        getChildren().add(WISHWHATYOUWANTlogin);
        getChildren().add(IWishlogin1);
        getChildren().add(imageView2);

    }
    
    public Button getloginBtn(){
        return LOGIN_loginB;
    }
    public Button getRegisterBtn(){
        return Register_loginB;
    }
    public Button getForgetBtn(){
        return forgetpassword_loginB;
    }
    public String getUserName(){
        return EnterYourNAME_login.getText();
    }
    public String getPassword(){
        return EnterYourPassword_login.getText();
    }
    public void seterror(String err){
        errorTextField.setText(err);
    }
}
