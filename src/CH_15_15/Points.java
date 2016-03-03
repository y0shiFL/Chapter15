package CH_15_15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by yoshi on 3/1/2016.
 */
public class Points extends Application {

    private Pane pane = new Pane();
    /*private Circle c = new Circle(10);*/

    public void start(Stage primaryStage) {



        pane.setOnMouseClicked(e ->
        {

            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(5);
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
                circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                pane.getChildren().add(circle);

                circle.setOnMouseClicked(eC -> {
                    if( eC.getButton() == MouseButton.SECONDARY) {
                        pane.getChildren().remove(circle);
                    }
                });
            }
        });

        //pane.setOnMouseClicked(new PaneClickHandler());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("MouseEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

/*
    class PaneClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(5);
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
                circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                pane.getChildren().add(circle);
                circle.setOnMouseClicked(new CircleClickHandler());

            }
        }
    }

    class CircleClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            // Remove Circle if right clicked
            if (e.getButton() == MouseButton.SECONDARY) {
                pane.getChildren().remove(e.getSource());

            }
        }

    }
*/

    public static void main(String[] args) {
        launch(args);
    }
}



