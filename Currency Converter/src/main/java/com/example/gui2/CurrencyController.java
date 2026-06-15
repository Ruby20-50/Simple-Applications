package com.example.gui2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class CurrencyController implements Initializable {
   @FXML
    private TextField amountField;
    @FXML
    private ComboBox<String> sourceCurrencyBox;
    @FXML
    private ComboBox<String> targetCurrencyBox;
    @FXML
    private Label resultLabel;
    private CurrencyModel model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initialized model
        model = new CurrencyModel();
        // fill ComboBoxes with available currencies
        sourceCurrencyBox.getItems().addAll(model.getAvailableCurrencies());
        targetCurrencyBox.getItems().addAll(model.getAvailableCurrencies());

        // set the standard value (optional)
        sourceCurrencyBox.setValue("EUR");
        targetCurrencyBox.setValue("USD");

        amountField.textProperty().addListener((observable, oldValue, newValue) -> {
            // add filters
            if (!newValue.trim().isEmpty()) {
                handleConvert();
            } else {
                resultLabel.setText(""); // Clear result when field is empty
            }
        });

        // Add listeners to ComboBoxes for instant conversion when currency changes
        sourceCurrencyBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            handleConvert();
        });

        targetCurrencyBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            handleConvert();
        });

    }


    private void handleConvert() {
        try {
            // Eingaben validieren
            // in this context is redundant because the event listener is already checking the empty values
            String amountText = amountField.getText();
            if (amountText == null || amountText.trim().isEmpty()) {
                resultLabel.setText("Please enter amount!");
                return;
            }


            String sourceCurrency = sourceCurrencyBox.getValue();
            String targetCurrency = targetCurrencyBox.getValue();
            // in the context this filter becomes redundant, because the values are preset and cannot be empty
            if (sourceCurrency == null || targetCurrency == null) {
                resultLabel.setText("Please choose currency!");
                return;
            }

            double amount = Double.parseDouble(amountText); // parse amount and convert

            if (amount < 0) {
                resultLabel.setText("amount must be positive!");
                return;
            }
            double result = model.convert(amount, sourceCurrency, targetCurrency); //convert (Model)

            resultLabel.setText(String.format("%.2f %s", result, targetCurrency));//show result (View)

        } catch (NumberFormatException e) {
            resultLabel.setText("Ungültige Eingabe! Bitte nur Zahlen verwenden.");
        } catch (IllegalArgumentException e) {
            resultLabel.setText("Fehler: " + e.getMessage());
        }
    }
    @FXML
    private void handleSwap() {
        String value1 = targetCurrencyBox.getValue();
        String value2 = sourceCurrencyBox.getValue();

        sourceCurrencyBox.setValue(value1);
        targetCurrencyBox.setValue(value2);
    }
}