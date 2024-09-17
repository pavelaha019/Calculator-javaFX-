/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package assignment.pkg05_221074002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author pavel ahamed
 */


public class FXMLDocumentController implements Initializable {
    @FXML
    private Button powerQuve;
    @FXML
    private Button powerSquare;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button zero;
    @FXML
    private Label label;  
    
    private StringBuilder input = new StringBuilder();
    private double firstOperand = 0;
    private String operator = "";
    private boolean start = true;
    @FXML
    private Button delete;
    @FXML
    private Button clear;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button theree;
    @FXML
    private Button minus;
    @FXML
    private Button equal;
    @FXML
    private Button plus;

    @FXML
    public void handleAction(ActionEvent event) {
         System.out.println("Deleted last input: ");
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "C":
                input.setLength(0);
                label.setText("");
                firstOperand = 0;
                operator = "";
                start = true;
                System.out.println("Clear all");
                break;
            case "Del":
                if (input.length() > 0) {
                    input.setLength(input.length() - 1);
                    label.setText(input.toString());
                    System.out.println("Deleted last input: " + input.toString());
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "X^2":
            case "X^3":
                operator = buttonText;
                firstOperand = Double.parseDouble(input.toString());
                input.setLength(0);
                System.out.println("Operator selected: " + operator);
                System.out.println("First operand: " + firstOperand);
                break;
            case "=":
                double secondOperand = Double.parseDouble(input.toString());
                double result = calculate(firstOperand, secondOperand, operator);
                label.setText(String.valueOf(result));
                input.setLength(0);
                input.append(result);
                System.out.println("Second operand: " + secondOperand);
                System.out.println("Result: " + result);
                break;
            default:
                input.append(buttonText);
                label.setText(input.toString());
                System.out.println("Current input: " + input.toString());
        }
    }

    private double calculate(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    label.setText("Error");
                    System.out.println("Division by zero error");
                    return 0;
                }
            case "X^2":
                return firstOperand * firstOperand;
            case "X^3":
                return firstOperand * firstOperand * firstOperand;
            default:
                return 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic if needed
    }
}
