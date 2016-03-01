package CH_15_5;/**
 * Created by yoshi on 2/29/2016.
 */

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestmentCalculator extends Application
{

    private TextField InitialInvestment = new TextField();
    private TextField AnnualInterestRate = new TextField();
    private TextField NumberOfYears = new TextField();
    private TextField FutureValue = new TextField();
    private Button btCalculate = new Button("Calculate");


    @Override
    public void start(Stage primaryStage)
    {

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Initial Investment: "),0,0);
        gridPane.add(InitialInvestment, 1,0);
        gridPane.add(new Label("Annual Interest Rate: "), 0,1);
        gridPane.add(AnnualInterestRate, 1,1);
        gridPane.add(new Label("Number of Years: "), 0,2);
        gridPane.add(NumberOfYears, 1,2);
        gridPane.add(new Label("Future Value: "),0,3);
        gridPane.add(FutureValue,1,3);
        gridPane.add(btCalculate, 1,4);

        gridPane.setAlignment(Pos.CENTER);
        InitialInvestment.setAlignment(Pos.BOTTOM_RIGHT);
        AnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        NumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        FutureValue.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        btCalculate.setOnAction(e-> calcFV());


        Scene scene = new Scene(gridPane,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Future Value Calculator");
        primaryStage.show();
    }

    private void calcFV()
    {
        double investment  = Double.parseDouble(InitialInvestment.getText());
        double interest = Double.parseDouble(AnnualInterestRate.getText());
        interest /= 100;
        int year = Integer.parseInt(NumberOfYears.getText());


        double fv =  investment * Math.pow((1 + interest/12), year * 12);
        FutureValue.setText(String.format("$%.2f", fv));
    }

    public static void main(String[] args) {
        launch(args);
    }
}


