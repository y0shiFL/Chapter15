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

        String imageFileName = "CH_15_3/image/a-day-with-black-yoshi.png";
        Image img = new Image(imageFileName);
        yoshiImage = new ImageView(img);
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


        yoshiImage.setX(pane.getWidth()/2 - yoshiImage.getImage().getWidth()/2);
        yoshiImage.setY(pane.getWidth()/2 - yoshiImage.getImage().getWidth()/2);

    }
    public void moveLeft()
    {
        double minX = -yoshiImage.getImage().getWidth() + 5;
        double newX = yoshiImage.getX() - 50;
        yoshiImage.setX( Math.max(newX, minX) );
    }
    public void moveRight()
    {
        double maxX = pane.getWidth () - 5;
        double newX = yoshiImage.getX() + 50;
        yoshiImage.setX( Math.min(newX, maxX) );
    }

    public void moveUp()
    {

        double minY = -yoshiImage.getImage().getHeight() + 5;
        double newY = yoshiImage.getY() - 50;
        yoshiImage.setY( Math.max(newY, minY) );
    }

    public void moveDown()
    {
        double maxY = pane.getWidth () - 5;
        double newY = yoshiImage.getY() + 50;
        yoshiImage.setY( Math.min(newY, maxY) );
    }


}
