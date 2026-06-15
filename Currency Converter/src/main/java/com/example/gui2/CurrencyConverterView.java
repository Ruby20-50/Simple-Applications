package com.example.gui2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


//this is an alternative to the fxml file
// can work anstead of but not togather with fxml file
public class CurrencyConverterView {
    private TextField amountField = new TextField("");
    private ComboBox sourceCurrency = new ComboBox();
    private ComboBox targetCurrency = new ComboBox();
    private Button Swap = new Button("Swap");
    private Label resultLabel = new Label("Result: ");

    public Scene createScene(){
        VBox layout = new VBox();
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(amountField, sourceCurrency, targetCurrency, Swap, resultLabel);

        return new Scene(layout, 320, 240);
    }
    public TextField getAmountField(){
        return amountField;
    }
    public ComboBox getSourceCurrency() {
        return sourceCurrency;
    }
    public ComboBox getTargetCurrency(){
        return targetCurrency;
    }
    public Label getResultLabel(){
        return resultLabel;
    }
    public Button getSwap(){
        return Swap;
    }

}
