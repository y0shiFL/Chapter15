package CH_15_3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestCalc extends Application {

    private TextField tfInitialInvestment = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfFutureAmt = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Initial Investment:"), 0, 0);
        gridPane.add(tfInitialInvestment, 1, 0);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 1);
        gridPane.add(tfAnnualInterestRate, 1, 1);
        gridPane.add(new Label("Number of Years:"), 0, 2);
        gridPane.add(tfNumberOfYears, 1, 2);
        gridPane.add(new Label("Future Amount:"), 0, 3);
        gridPane.add(tfFutureAmt, 1, 3);
        gridPane.add(btCalculate, 1, 4);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfInitialInvestment.setAlignment(Pos.BOTTOM_RIGHT);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureAmt.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureAmt.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // Process events
        btCalculate.setOnAction(e -> calculateFutureValue());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("LoanCalculator"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void calculateFutureValue() {
        // Get values from text fields
        double investment = Double.parseDouble(tfInitialInvestment.getText());
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        interest /= 100;  // 5 percent is really .05
        int years = Integer.parseInt(tfNumberOfYears.getText());

        // future = investment * (1 + monthly rate) ^ (years*12)
        double future = investment * Math.pow((1 + interest/12), years * 12);
        tfFutureAmt.setText(String.format("$%.2f", future));
    }


    public static void main(String[] args) {
        launch(args);
    }

}
