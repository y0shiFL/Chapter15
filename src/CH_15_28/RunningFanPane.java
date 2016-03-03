package CH_15_28;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private int startAngle = 0;
    Group listOfArcs = new Group();

    public RunningFanPane(int radius, Color fanColor)
    {
        Circle c1 = new Circle(radius, Color.WHITE);
        c1.centerXProperty().bind(widthProperty().divide(2));
        c1.centerYProperty().bind(heightProperty().divide(2));
        c1.setStroke(Color.BLACK);
        getChildren().add(c1);

        int a = startAngle;
        for(int i=0; i<4; i++, a+=90) {
            // Create an arc
            Arc arc = new Arc(0, 0, radius, radius, a, 35);
            arc.centerXProperty().bind(c1.centerXProperty());
            arc.centerYProperty().bind(c1.centerYProperty());
            arc.radiusXProperty().bind(c1.radiusProperty().subtract((10)));
            arc.radiusYProperty().bind(c1.radiusProperty().subtract((10)));
            arc.setFill(fanColor);
            arc.setType(ArcType.ROUND); // Set arc type
            listOfArcs.getChildren().add(arc);
        }
        getChildren().add(listOfArcs);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(.3), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    EventHandler<ActionEvent> eventHandler = e -> {
        startAngle += 1;
        int a=startAngle;
        for(Node n : listOfArcs.getChildren()){
            Arc arc = (Arc)n;
            arc.setStartAngle(a);
            if(a>=270)
                a-=270;
            else
            a+=90;
        }
    };
}



