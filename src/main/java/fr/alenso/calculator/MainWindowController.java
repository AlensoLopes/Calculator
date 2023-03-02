package fr.alenso.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML private Label resultLabel, historyLabel;

    String operator = "";
    private int num1;
    private boolean hist;

    public void init(Stage stage){
        /*resultLabel.setText("0");*/
    }

    public void onNumberClicked(ActionEvent event){
        if(hist){
            historyLabel.setText(resultLabel.getText());
            resultLabel.setText("");
            hist = false;
        }
        int value = Integer.parseInt(((Button) event.getSource()).getId().replace("btn", ""));
        resultLabel.setText(resultLabel.getText() + value);

    }

    public void onOperatorClicked(ActionEvent event){
        String symbols = ((Button) event.getSource()).getId();
        if(symbols.equals("equals")) {
            int num2 = Integer.parseInt(resultLabel.getText());
            switch (operator) {
                case "*" -> displayText(String.valueOf((num1 * num2)));
                case "/" -> {
                    if(num2 == 0) displayText("Error, you cannot divide by 0 !");
                    else displayText(String.valueOf(num1 / num2));
                }
                case "-" -> displayText(String.valueOf(num1- num2));
                case "+" -> displayText(String.valueOf(num1+ num2));
            }
            operator = ".";
            hist = true;
        }else if(symbols.equals("clear")){
            resultLabel.setText("");
            operator = ".";
        }else{
            switch (symbols){
                case "multiply" -> operator = "*";
                case "divide" -> operator = "/";
                case "minus" -> operator = "-";
                case "plus" -> operator = "+";
            }
            num1 = Integer.parseInt(resultLabel.getText());
            resultLabel.setText("");
        }
    }

    public void displayText(String args){
        resultLabel.setText(args);
    }
}
