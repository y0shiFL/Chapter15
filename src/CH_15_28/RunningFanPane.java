package CH_15_28;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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

    Timeline timeline;

    public RunningFanPane(int radius, Color fanColor)
    {
        setPadding(new Insets(10));
        Circle c1 = new Circle(radius, Color.WHITE);
        c1.centerXProperty().bind(widthProperty().divide(2));
        c1.centerYProperty().bind(heightProperty().divide(2));
        c1.setStroke( fanColor );
        getChildren().add(c1);

        for(int i=0, a=0; i<5; i++, a+=72) {
            // Create an arc
            Arc arc = new Arc(0, 0, radius, radius, a, 35);
            arc.centerXProperty().bind(c1.centerXProperty());
            arc.centerYProperty().bind(c1.centerYProperty());
            arc.radiusXProperty().bind(c1.radiusProperty().subtract((10)));
            arc.radiusYProperty().bind(c1.radiusProperty().subtract((10)));
            arc.setFill(fanColor);
            arc.setType(ArcType.ROUND); // Set arc type
            getChildren().add(arc);
        }

        timeline = new Timeline(new KeyFrame(Duration.millis(.5), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public enum FanDirection {CLOCKWISE, COUNTERCLOCKWISE };

    private FanDirection fanDirection = FanDirection.CLOCKWISE;

    public FanDirection getFanDirection() {
        return fanDirection;
    }

    public void setFanDirection(FanDirection fanDirection) {
        this.fanDirection = fanDirection;
    }

    public void pause() { timeline.pause(); }
    public void play() { timeline.play(); }
    
    public double someValue;



    EventHandler<ActionEvent> eventHandler = e -> {
        double angle = getRotate();
        angle +=  2 * (fanDirection == FanDirection.CLOCKWISE ? 1 : -1);
        angle %= 360;
        setRotate( angle );
    };


}

