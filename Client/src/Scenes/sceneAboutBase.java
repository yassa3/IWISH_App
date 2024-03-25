package Scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class sceneAboutBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final Button Buttongoback_about;
    protected final ImageInput imageInput;
    protected final Text meetusTxt;
    protected final Text aboutTxt;
    protected final Text needHelptxt;
    protected final Text wishMailTxt;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;

    public sceneAboutBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        Buttongoback_about = new Button();
        imageInput = new ImageInput();
        meetusTxt = new Text();
        aboutTxt = new Text();
        needHelptxt = new Text();
        wishMailTxt = new Text();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        imageView4 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(599.0);
        setPrefWidth(801.0);

        imageView.setFitHeight(599.0);
        imageView.setFitWidth(801.0);
        imageView.setImage(new Image(getClass().getResource("Images/Desktop - 2.png").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#c9c9c929"));
        rectangle.setHeight(523.0);
        rectangle.setLayoutX(100.0);
        rectangle.setLayoutY(19.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#757575"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(676.0);

        Buttongoback_about.setLayoutX(14.0);
        Buttongoback_about.setLayoutY(14.0);
        Buttongoback_about.setMnemonicParsing(false);
        Buttongoback_about.setPrefHeight(57.0);
        Buttongoback_about.setPrefWidth(58.0);
        Buttongoback_about.setText("Button");
        imageInput.setSource(new Image(getClass().getResource("Images/icons8-home-50.png").toExternalForm()));
        Buttongoback_about.setEffect(imageInput);
        Buttongoback_about.setCursor(Cursor.HAND);

        meetusTxt.setFill(javafx.scene.paint.Color.WHITE);
        meetusTxt.setLayoutX(121.0);
        meetusTxt.setLayoutY(172.0);
        meetusTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        meetusTxt.setStrokeWidth(0.0);
        meetusTxt.setText("Meet us");
        meetusTxt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        meetusTxt.setUnderline(true);
        meetusTxt.setWrappingWidth(190.6875);
        meetusTxt.setFont(new Font("Arial", 40.0));

        aboutTxt.setFill(javafx.scene.paint.Color.valueOf("#dfaff8"));
        aboutTxt.setLayoutX(353.0);
        aboutTxt.setLayoutY(88.0);
        aboutTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        aboutTxt.setStrokeWidth(0.0);
        aboutTxt.setText("About");
        aboutTxt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        aboutTxt.setWrappingWidth(170.68359375);
        aboutTxt.setFont(new Font("Berlin Sans FB Demi Bold", 60.0));

        needHelptxt.setFill(javafx.scene.paint.Color.WHITE);
        needHelptxt.setLayoutX(130.0);
        needHelptxt.setLayoutY(383.0);
        needHelptxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        needHelptxt.setStrokeWidth(0.0);
        needHelptxt.setText("Need Help?");
        needHelptxt.setFont(new Font(40.0));

        wishMailTxt.setFill(javafx.scene.paint.Color.WHITE);
        wishMailTxt.setLayoutX(197.0);
        wishMailTxt.setLayoutY(440.0);
        wishMailTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        wishMailTxt.setStrokeWidth(0.0);
        wishMailTxt.setText("Iwish@gamil.com");
        wishMailTxt.setFont(new Font(27.0));
        wishMailTxt.setCursor(Cursor.HAND);

        imageView0.setLayoutX(130.0);
        imageView0.setLayoutY(404.0);
        imageView0.setImage(new Image(getClass().getResource("Images/WhatsApp Image 2024-01-04 at 19.12.12_cf590120.jpg").toExternalForm()));

        imageView1.setFitHeight(151.0);
        imageView1.setFitWidth(159.0);
        imageView1.setLayoutX(118.0);
        imageView1.setLayoutY(201.0);
        imageView1.setImage(new Image(getClass().getResource("Images/2.png").toExternalForm()));

        imageView2.setFitHeight(159.0);
        imageView2.setFitWidth(152.0);
        imageView2.setLayoutX(277.0);
        imageView2.setLayoutY(201.0);
        imageView2.setImage(new Image(getClass().getResource("Images/3.png").toExternalForm()));

        imageView3.setFitHeight(159.0);
        imageView3.setFitWidth(159.0);
        imageView3.setLayoutX(429.0);
        imageView3.setLayoutY(201.0);
        imageView3.setImage(new Image(getClass().getResource("Images/4.png").toExternalForm()));

        imageView4.setFitHeight(151.0);
        imageView4.setFitWidth(152.0);
        imageView4.setLayoutX(588.0);
        imageView4.setLayoutY(205.0);
        imageView4.setImage(new Image(getClass().getResource("Images/1.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(Buttongoback_about);
        getChildren().add(meetusTxt);
        getChildren().add(aboutTxt);
        getChildren().add(needHelptxt);
        getChildren().add(wishMailTxt);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(imageView4);

    }
    public Button gethomeBtn()  {
        return Buttongoback_about ;
    }
}
