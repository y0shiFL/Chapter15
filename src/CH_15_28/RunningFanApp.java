package CH_15_28;/**
 * Created by yoshi on 3/2/2016.
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RunningFanApp extends Application {

    private RunningFanPane fan1;
    private RunningFanPane fan2;
    private RunningFanPane fan3;
    private RunningFanPane fan4;

    private RunningFanPane selectedFan;

    @Override
    public void start(Stage primaryStage) {

        int r = 80;
        fan1 = new RunningFanPane(r, Color.RED);
        fan2 = new RunningFanPane(r, Color.BLUE);
        fan3 = new RunningFanPane(r, Color.GREEN);
        fan4 = new RunningFanPane(r, Color.color(Math.random(),Math.random(),Math.random()));
        selectedFan = fan1;

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setStyle("-fx-border-color: black");
        gridPane.add(fan1, 0, 0);
        gridPane.add(fan2, 1, 0);
        gridPane.add(fan3, 0, 1);
        gridPane.add(fan4, 1, 1);

        ToggleGroup group = new ToggleGroup();
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null) {
                    selectedFan = (RunningFanPane)newValue.getUserData();
                    selectedFan.setStyle("-fx-border-color: DarkGray");
                }
                if(oldValue != null){
                    ( (RunningFanPane)oldValue.getUserData() ).setStyle("");
                }
            }
        });

        RadioButton rb1 = new RadioButton("1");
        RadioButton rb2 = new RadioButton("2");
        RadioButton rb3 = new RadioButton("3");
        RadioButton rb4 = new RadioButton("4");
        rb1.setUserData(fan1);
        rb2.setUserData(fan2);
        rb3.setUserData(fan3);
        rb4.setUserData(fan4);
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);
        rb1.setSelected(true);
        HBox rbRow1 = new HBox(5,rb1,rb2);
        HBox rbRow2 = new HBox(5,rb3,rb4);

        Button btReverse = new Button("Reverse");
        btReverse.setOnAction(e-> { selectedFan.setFanDirection( RunningFanPane.FanDirection.COUNTERCLOCKWISE ); } );
        Button btForward = new Button("Forward");
        btForward.setOnAction(e-> { selectedFan.setFanDirection( RunningFanPane.FanDirection.CLOCKWISE ); } );
        Button btPlay = new Button("Go");
        btPlay.setOnAction(e-> { selectedFan.play(); } );
        Button btPause = new Button("Stop");
        btPause.setOnAction(e-> { selectedFan.pause(); } );

        VBox buttonPane = new VBox(10);
        buttonPane.setPadding(new Insets(10));
        buttonPane.getChildren().addAll( rbRow1, rbRow2, btReverse, btForward, btPlay, btPause);
        buttonPane.setStyle("-fx-border-color: DarkGray");

        BorderPane borderPane = new BorderPane(gridPane,null,buttonPane,null,null);

        Scene scene = new Scene(borderPane, 480, 360);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hazards");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

