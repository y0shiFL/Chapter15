package CH_15_3;/**
 * Created by yoshi on 2/28/2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Ball extends Application {

    private Pane pane = new Pane();
    private Circle circle = new Circle();
    HBox hBox2 = new HBox();
    ImageView yoshiImage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        circle.setRadius(80);
        circle.setCenterX(250);
        circle.setCenterY(250);

        String imageFileName = "CH_15_3/image/a-day-with-black-yoshi.png";
        Image img = new Image(imageFileName);
        yoshiImage = new ImageView(img);

        //hBox2.getChildren().add(new ImageView(yoshiImage.get(0)));
        //hBox2.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(yoshiImage);

        HBox hbox = new HBox();
        Button bt1 = new Button("Left");

        bt1.setOnAction(e->{
            moveLeft();
        });
        Button bt2 = new Button("Right");

        bt2.setOnAction(e->{
            moveRight();
        });
        Button bt3 = new Button("Up");

        bt3.setOnAction(e->{
            moveUp();
        });
        Button bt4 = new Button("Down");

        bt4.setOnAction(e->{
            moveDown();
        });
        hbox.getChildren().addAll(bt1,bt2,bt3,bt4);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(15);
        hbox.setPadding(new Insets(15,15,15,15));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hbox);
        //borderPane.setTop(hBox2);

        Scene scene = new Scene(borderPane,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Left,Right,Up,or Down");
        primaryStage.show();
    }
    public void moveLeft()
    {
        int minCenterX = -(int)circle.getRadius() + 5;
        int newLeft = (int)circle.getCenterX()-15;
        if( newLeft < minCenterX )
            newLeft = minCenterX;
        circle.setCenterX(newLeft);
    }
    public void moveRight()
    {
        //yoshiImage.setX();
        int maxCenterX = (int)pane.getWidth()+(int)circle.getRadius() - 5;
        int newRight = (int)circle.getCenterX()+15;
        if( newRight > maxCenterX )
            newRight = maxCenterX;
            circle.setCenterX(newRight);
    }

    public void moveUp()
    {
        int minCenterY = -(int)circle.getRadius() +5;
        int newUp = (int)circle.getCenterY()-15;
        if(newUp < minCenterY)
            newUp = minCenterY;
        circle.setCenterY(newUp);
    }

    public void moveDown()
    {
        int maxCenterY = (int)pane.getWidth() + (int)circle.getRadius()- 5;
        int newDown = (int)circle.getCenterY()+15;
        if(newDown > maxCenterY)
            newDown = maxCenterY;
        circle.setCenterY(newDown);
    }

 /*   *//*public void moveImgLeft()
    {
        int minCenterX = -(int)hBox2.get;
        int newImgLeft = (int)hBox2.getWidth() + 15;
        if(newImgLeft < minCenterX)
        {
            newImgLeft = minCenterX;
            hBox2.setMinWidth(newImgLeft);
        }
    }*/
}
