package com.taschenrechner_u9;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculatorView {
    private Button addButton = new Button("+");
    private Button minusButton = new Button("-");
    private  Button DivisionButton = new Button("/");
    private Button MultiplicationButton = new Button("*");
    private Button clear = new Button("clear");
    private Button Exponent = new Button("^");
    private TextField numberField1 = new TextField();
    private TextField numberField2 = new TextField();
    private Label resultLabel = new Label("Result: ");
    public Scene createScene() {
            VBox layout = new VBox(10);
        HBox options = new HBox(6);
        options.getChildren().addAll(addButton, minusButton, DivisionButton, MultiplicationButton, Exponent, clear);
            layout.getChildren().addAll(numberField1, numberField2,options,  resultLabel);
            return new Scene(layout, 300, 200);
    }
//hier: fehlende getter-Methoden implementieren
    public Button getAddButton(){
            return addButton;
    }
    public Button getMinusButton(){return minusButton;}
    public Button getDivisionButton(){return DivisionButton;}
    public Button getMultiplicationButton(){return MultiplicationButton;}
    public Button getExponentButton(){return  Exponent;}
    public Button getClear(){return clear;}
    public TextField getNumberField1(){
            return numberField1;
    }
    public TextField getNumberField2(){
        return numberField2;
    }
    public Label getResultLabel(){
            return resultLabel;
    }


    }

