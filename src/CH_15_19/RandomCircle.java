package CH_15_19;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;

public class RandomCircle extends Application {
    private CirclePane circlePane = new CirclePane();
    int clickCount = 0;
    double startMilli = System.currentTimeMillis();

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        circlePane.setOnMouseClicked(e -> {
            if( circlePane.hittest(e.getX(), e.getY())) {
                if( ++clickCount <= 2 ) {
                    circlePane.jump();
                }
                else{
                    circlePane.setOnMouseClicked(null);
                    showSummary();
                }
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("RandomCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        circlePane.jump(); // call once after sized so circle fits in window
    }

    public void showSummary() {
        double endMilli = System.currentTimeMillis();
        Text text = new Text(10,20,"Time spent in pane = " + (endMilli-startMilli) );
        text.setFill(Color.BLACK);
        circlePane.getChildren().add( text );
    }

}

class CirclePane extends Pane {
    private Circle circle = new Circle(10);

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        jump();
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() > 2 ?
                circle.getRadius() - 2 : circle.getRadius());
    }

    public void jump() {
        double r = circle.getRadius();
        circle.setCenterX(Math.random() * (getWidth() - 2 * r) + r);
        circle.setCenterY(Math.random() * (getHeight() - 2 * r) + r);
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        circle.setFill(color);
    }

    public boolean hittest(double x, double y){

        return circle.contains(x,y);
    }
}
