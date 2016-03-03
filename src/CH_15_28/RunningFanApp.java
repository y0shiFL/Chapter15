package CH_15_28;/**
 * Created by yoshi on 3/2/2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RunningFanApp extends Application {

    @Override
    public void start(Stage primaryStage) {


            HBox row1 = new HBox(10);
            HBox row2 = new HBox(10);

            VBox vboxPane = new VBox(10);
            vboxPane.setPadding(new Insets(11,12,13,14));

            vboxPane.getChildren().addAll(row1,row2);


            int r = 80;

            row1.getChildren().add(new RunningFanPane(r, Color.RED));
            row1.getChildren().add(new RunningFanPane(r, Color.BLUE));
            row2.getChildren().add(new RunningFanPane(r, Color.GREEN));
            row2.getChildren().add(new RunningFanPane(r, Color.color(Math.random(),Math.random(),Math.random())));



            Scene scene = new Scene(vboxPane, 360, 360);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hazards");
            primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }

}

