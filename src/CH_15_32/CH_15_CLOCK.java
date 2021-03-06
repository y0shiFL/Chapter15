package CH_15_32;/**
 * Created by yoshi on 3/18/2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class CH_15_CLOCK extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a clock and a label

        Button btnStop = new Button("Stop");
        Button btnStart = new Button("Start");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnStop,btnStart);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15);
        hBox.setPadding(new Insets(15,15,15,15));


        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setTop(new CustomPane("Detailed Clock"));
        pane.setCenter(new DetailedClock());
        pane.setBottom(hBox);

        Toolkit.getDefaultToolkit().beep();

        Scene scene = new Scene(pane, 360, 360);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Clock");
        primaryStage.show();
    }
}

class CustomPane extends StackPane
{
    public CustomPane(String title){
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: black");
        setPadding(new Insets(11.5,12.5,13.5,14.5));
    }

}
