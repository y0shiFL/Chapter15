import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Created by yoshi on 2/28/2016.
 */
public class RefreshCards extends Application {

    HBox hbox = new HBox();
    ArrayList<Image> deckImages = new ArrayList<>();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        for (int i = 1; i <= 52; i++) {
            String cardFilename = "CH_15_1/image/card/" + i + ".png";
            Image img = new Image(cardFilename);
            deckImages.add(img);
        }


        StackPane btpane = new StackPane();
        Button btRefresh = new Button("Refresh");
        btpane.getChildren().add(btRefresh);
        btpane.setAlignment(Pos.CENTER);
        btRefresh.setOnAction(new RefreshHandler());

        // add 5 panes
        dealAgain();

        BorderPane pane = new BorderPane();
        pane.setCenter(hbox);
        pane.setBottom(btpane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("5 Random cards");
        primaryStage.show();
    }

    private void  dealAgain() {
        hbox.getChildren().clear();
        java.util.Collections.shuffle(deckImages);
        hbox.getChildren().add( new ImageView(deckImages.get( 0 )));
        hbox.getChildren().add( new ImageView(deckImages.get( 1 )));
        hbox.getChildren().add( new ImageView(deckImages.get( 2 )));
        hbox.getChildren().add( new ImageView(deckImages.get( 3 )));
        hbox.getChildren().add( new ImageView(deckImages.get( 4 )));
    }

    class RefreshHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            dealAgain();
        }
    }
}


