package CH_15_28;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * Created by yoshi on 3/2/2016.
 */
public class RunningFanPane extends Pane {
    private int radius;
    private double centerX;
    private double centerY;


    private Color fanColor = Color.WHITE;

    public RunningFanPane()
    {

    }

    public RunningFanPane(int radius,Color fanColor)
    {
        this.radius = radius;
        this.fanColor = fanColor;
        paintFan();
    }
    public RunningFanPane(Color fanColor){
        this.fanColor = fanColor;
    }

    protected void paintFan() {
        Circle c1 = new Circle(radius, Color.WHITE);

        c1.centerXProperty().bind(widthProperty().divide(2));
        c1.centerYProperty().bind(heightProperty().divide(2));
        c1.setStroke(Color.BLACK);

        getChildren().clear();
        getChildren().add(c1);

        for (int a = 30; a < 360; a += 90) {

            Arc arc = new Arc(centerX, centerY, radius, radius, a, 35);
            // Create an arc
            arc.centerXProperty().bind(c1.centerXProperty());
            arc.centerYProperty().bind(c1.centerYProperty());
            arc.radiusXProperty().bind(c1.radiusProperty().subtract((10)));
            arc.radiusYProperty().bind(c1.radiusProperty().subtract((10)));
            arc.setFill(fanColor);
            arc.setType(ArcType.ROUND); // Set arc type
            getChildren().add(arc);

            Timeline timeline = new Timeline();
            timeline.setCycleCount(2);
            //timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),);

        }
    }

        public void move()
        {

        }

    }

